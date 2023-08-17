-- TRIGGER 활용 -- 
-- 안됨안됨 나만 안되냐ㅗㄱ곡고고고고고고오오오(약간 이해함 8/17)(데이터 트리거 다 잘됨)

USE BOOK;
-- '대출 테이블에 데이터가 추가' 됐을 때 실행 되어야 하는 쿼리를 트리거를 이용하여 작성한 후 적용
-- (시작부터 뭔지 이해가 안된다.)

DROP TRIGGER IF EXISTS INSERT_LOAN;

DELIMITER // 
CREATE TRIGGER INSERT_LOAN AFTER INSERT ON LOAN
FOR EACH ROW
BEGIN
	-- NEW.LO_ME_ID 회원이 도서 NEW.LO_BO_NUM 을 예약했으면(예약한 경우)
	IF (
		SELECT 
			COUNT(*) 
		FROM 
			RESERVATION 
		WHERE 
			RE_ME_ID = NEW.LO_ME_ID AND 
			RE_BO_NUM = NEW.LO_BO_NUM) > 0
	THEN
        -- (해당 도서를 대출 할 때 예약 내역이 있으면) 
        -- 예약 테이블에 테이터를 삭제하고, 
		DELETE FROM RESERVATION 
        WHERE 
			RE_ME_ID = NEW.LO_ME_ID 
			AND RE_BO_NUM = NEW.LO_BO_NUM;
		
        -- 도서의 예약 상태를 예약가능으로 수정
        UPDATE BOOK
        SET
			BO_POSSIBLE_RESERVATION = (
				SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '예약가능'
			)
		WHERE 
			BO_NUM = NEW.LO_BO_NUM;

    END IF;
	-- 도서 상태를 대출중으로 수정(예약을 안해도 동일하게 적용) ㅡ 뒤에 괄호는 무슨소리지?? 예약을 안했던 도서라도 대출중으로 바꾸라는건가???
    UPDATE BOOK
	SET
		BO_POSSIBLE_LOAN = (
			SELECT BS_NUM FROM BOOK_STATE WHERE BS_DESC = '대출중'
		)
	WHERE 
		BO_NUM = NEW.LO_BO_NUM;
        
	-- 회원이 대출한 도서 수를 증가
	UPDATE MEMBER
    SET ME_BOOK_COUNT = ME_BOOK_COUNT + 1
    WHERE ME_ID = NEW.LO_ME_ID;
END //
DELIMITER ; 

INSERT INTO LOAN(LO_DATE, LO_ME_ID, LO_BO_NUM, LO_EXPECTED_DATE)
	VALUES(DATE_FORMAT(NOW(), '%Y-%m-%d'), 'QWE123', '500.ABC123 V1 1',
		DATE_FORMAT( DATE_ADD(NOW(), INTERVAL 14 DAY), '%Y-%m-%d'));

INSERT INTO LOAN(LO_DATE, LO_ME_ID, LO_BO_NUM, LO_EXPECTED_DATE)
	VALUES(DATE_FORMAT(NOW(), '%Y-%m-%d'), 'ADMIN', '103.987DD',
		DATE_FORMAT( DATE_ADD(NOW(), INTERVAL 14 DAY), '%Y-%m-%d'));
        
-- 된지안된지 모르겠고 괜히 데이터만 꼬인거같다.. => 잘된거같다 7/17

-- 예약내역에 없었고, 예약상태로 변경 안된거같음(확인요청) ㅡ DD는 원래 예약안되는 도서 / 3 1 인게 맞는거같음
-- 대출중으로 바뀜 / 5 5 
-- 회원이 대출한 도서수 증가함 / 1 2 
-- 데이터 인서트도 잘됨!




-- 트리거 예제 참고 --
-- DROP TRIGGER IF EXISTS INSERT_BOARD;

-- DELIMITER // 
-- CREATE TRIGGER INSERT_BOARD AFTER INSERT ON board
-- FOR EACH ROW
-- BEGIN
-- 	UPDATE MEMBER
-- 	SET 
-- 		ME_BOARD_COUNT = ME_BOARD_COUNT + 1
-- 	WHERE
-- 		ME_ID = NEW.BO_ME_ID; -- insert = new 새로 추가된 게시글의 아이디정보를 가져온다 
-- END //
-- DELIMITER ; 

-- INSERT INTO BOARD(BO_TITLE, BO_ME_ID) VALUES('게시글', 'ABC123');
