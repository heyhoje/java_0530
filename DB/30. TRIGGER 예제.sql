/*
트리거 : 이벤트(insert, update, delete)에 반응해 (미리 지정된 작업을) 자동으로 실행되는 작업 
=> 데이터 일관성을 유지하기 위해

트리거 예시
- 쇼핑몰에서 회원이 주문을 완료하면, 주문리스트 테이블에 데이터가 추가 => 옵션 수량이 변경(10개 -> 8개)
트리거 특징
- old와 new를 통해 이벤트가 발생된 데이터에 접근할 수 있다. 
	- INSERT 이벤트에는 이전 데이터가 없기 때문에 NEW를 통해서만 추가된 데이터에 접근할 수 있다.
	- DELETE 이벤트에는 새로운 데이터가 없기 때문에 OLD를 통해서만 삭제된 데이터에 접근할 수 있다. 
    - UPDATE 이벤트에는 수정되기 전 데이터는 OLD, 수정된 데이터는 NEW로 접근할 수 있다.
    - OLD.속성명 / NEW.속성명
- 이벤트가 발생된 데이터는 수정할 수 없다... (insert 추가된 이후 바로 trigger 사용 불가능)

DROP TRIGGER IF EXSITS 트리거명; 
DELIMITER // 
CREATE TRIGGER 트리거명 트리거시간 이벤트명 ON 테이블명
FOR EACH ROW
BEGIN
// 구현
END //
DELIMITER ; 

트리거시간 : BEFORE | AFTER
이벤트명 : INSERT | UPDATE | DELETE
ㄴ데이터 변동이 있을때, trigger 적용
*/

-- 트리거 한번만 설명해줄사람.....? 8/17 또까인
USE TEST;
-- 회원이 등록되면, 대시보드 테이블에 등록된 회원수를 증가시키는 드리거 
DROP TRIGGER IF exists insert_member; 

delimiter // 
create trigger insert_member after insert on member
for each row
begin
	update dash_board
	set 
		DB_MEMBER = DB_MEMBER + 1;
end //
delimiter ;

INSERT INTO MEMBER(ME_ID, ME_PW) VALUES('ABC123', 'ABC123'), ('ADMIN', 'ADMIN');

-- 회원이 게시글을 작성하면, 회원의 작성된 게시글 수가 증가하는 트리거 

DROP TRIGGER IF EXISTS INSERT_BOARD;

DELIMITER // 
CREATE TRIGGER INSERT_BOARD AFTER INSERT ON board
FOR EACH ROW
BEGIN
	UPDATE MEMBER
	SET 
		ME_BOARD_COUNT = ME_BOARD_COUNT + 1
	WHERE
		ME_ID = NEW.BO_ME_ID; -- insert = new 새로 추가된 게시글의 아이디정보를 가져온다 
END //
DELIMITER ; 

INSERT INTO BOARD(BO_TITLE, BO_ME_ID) VALUES('게시글', 'ABC123');

-- 게시글이 삭제됐을 때 해당 게시글을 작성한 회원의 게시글 수를 1 줄이는 트리거

DROP TRIGGER IF EXISTS DELETE_BOARD;

DELIMITER // 
CREATE TRIGGER DELETE_BOARD AFTER DELETE ON BOARD
FOR EACH ROW
BEGIN
	UPDATE MEMBER
    SET
		ME_BOARD_COUNT = ME_BOARD_COUNT - 1
	WHERE
		ME_ID = OLD.BO_ME_ID; -- DELETE 는 새로 추가된 데이터, NEW가 없으니 (OLD.속성명)
END //
DELIMITER ; 

DELETE FROM BOARD WHERE BO_NUM = 3;

-- 쇼핑몰 -- 아직 데이터쿼리랑 정리 안됐는데 쇼핑몰을 써먹다니요------------------------

-- 회원이 제품을 주문했을 때 필요한 트리거 (begin 위로만 맞음, 업데이트 밑에 못씀..)
-- 주문 테이블에 데이터 추가 => '주문 리스트'에 데이터가 추가 => 각 주문 리스트에 맞는 옵션의 수량이 변경 
-- 주문 리스트에 데이터가 추가될 때 각 주문 리스트에 맞는 옵션 수량이 변경되는 트리거 !
USE SHOPPINGMALL;
DROP TRIGGER IF EXISTS INSERT_ORDER_LIST;

DELIMITER // 
CREATE TRIGGER INSERT_ORDER_LIST AFTER INSERT ON ORDER_LIST
FOR EACH ROW
BEGIN
	UPDATE `OPTION`
	SET 
		OP_AMOUNT = OP_AMOUNT - NEW.OL_AMOUNT
	WHERE
		OP_NUM = NEW.OL_OP_NUM;
END //
DELIMITER ;

-- MEMBER = ORDER / BOARD = ORDER_LIST 인건가????
-- 주문번호가 3번이 없는 경우만 아래 코드 적용
INSERT INTO `ORDER`(OR_NUM, OR_TOTAL, OR_PRICE, OR_USE_POINT, OR_SAVE_POINT, OR_ME_ID, OR_AD_NUM)
VALUES(3, 45000, 45000, 0, 4500, 'qwe123', 2);
-- 아래 쿼리가 실행될 때 트리거가 동작되어야 함
INSERT INTO ORDER_LIST(OL_AMOUNT, OL_PRICE, OL_OR_NUM, OL_OP_NUM)
VALUES(1, 15000, 3, 1), (1, 30000, 3, 3);

-- 연계된 데이터의 일관성을 유지하기 위해 트리거를 사용한다. 

-- qwe123회원이 주문한 내역을 구매확정으로 바꾸면 (OR_STATE), 포인트가 적립되는 트리거(못품X, SET부분만 맞춤)
DROP TRIGGER IF EXISTS UPDATE_ORDER;

DELIMITER // 
CREATE TRIGGER UPDATE_ORDER AFTER UPDATE ON `ORDER`
FOR EACH ROW
BEGIN
	-- POINT에 PO_AMOUNT가 바뀌어야하는건가? MEMBER에 ME_POINT도 같이 바뀌는건가? 
    -- OR_STATE가 구매확정이면 포인트를 적립
	IF NEW.OR_STATE = '구매확정' THEN
		UPDATE MEMBER
        SET
			ME_POINT = ME_POINT + NEW.OR_SAVE_POINT
		WHERE ME_ID = NEW.OR_ME_ID;
    END IF;
END //
DELIMITER ;

UPDATE `ORDER` SET OR_STATE = '구매확정' WHERE OR_NUM = 3;


-- 트리거 마무리
-- 간단한 요구사항 / ERD/ 테이블