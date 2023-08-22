/* (계정을 생성해서 권한을 부여)
계정생성 : '권한이 있는 계정'-(보통 root) 다른 계정을 생성할 수 있다. 
create user '아이디'@'접근방법' identified by '비번';
- 접근방법 : localhost와 %
	- localhost : 내부IP에서만 접근 가능하도록 설정  
	- % : 외부IP에서도 접근 가능하도록 설정 
*/
create user 'test1'@'localhost' identified by '1234';
-- 계정만 생성, 권한부여는 x
 
/*
권한부여 : 계정에 DB 및 테이블에 접근할 수 있는 권한을 설정
ㄴ권한을 부여받아야 DB 및 테이블에 접근할 수 있다. 
- 어떤 DB에 접근할 수 있게 할 건지
- 어떤 테이블에 접근할 수 있게 할 건지 
- 어떤 작업을 수행(insert, update, delete, select) 할 수 있게 할 건지 

모든 작업을 수행할 수 있는 권한을 부여하는 방법
grant all privileges on DB명.테이블명 to '아이디'@'접근방법';
*/
grant all privileges on cgv.* to 'test1'@'localhost';

/* join - using
A, B : 테이블명, a 속성명이 같은 경우
select * from A join B on A.a = B.a;
=> select * from A join B using(a)
*/