/*
select문 기본
select 속성명1, ..., 속성명n from 테이블명;
=> 테이블에서 속성명1, ..., 속성명n의 값들을 조회
=> 전체(모든 테이블)를 조회하려면 *을 이용  ex) text.* = 파일명이 text인 것의 모든 확장자
*/
use course;

/*
as : 속성 또는 테이블명을 일시적으로 변경해서 사용할 때 쓰는 키워드
속성명1 as 속성명2 => 쿼리 결과를 조회할 때, 속성명1을 일시적으로 속성명2로 사용
*/
-- 등록된 모든 학생의 모든 정보를 조회하는 쿼리 (기본) 
select * from student;
-- 등록된 모든 학생의 학번을 조회하는 쿼리
select num as '학번' from student;

/*
select 속성명1, ..., 속성명n from 테이블명 where 조건식;
=> 조건식을 만족하는 행(튜플)들만 검색해서, 해당 행의 속성1, ..., 속성n의 정보를 조회
(조건을 잘 걸어줘야 함)
where절
속성명1 = 값1 or 속성명2 = 값2 and 속성명3 = 값3

where절에 사용되는 연산자
= : 같다. null과 비교가 안됨 (날짜와 문자도 패턴만 같으면 비교를 해줌)
!= : 같지 않다. null과 비교가 안됨 
<> : 같지 않다. null과 비교가 안됨 
and : ~하고, 자바의 &&연산자
or : ~하거나, 자바의 ||연산자 
is null : null인지 확인
is not null : null이 아닌지 확인 
*/
-- 컴퓨터공학과 학생들을 조회하는 쿼리
SELECT * FROM student WHERE major = '컴퓨터공학과';
-- 컴퓨터공학과가 아닌 학생들을 조회하는 쿼리
select * from student where major != '컴퓨터공학과';
select * from student where major <> '컴퓨터공학과';

-- 학번이 2023135001인 학생이 듣는 '수강정보'를 조회하는 쿼리  
select * from course where student_num = '2023135001';
-- 학점이 3학점인 과목의 과목명을 조회하는 쿼리 
select title from subject where point = 3;

/*
like : 와일드카드와 함께 사용되며, 값이 주어진 와일드카드가 포함된 문자열과 같은지를 비교할 때 사용
	   ex) 성이 '홍'씨인 학생을 조회(매번 부분문자열을 사용하기엔 불편, 와일드카드)
_ : 한글자를 의미하는 와일드카드 
% : 0글자 이상을 의미하는 와일드카드  (홍% - 홍씨인 이름 검색조회) 
*/
-- 이름이 3자인 '학생 정보'를 조회하는 쿼리
select * from student where name like '___';
-- 성이 '영'씨인 학생 정보를 조회하는 쿼리
select * from student where name like '영__'; -- 성이 영씨이고 3글자 
select * from student where name like '여%';  -- 성이 여씨 
-- 학생의 학번은 입학년도 4자 + 학과코드 3자 + 번호 3자 (총 10자) 
-- 23학번 학생을 조회하는 쿼리
select * from student where num like '2023%';
-- 방송학과 코드는 135이다. 
-- 방송학과 학생을 조회하는 쿼리 
select * from student where major = '방송학과';
select * from student where num like '____135%';

/*
속성명 between A and B : 속성의 값이 A이상 B이하인 조건을 만족할 때 사용
-> 속성명 >= A and 속성명 <= B
*/
-- 학점이 2학점 이상 3학점 이하인 과목을 조회하는 쿼리
select * from subject where point between 2 and 3;
select * from subject where point >= 2 and point <= 3;

/*
속성명 in(값1, 값2, ..., 값n) : 속성의 값이 값1이거나 값2이거나 ... 값n인 조건을 만족할 때 사용 
-> 속성명 = 값1 or 속성명 = 값2 or ... or 속성명 = 값n
(서브쿼리 - select 안에 select가 들어갈때 쓰임)
*/
-- 이순신 교수님과 한석봉 교수님이 강의하는 수강정보를 조회하는 쿼리
select * from course where professor_name in('한석봉', '이순신');
select * from course where professor_name in ('한석봉') or professor_name in ('이순신');

/*
distinct : 중복된 결과를 제거하고 조회
select disinct 속성명 from 테이블명;
*/
/* 
- ANY
where 속성명 비교연산자(=, >=, <=, !=, <, >) any(서브쿼리);
=> 속성이 서브쿼리 결과와 비교연산을 했을 때 서브쿼리 결과 중 하나이상 만족하면 조회 
where 속성명 = any(서브쿼리)
=> where 속성명 in(서브쿼리) 
- SOME은 ANY와 같음 

- ALL
where 속성명 비교연산자(>=, <=, !=, <, > ) all(서브쿼리);
=> 속성이 서브쿼리 결과와 비교연산을 했을 때 서브쿼리 결과 모두를 만족하면 조회 
*/
-- 2023년에 수강하는 과목들의 과목코드를 조회하는 쿼리
select distinct subject_code from course where year = 2023;
-- 과목명이 글쓰기인 과목의 수강정보를 조회하는 쿼리
SELECT * FROM course WHERE subject_code = (SELECT code FROM subject WHERE title LIKE '%글쓰기');
-- 서브쿼리문 
select code from subject where title like '%글쓰기';
-- 학점이 2학점 또는 3학점 이상인 과목의 수강 정보를 조회
select * from course where subject_code = any(select code from subject where point in(2, 3));
-- 서브쿼리문
select code from subject where point in(2, 3);

-- 글쓰기와 영어가 아닌 모든 과목의 수강 정보를 조회
select * from course 
	where subject_code != all(select code from subject where title in('대학글쓰기', '영어회화'));
select * from course
	where subject_code in(select code from subject where title != '대학글쓰기' and title != '영어회화');
    
/* 
정렬 : ORDER BY
- order by는 where절과 group by절 뒤에 나와야 함 
-- (검색 결과를 다 걸러준 다음에 정렬해야함. order by는 흐름상 맨 마지막에!)
order by 속성명1 [정렬방법] , 속성명2 [정렬방법], ... 
=> 속성명1을 정렬방법을 기준으로 정렬하고, 속성명1의 값이 같으면 속성명2를 정렬방법을 기준으로 정렬... 
- 정렬방법
  - ASC : 오름차순. 기본값. 행이 아래로 갈수록 값이 커짐 
  - DESC : 내림차순. 행이 아래로 갈수록 값이 작아짐 
*/
-- 학생 정보를 이름순으로, 오름차순 정렬하여 조회
select * from student order by name asc;
-- 학생 정보를 이름순으로, 내림차순 정렬하여 조회
select * from student order by name desc;
-- 학생 정보를 전공, 이름순으로 오름차순으로 정렬하여 조회
select * from student order by major, name;

/* 
중복 제거 : 중복된 결과를 제거하고 조회 
select distinct 속성명 from 테이블명;
*/
-- 학생들이 소속된 과를 조회하는 쿼리
select distinct major from student;

/*
LIMIT : 행(튜플)을 원하는 위치부터 원하는 개수를 가져오기 위한 방법
- 전체 검색 결과가 아닌 일부를 가져올 때 사용 ex) 쇼핑탭 10개, 지식인 20개 등 
- 위치가 order by절 뒤. 제일 마지막에 위치(검색결과 > 정렬 > 원하는만큼 가져오기)
limit A; 
=> 0번지부터 A개를 가져옴
limit A, B;
=> A번지부터 B개를 가져옴 
*/
select * from student order by num;
-- 학생들 정보를 학번순으로 오름차순 정렬 후, 위에서 2명의 학생 정보를 조회하는 쿼리
select * from student order by num asc limit 2; 
-- 학생들 정보를 학번순으로 오름차순 정렬 후, 3번째 4번째 학생 정보를 조회하는 쿼리
select * from student order by num asc limit 2, 2;
-- 학생들 정보를 학번순으로 오름차순 정렬 후, 2명씩 보여줄 때 3번째 페이지에 있는 학생 정보를 조회하는 쿼리
-- select * from student order by num asc limit (3-1)*2, 2;
select * from student order by num asc limit 4, 2;
-- 학생들 정보를 학번순으로 오름차순 정렬 후, 2명씩 보여줄 때 4번째 페이지에 있는 학생 정보를 조회하는 쿼리
select * from student order by num asc limit 6, 2;

/*
GROUP BY절 : 같은 값을 가지는 행들을 묶어서 평균을 내거나 개수를 세는 등의 작업(집계함수)을 할 때 사용 
			ex) 각 과별로 소속된 학생 수
HAVING절 : 집계함수에 조건을 걸 때 사용 ex) 학과별 학생 4명 이상의 학번 조회
		  ㅡ where절이랑 많이 헷갈리는 부분 
- 위치는 where절 다음, order by 앞 
자주 사용하는 집계함수
- ave(속성 또는 식) : 평균
- min(속성 또는 식) : 최소값
- max(속성 또는 식) : 최대값 
- count(속성) : 행(튜플)의 개수
- count(distinct 속성) : 중복을 배제한 행의 개수 
- sum(속성 또는 식) : 합 
*/

SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));
-- 각 과별 학생수를 조회
select major as 학과, count(num) as 학생수 from student group by major;
-- 과목별 수강 학생 수를 과목코드, 수강생 수로 조회하는 커리 
select subject_code as 과목코드, count(num) as '수강생 수' from course group by subject_code;
-- 과목별 수강생 수가 4명 이상인 과목의 과목코드를 조회하는 쿼리
select 
	subject_code as 과목코드, count(num) as '수강생 수' 
from course 
group by subject_code
having count(*) >= 4;
--     수강생수 >= 4; 로 해도 동일결과 
-- -> 집계함수의 경우 having절을 써야함


