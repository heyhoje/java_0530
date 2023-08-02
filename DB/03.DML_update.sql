/*
update : 데이터 수정

update 테이블명 set 속성1 = 값1, 속성2 = 값2, ..., 속성n = 값n where 기본키 = 값;

=> ctrl + B : 자동으로 들여쓰기 적용되면서 엔터처리됨
update
	테이블
set
	속성1 = 값1,
    속성2 = 값2,
    ...,
    속성n = 값n
where
	기본키 = 값;
*/
-- MSC001과목이 0학점 0시간 -> 3학점 4시간으로 변경하는 쿼리 
UPDATE subject 
SET 
    point = 3,
    time = 4
WHERE
    code = 'MSC001';
-- 학번이 홍길동인 학생의 정보를 학번이 '2023135002', 이름은 '호호' 전공은 '방송학과'로 수정하는 쿼리
update student set num = '2023135002', name = '호호', major = '방송학과' where num = '홍길동';