-- 검색결과 안나옴..ㅗ

-- 입학년도, 학과코드, 순서가 주어졌을 때, 학번을 생성해서 select로 출력하는 프로시저를 작성

-- 검색 결과 테이블을 반복문을 이용해서 활용하는 프로시저
-- 학생 정보를 출력하는 프로시저

drop procedure if exists select_student;

delimiter // 
create procedure select_student()

begin
	declare done int default 0; -- cursor를 이용하여 반복문을 할때 종료할지를 결정해주는 변수
    declare _num char(10); -- 검색결과에 있는 한 행에 있는 학번을 저장하는 변수
	declare _name varchar(20); -- 검색 결과에 있는 한 행에 있는 이름을 저장할 변수
    declare _major varchar(20); -- 검색 결과에 있는 한 행에 있는 전공을 저장할 변수
    
    declare cur cursor for
		select * from student;
	declare continue handler for not found set done = 1;
    -- cursor를 연다
    open cur;
    student_loop : loop
		-- fetch : cur에서 한 행씩 꺼내는 작업을 함
		fetch cur into _num, _name, _major;
        -- fetch를 이용하여 하나씩 꺼낼 떄 더이상 꺼낼 내용이 없으면
        -- done이 자동으로 1이 됨(왜냐면 19번째줄에서 설정했기 때문에)
		if done then
			leave student_loop;
		end if;
        -- 하고싶은 작업
        select concat(_num, _name, _major);
	end loop;
    -- cursor를 닫음
	close cur;
    
end//
delimiter ;
