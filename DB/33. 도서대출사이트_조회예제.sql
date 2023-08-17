-- (예약 가능)한 도서를 조회하는 쿼리
SELECT * FROM BOOK
-- WHERE BO_POSSIBLE_RESERVATION = 1; -- > 서브쿼리 이용 / 실제 웹사이트 구현할때는 서브쿼리 많이 쓰진 않을 것임
WHERE BO_POSSIBLE_RESERVATION = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약가능');

-- (대출 가능)한 도서를 조회하는 쿼리
SELECT * FROM BOOK
WHERE BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출가능') 
AND BO_POSSIBLE_RESERVATION IN (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC != '예약중');

-- 'QWE123회원'이 (대출 가능)한 도서를 조회하는 쿼리 
-- (자바의 정석을 예약했기 때문에 3개가 조회되야함)
SELECT BOOK.* FROM BOOK 
	LEFT JOIN RESERVATION ON RE_BO_NUM = BO_NUM -- 예약과 JOIN/에약이 안된, 대출가능한 도서도 조회해야함. inner join 말고 left join 
WHERE BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출가능') 
-- AND BO_POSSIBLE_RESERVATION IN (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC != '예약중');
-- left join 결과를 보면 예약된 도서가 테이블에 붙음(?????) // LEFT JOIN도 이해안될판에 이건 또 무슨소리였담
AND (RE_NUM IS NULL OR RE_ME_ID = 'QWE123');

-- QWE123회원이 (현재 대출한 도서)를 조회하는 쿼리
SELECT * FROM book
	JOIN LOAN ON LO_BO_NUM = BO_NUM
WHERE LO_ME_ID = 'QWE123' AND LO_RETURN_DATE IS NULL;

-- --------------------------
-- 각 회원들의 (대출이 불가능한 기간)을 조회하는 쿼리. 
-- 대출이 가능한 회원은 대출가능으로 표시하고, 대출이 불가능한 회원은 언제까지인지를 표시하도록 작성
-- (CASE WHEN을 통해서 내가 원하는 형태로 자료를 보여줄 수 있는지 확인하는 문제) 
SELECT ME_ID AS 아이디,
	CASE WHEN ME_APPLY_OVERDUE IS NULL THEN '대출가능'
    ELSE ME_APPLY_OVERDUE -- 얘는 왜 지 혼자만 있죠????? 
    END AS 대출불가일
FROM MEMBER;

-- 각 '도서별' (대출 횟수)를 조회하는 쿼리
SELECT BO_TITLE AS 도서명, COUNT(LO_NUM) AS 대출횟수 FROM BOOK
	LEFT JOIN LOAN ON LO_BO_NUM = BO_NUM -- 예약????목록에 없는 책은 조회되지 않으니 outer join(left join)
    GROUP BY BO_NUM; -- 근데 대출했다가 반납하면 대출목록에서 삭제되서 LO_NUM 없지 않나???

-- '회원별' (연체 횟수)를 조회하는 쿼리
SELECT ME_ID AS 아이디, COUNT(LO_EXPECTED_DATE < LO_RETURN_DATE) AS 연체횟수
FROM MEMBER
	LEFT JOIN LOAN ON LO_ME_ID = ME_ID
GROUP BY ME_ID;

-- 도서를 '가장 많이' '대출'한 회원을 조회하는 쿼리, 대출수가 같은 경우 아이디순으로 정렬 후 첫번째 회원을 선택
--        ㄴ정렬(order by)/LIMIT
SELECT ME_ID AS 아이디, COUNT(LO_NUM) AS 대출도서수 FROM MEMBER 
	-- ME_BOOK_COUNT로는 안되나? LOAN이랑 쪼인 할거라서 이걸로 가는건가? -> OK, FROM MEMBER있어서 저 속성값?으로도 되는듯
	LEFT JOIN LOAN ON LO_ME_ID = ME_ID -- 대여하지 않은 회원은 조회가 안되기 때문에 outer join으로 전체회원 조회
GROUP BY ME_ID
ORDER BY 대출도서수 DESC, 아이디 ASC
LIMIT 1;