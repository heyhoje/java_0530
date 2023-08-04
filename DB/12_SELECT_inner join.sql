use course;
/*
join 문법
-- 테이블1의 외래키가 테이블2의 기본키를 참조하는 경우 ex)course.subject_code / subject.code 
-- join은 일반적으로 외래키와 기본키를 연결하지만, 상황에 따라서는 외래키가 아닌 속성을 기본키와 연결할 수 있다. 
select 
	테이블1.속성명1, 테이블1.속성명2, ..., 테이블2.속성명1, 테이블2.속성명2, ... 
from 
	테이블1(기준)
inner join | left join | right join -- inner 조인과 outer 조인 둘 다 가능
	테이블2
on 
	테이블1.외래키 = 테이블2.기본키
[where절]
[group by절]
[having절]
[order by절]
[limit절]
*/
-- select num, code, title, point, time 
-- select *
select course.*, title
from course
join subject 
on course.subject_code = subject.code;

-- 대학물리를 수강하는 학생들 수를 조회하는 쿼리
-- 서브쿼리 이용
select subject_code as 과목코드, count(*) as 수강생수 
from course 
where subject_code in(select code from subject where title = '대학물리')
group by subject_code;
-- 조인 이용
select subject_code as 과목코드, count(*) as 수강생수 
from course
join subject on subject_code = code
where title = '대학물리'
group by subject_code;

-- 여진구 학생이 수강하는 과목의 수를 조회하는 쿼리 
select student_num as 여진구학번, count(*) as '수강과목수' 
from course
join subject on subject_code = code
where student_num = (select num from student where name = '여진구')
group by student_num;

select student_Num as 여진구학번, count(*) as 수강과목수
from course
join student
on student_num = student.num
where name = '여진구'
group by student_num;

-- 여진구 학생이 수강하는 과목명을 조회하는 쿼리 ->
select name as 이름, title as 수강과목
from course
join student on student_num = student.num
join subject on subject_code = code
where name = '여진구';

-- 이순신 교수님이 강의하는 과목명을 조회하는 쿼리
select distinct title as 과목명
from course
join subject on subject_code = code
where professor_name = '이순신';