/*
- 함수
-하나의 작업을 하도록 구성. ex) 예매 함수 => 예메에 데이터를 추가만 함
매개변수 : 값을 사용(매개변수의 값이 변경되지 않음)
반환값 : 무조건 1개
-select문에서 사용 가능. sum, count 등 집계함수 쓰일 수 있음.
(안에 코드가 실행되기 때문에 코드가 어떻게 구현되는지 몰라도 됨)

- 프로시저 
-일련의 작업을 하도록 구성 
ex) 예매 프로시저 => 예메에 데이터를 추가, 예매 리스트에 데이터를 추가, 스케줄에 예매 가능좌석 업데이트, 영화의 예매율 업데이트 / 를 해줘야함. 
매개변수 : 값을 사용 IN, 값을 반환 OUT, 값을 사용과 반혼 INOUT
반환값 : 없음. 대신 매개변수를 이용하여 out/inout인 매개변수에 반환값을 전달할 수 있음.
-select문에서 사용 불가능. 
(함수에 비해 속도가 빠름)(어떠한 작업을 연관되어 진행하는지 사전에 알고 있어야함)


delimiter //

create procedure 프로시저명(
[ -- 생략가능
in|out|inout 변수명 변수타입
]
)
begin
	-- 변수 선언 방법 / 상단에 변수 선언을 모아 놓아야 함 
	declare 변수명 변수타입; 
    declare 변수명 변수타입 default 기본값;
    
    -- 변수값 변경
    set 변수명 = 값;
    
    -- if문
    if 조건식1 then
		실행문1;
	elseif 조건식2 then
		실행문2;
	else
		실행문3;
	end if;
    
end //
delimiter ;

-- 프로시저 호출
call 프로시저명(매개변수들);
*/

-- 숫자가 주어지면 숫자 앞에 0을 붙여서 최대 5자리로 된 숫자를 만드는 프로시저 
-- 1 => 00001 => (select로 출력/조회)
drop procedure if exists ZERO_NUM;

delimiter // 
create procedure zero_num(
in _num int 
)
begin
	declare _result char(5);
    set _result = (select lpad(_num, 5, '0'));
    select _result;
end //
delimiter ;

call zero_num(123);