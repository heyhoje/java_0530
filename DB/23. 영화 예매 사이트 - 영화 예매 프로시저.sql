/*
프로시저 (!= 함수)
- 일련의 쿼리를 마치 하나의 함수처럼 실행하기 위한 쿼리의 집합
- 예시
	- 대학생 학번을 생성하기 위한 프로시저 : 입학년도, 학과번호를 이용하여 학번을 생성할 수 있다. 

(이러한 차이점이 있다~ 정도만 알아두면 됨)
			함수 			프로시저
매개변수  		여러개(입력)	여러개(입력|출력|입출력)
리턴값 		1개, 필수 	여러개, 선택(매개변수를 통해 전달)
select문		사용 가능		사용 불가능 
처리장소		클라이언트		서버(속도가 조금 더 빠름)

프로시저 정의/생성
delimiter // -- 문장의 끝을 //로 인식하게 해줌
create procedure 프로시저명(
[ (in|out|inout) 매개변수명 타입 
]
)
begin
	-- 프로시저 코드 구현 
    -- 변수 선언하는 방법
		declare 변수명 타입;
        declare 변수명 타입 default 초기값;
	-- 변수의 값을 수정
		set 변수명 = 값;
	-- 조건문 : case when
		case 
			when 조건식 then 실행문1;
			when 조건식2 then 실행문2;
			else 실행문3;
		end;
	-- 조건문 : if
    if 조건식 then 실행문1
	else 실행문2
    end if;
END //
DELIMITER ;

프로시저 호출 
CALL 프로시저명(매개변수들);
*/

-- 모든 영화 예매율을 업데이트 하는 프로시저
DROP PROCEDURE IF EXISTS 
update_RESERVATION_rate;
DELIMITER //
CREATE PROCEDURE update_RESERVATION_rate()
begin
	
    declare _total_seat int;
    declare done int default 0;
    declare _mo_num int;
    declare _moive_seat;
    
    declare cur cursor for
		select mo_num from movie
	declare contitnue handler for not found set done = 1;
    -- 영화 예매를 이용하여 예매 좌석수별로 예매율을 계산 
    -- => A영화 예매율 : A영화 예매좌석수 / 예매중인 전체 예매 자석수 * 100
    
    set _total_seat = (
		select sum(rv_adult + rv_teenager)
		from reservation
    );
    select _total_seat
    open cur;
    movie_loop : loop
			fetch cur into _mo_num;
		if done then leave movie_loop;
			end if;
		-- 하고싶은 작업
        -- 현재 선택된 영화의 예매 좌석수를 계산
        set _movie_seat = (
			select ifnull(sum(rv_adult + rv_teenager),0)
            from movie_schedule
				join reservation on rv_ms_num = ms_num
			where ms_mo_num = mo_num
        );
	select _movie_seat
    -- 예매율 업데이트
    update movie
		set mo_reservation_rate = round(_movie_seat / _total_seat * 100)
        where mo_num = _mo_num;
	end loop;
    close cur;
        
end //
delimiter ;


DROP PROCEDURE IF EXISTS RESERVATION_MOVIE;
-- 영화를 예매하는 프로시저 
DELIMITER //
CREATE PROCEDURE RESERVATION_MOVIE(
	IN _MS_NUM INT,-- 스케줄 번호 
    IN _ID VARCHAR(15),-- 예약 아이디명 
    IN _ADULT_COUNT INT, -- 성인수 
    IN _TEENAGER_COUNT INT,-- 청소년 수 
    IN _SEAT_LIST TEXT -- 좌석번호를 json형태의 문자열로
)

BEGIN 
	-- 모든변수는 상단에 선언 -- 
	DECLARE _ADULT_TOTAL_PRICE INT DEFAULT 0;
    DECLARE _TEENAGER_TOTAL_PRICE INT DEFAULT 0;
    DECLARE _TOTAL_PRICE INT DEFAULT 0;
    DECLARE _IS_DISCOUNT CHAR(1);

    DECLARE DONE INT DEFAULT 0;

    DECLARE _SE_NUM INT;
    DECLARE _PR_NUM INT;
    DECLARE _RV_NUM VARCHAR(20);
    DECLARE SEAT_NAME VARCHAR(4);
    declare _possible_seat int;
    
    /*
    cursor
    - SQL 결과 집합을 가르키는 데이터 타입, 프로시저나 함수내에서 사용 
    - 결과를 반복처리할 때 사용 
    - 결과를 한번에 가져오는게 아니라 하나씩 가져와서 처리 
    */
    
    -- 좌석 리스트를 cursor로 선언 (좌석리스트를 반복문을 통해 하나씩 꺼내쓰려고)
     DECLARE CUR CURSOR FOR 
		SELECT *
        FROM JSON_TABLE(_SEAT_LIST, '$[*]'
			COLUMNS(SEAT_NAME VARCHAR(4) PATH '$.SEAT_NAME')
		) AS A;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1;

    -- 예약번호 생성 --202308091614MS008001
    SET _RV_NUM = CONCAT(
		-- now() : YYYY-MM-DD HH:MM:SS => YYYYMMDDHHMM
		DATE_FORMAT(NOW(), '%Y%m%d%H%i'),
        'MS',
        LPAD(_MS_NUM, 3, 0),
        LPAD((SELECT COUNT(*)+1 FROM RESERVATION WHERE RV_MS_NUM = _MS_NUM) , 3, 0)
	);

	-- 전체 요금을 계산 : 
    -- 성인수, 청소년수, 조조할인 여부 알면 => 청소년 총 요금, 성인 총 요금을 계산
    -- <예약 테이블>에 정보를 추가
	-- 조조할인이 적용되는지 여부를 _is_discount에 저장
    SET _IS_DISCOUNT = (SELECT MS_DISCOUNT FROM MOVIE_SCHEDULE WHERE MS_NUM = _MS_NUM);
    -- 조조할인 여부에 따라 성인 전체요금과 청소년 전체 요금을 계산 
    IF _IS_DISCOUNT = 'Y' THEN 
			SET _ADULT_TOTAL_PRICE = 
        (SELECT PR_DISCOUNT_PRICE FROM PRICE WHERE PR_TYPE='성인')*_ADULT_COUNT;
        SET _TEENAGER_TOTAL_PRICE = 
        (SELECT PR_DISCOUNT_PRICE FROM PRICE WHERE PR_TYPE='청소년')*_TEENAGER_COUNT;
		ELSE
			SET _ADULT_TOTAL_PRICE = 
        (SELECT PR_PRICE FROM PRICE WHERE PR_TYPE='성인')*_ADULT_COUNT;
        SET _TEENAGER_TOTAL_PRICE = 
        (SELECT PR_PRICE FROM PRICE WHERE PR_TYPE='청소년')*_TEENAGER_COUNT;
    END IF;
    -- 전체 요금을 계산 
   SET _TOTAL_PRICE = _ADULT_TOTAL_PRICE + _TEENAGER_TOTAL_PRICE;
	-- 예약 정보를 테이블에 추가 
    INSERT INTO RESERVATION(RV_NUM, RV_MS_NUM, RV_ME_ID, RV_ADULT, RV_TEENAGER, RV_PRICE)
    VALUE(_RV_NUM, _MS_NUM, _ID, _ADULT_COUNT, _TEENAGER_COUNT, _TOTAL_PRICE);

	-- 예약 리스트에 좌석 정보를 추가
    -- cursor를 연다 -> fetch로 cur하나 꺼내옴
		open cur;
	read_loop:loop 
			fetch cur into seat_name; 
		-- 반복을 멈추는 작업 필요
		if done then leave read_loop;
			end if;
	-- 좌석 정보를 이용하여 예약 리스트에 추가하는 작업
    -- 영화 스케줄과 좌석이름을 이용하여 '좌석번호'를 가져옴
    set _se_num (
				select se_num from seat
					join screen on se_sc_num = sc_num
					join movie_schedule on ms_sc_num = sc_num;
				where ms_num = _ms_num and se_name = seat_name;
			);
    -- 예약좌석에 가격 번호를 연결하는데 있어서, 청소년 먼저하고, 성인을 하는거와 
	-- 성인 먼저하고 청소년을 먼저하는 건 중요하지 않음 
	-- 성인먼저 좌석 순으로 배치를 하고, 이후에 청소년을 좌석순으로 배치
	-- 성인수가 0이 아니면 주어진 좌석은 성인 좌석 
    
    if _adult_count != 0 then 
		set _pr_num = (select pr_num from price where pr_type = '성인');
		set _adult_count = _adult_count -1;
	else
		set _pr_num = (select pr_num from price where pr_type = '청소년');
		set _teenager_count = _teenager_count -1;
	end if;
    insert into reservation_list(rl_rv_num, rl_se_num, rl_pr_num)
		values(_rv_num, _se_num, _pr_num);
 	
    end loop;
	close cur;
    
    -- 영화 스케줄에 에약 가능좌석수를 업데이트
    set _possible_seat = (
		select sc_total_seat - sum(rv_adult + rv_teenager)
        from reservation
			join movie_schedule on ms_num = rv_ms_num
            join screen on ms_sc_num = sc_num
		where rv_ms_num = _ms_num
    );
    update movie_schedule
		set ms_possible_seat = _possible_seat
        where ms_num = _ms_num;
    -- 모든 영화 예매율을 업데이트 
    call update_reservation_rate();
end  //
delimiter ; 

call reservation_movie(4, 'admin', 1, 1, '[{"seat_name" : "A1"}, {"seat_name" : "A2"}]');
/*
{"속성명" : 값, "속성명" : 값
    => 데이터형태 = 제이슨
}
*/
