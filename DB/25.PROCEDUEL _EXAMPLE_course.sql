-- 입학년도, 학과코드, 순서가 주어졌을 때, 학번을 생성해서 select로 출력하는 프로시저를 작성

drop procedure if exists create_student_num;

delimiter // 
create procedure(
in _year int
in _dep_code char(3)
in _order_num int
)
begin

end//
delimiter ;

call create_student_num(2023, '135', 4);