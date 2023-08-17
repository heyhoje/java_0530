USE BOOK;
-- 8/16 -- 
-- 도서 상태 샘플 데이터를 추가
INSERT INTO BOOK_STATE(BS_DESC) 
VALUES('예약가능'), ('예약중'), ('도서 상태에 의한 예약 불가능'), 
('대출가능'), ('대출중'), ('도서 상태에 의한 대출 불가능');

-- 도서 샘플 데이터 추가
-- 101.1ABC12, 자바의 정석, 남궁성, 도우출판, 일반도서(대출, 예약이 가능한 도서)
-- 103.987DD, Do it! 점프 투 파이썬, 박응용, 이지스퍼블리싱, 예약이 불가능한 도서
-- 500.ABC123 V1 1, 해리포터와 마법사의 돌 1, J.K. 롤링저자/강동혁 엮은이, 문학수첩, 일반도서
INSERT INTO BOOK(BO_NUM, BO_TYPE, BO_TITLE, BO_PUBLISHER, BO_AUTHOR, BO_POSSIBLE_LOAN, BO_POSSIBLE_RESERVATION)
VALUES('101.1ABC12', '코딩', '자바의 정석', '도우출판', '저자 : 남궁성', 4, 1),
('103.987DD', '코딩', 'Do it! 점프 투 파이썬', '이지스퍼블리싱', '저자 : 박응용', 4, 3),
('500.ABC123 V1 1', '외국소설', '해리포터와 마법사의 돌 1', '문학수첩', '저자 : J.K. 롤링/엮은이 강동혁', 4, 1);

-- 8/17 --
-- 회원/대출/예약 // 조회

-- 회원 샘플 데이터를 추가
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_BIRTHDAY, ME_AUTHORITY)
VALUES('ADMIN', 'ADMIN', '011-1234-5678', '2000-01-01', 'ADMIN'),
('QWE123', 'QWE123', '010-1111-2222', '2002-02-02', 'USER');

-- QWE123회원이 자바의 정석을 (예약)했을 때 적용해야하는 쿼리 -- 예약테이블에 안들어가요....들어감! 쿼리 2개 각각이었음
INSERT INTO RESERVATION(RE_RESERVATION_DATE, RE_ME_ID, RE_BO_NUM)
	SELECT DATE_FORMAT(NOW(),'%Y-%m-%d'), 'QWE123', 
    BO_NUM FROM BOOK WHERE BO_TITLE = '자바의 정석';

UPDATE BOOK 
SET 
    BO_POSSIBLE_RESERVATION = (SELECT 
            BS_NUM
        FROM
            BOOK_STATE
        WHERE
            BS_DESC = '예약중')
WHERE
    BO_NUM = '101.1ABC12'; -- UPDATE하는 테이블이 BOOK인데 BOOK에서 조회해서 값을 가져올 수 없다(왜는 왜 안알려줘?? - 트리거처럼 이벤트발생하는 테이블은 동시에 조회안되는 그건가?) 
							 -- 프로시저 처럼 어쩌구 저쩌구 변수 선언하기엔 너무 복잡해서 걍 BO_NUM 값을 가져옴

-- QWE123회원이 예약한 자바의 정석을 （대출）했을 때 적용해야하는 쿼리
-- 대출 테이블에 데이터 추가+
INSERT INTO LOAN(LO_DATE, LO_ME_ID, LO_BO_NUM, LO_EXPECTED_DATE)
	SELECT DATE_FORMAT(NOW(), '%Y-%m-%d'), 'QWE123', BO_NUM, 
    DATE_FORMAT(DATE_ADD( NOW(), INTERVAL 14 DAY), '%Y-%m-%d')
    FROM BOOK
    WHERE BO_TITLE = '자바의 정석'; 
-- 예약 테이블에 데이터를 삭제-
DELETE FROM RESERVATION 
WHERE
    RE_ME_ID = 'QWE123'
    AND RE_BO_NUM = (SELECT 
        BO_NUM
    FROM
        BOOK
    WHERE
        BO_TITLE = '자바의 정석');
-- 도서 상태를 수정 
UPDATE BOOK 
SET BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출중'),
	BO_POSSIBLE_RESERVATION = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약가능')
    WHERE BO_NUM = '101.1ABC12';
-- 회원이 대출한 도서의 수를 증가
UPDATE MEMBER SET ME_BOOK_COUNT = ME_BOOK_COUNT + 1
WHERE ME_ID = 'QWE123';

-- (뭐가 이렇게 넣고 빼고 업데이트하고가 많지 .........다른것도.....)

-- QWE123회원이 자바의 정석을 (반납)했을 때 필요한 쿼리 
-- 대출 테이블에 반납일을 수정
UPDATE LOAN SET LO_RETURN_DATE = DATE_FORMAT(NOW(), '%Y-%m-%d') 
WHERE LO_ME_ID = 'QWE123' 
	AND LO_BO_NUM = (SELECT BO_NUM FROM BOOK WHERE BO_TITLE = '자바의 정석') ;

-- 도서 테이블에 해당 도서의 도서상태를 수정
UPDATE BOOK SET BO_POSSIBLE_LOAN = (SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출가능')
WHERE BO_NUM = '101.1ABC12';

-- 회원이 대출한 도서 수를 감소 
UPDATE MEMBER 
SET 
    ME_BOOK_COUNT = ME_BOOK_COUNT - 1
WHERE
    ME_ID = 'QWE123';

-- 연체일을 계산해서 회원 테이블을 수정(에러  -확인필요) 
UPDATE MEMBER 
SET 
    ME_TOTAL_OVERDUE = ME_TOTAL_OVERDUE + (SELECT 
            -- LOAN.*, -- 얘 왜있어????
                CASE
                    WHEN DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE) < 1 THEN 0
                    ELSE DATEDIFF(LO_RETURN_DATE, LO_EXPECTED_DATE)
                END AS 연체일
        FROM
            LOAN
        WHERE
            LO_ME_ID = 'QWE123'
                AND LO_BO_NUM = '101.1ABC12')
WHERE
    ME_ID = 'QWE123';
-- 괄호안에 들어갈 부분 확인차(근데 이거 왜 LOAN.* 이 있고, LOAN으로부터 조건 확인해????)
SELECT LOAN.*,
	CASE WHEN DATEDIFF(LO_RETURNZ_DATE, LO_EXPECTED_DATE) < 1 THEN 0
		ELSE DATEDIFF(LO_RETURNZ_DATE, LO_EXPECTED_DATE)
    END AS 연체일
FROM LOAN
WHERE LO_ME_ID = 'QWE123' AND LO_BO_NUM = '101.1ABC12';

-- 회원이 대출한 모든 도서가 반납됐을 때, 연체일이 있으면 다음날부터 (연체 적용)이 되도록 수정 
UPDATE MEMBER 
SET 
    ME_APPLY_OVERDUE = (SELECT 
            CASE
                    WHEN
                        ME_BOOK_COUNT = 0
                            AND ME_TOTAL_OVERDUE != 0
                    THEN
                        DATE_FORMAT(DATE_ADD(NOW(),
                                    INTERVAL ME_TOTAL_OVERDUE DAY),
                                '%Y-%m-%d')
                    ELSE NULL
                END AS T
        FROM
            (SELECT * FROM MEMBER) AS TMP -- 문법상 문제를 해결하기 위해 MEMBER인것을 알지만, TMP로 이름붙여서 실행
        WHERE
            ME_ID = 'QWE123')
WHERE
    ME_ID = 'QWE123';
-- 괄호안에 들어갈 부분 확인
SELECT 
	*,
    CASE
        WHEN ME_BOOK_COUNT = 0 AND ME_TOTAL_OVERDUE != 0 THEN 
			DATE_FORMAT(DATE_ADD(NOW(), 
					INTERVAL ME_TOTAL_OVERDUE DAY),
					'%Y-%m-%d')
        ELSE NULL 
    END AS T
FROM
    MEMBER
WHERE ME_ID = 'QWE123';
