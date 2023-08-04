-- 여진구 학생이 수강하는 '수강정보'를 조회하는 쿼리
select * from course where student_num in(select num from student where name = '여진구');
select * from student where name = '여진구';

-- '영어회화를 수강하는' 컴퓨터공학과 학생들의 '수강정보'를 조회하는 쿼리
select * from course where subject_code = (select code from subject where title = '영어회화') 
	and student_num in(select num from student where major = '컴퓨터공학과');
    
-- 수강생이 3명 이상인 과목의 과목코드를 조회하는 쿼리
select subject_code as 과목코드, count(num) as '수강생 수' from course group by subject_code 
	having count(num) >= 3; 