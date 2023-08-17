/* 
도서 대출 사이트(도서관)를 구축하기 위한 요구사항 명세서 작성
- 반드시 회원가입을 통해 대출이 진행
- 대출 기간은 14일, 연체 할 때마다 연체 기간만큼 도서 대출 불가
- 도서는 대출 가능, 대출중, 예약중, 예약가능 만 존재
- 같은 도서는 도서번호 마지막 숫자만 다름 
- 분류번호 3자리.도서번호(영문,숫자 - 최대 7자리)+ v1(1권, 2권, ... 처럼 시리즈로 된 경우) 2(같은 도서 중 2번째 도서)
- 101.a123b v1 1~10 (띄어쓰기로 번호를 구분하도록 작업)
*/
/*
- (대출/반납)은 회원만 가능
- (회원가입)은 아이디, 비번, 전화번호, 생년월일을 입력하여 가입한다.
- 회원은 회원과 관리자로 구분된다. 

- (도서등록) 은 관리자만 가능 
- 도서 등록 시, 도서명/도서번호/저자/분류/출판사 를 입력하여 등록한다.
- 분류는 도서분류로 3자리 숫자로 구성된다. 
- 저자는 한번에 같이 입력(저자가 여러명이거나 저자, 옮긴이, 엮은이처럼 여러명인 경우 다 같이 저장)

- 회원은 도서번호를 이용하여 (예약)이 가능하다.
- 회원은 최대 3권의 도서를 (대출)할 수 있다(limit)

- (도서 연체)시, 연체 기간만큼 도서를 대출할 수 없다.

- (예약)된 도서는 최대 3일까지 예약으로 표시되고, 이후에는 예약이 취소된다. 
- 예약은 대출가능한 도서나 대출중이지만 예약되지 않은 도서만 가능하다. 
- 특정 도서는 대출 여부에 상관없이 예약이 안된다. 
*/

-- > 아주 간단해 보이는 효과가 있군
-- ERD_CLOUD ERD설계

/* 내가 작성해본 요구사항
회원가입 : 이름, 생년월일, 전화번호, 주소, 아이디, 비밀번호
도서정보 : 제목, 작가, 도서번호, 대출상태
도서관리 
대출 : 대출일, 반납예정일, 연체일, (대출한 사람 이름)(책 제목)
연체 : 를 따로 관리해? 
도서조회...는 select로 하면되나... 제목이나 도서번호나 등등으로?

3개 밖에 안나오는데요.... 

어떻게 저렇게 요구사항을 척척 길게 잘 뽑아내지? 
*/

DROP DATABASE IF EXISTS BOOK;

CREATE DATABASE BOOK;

USE BOOK; 

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL PRIMARY KEY,
	`me_pw`	varchar(255)	NOT NULL,
	`me_phone`	char(13)	NOT NULL,
	`me_birthday`	date	NOT NULL,
	`me_authority`	varchar(5)	NOT NULL DEFAULT 'USER',
	`me_book_count`	int	NOT NULL DEFAULT 0,
	`me_total_overdue`	int	NOT NULL DEFAULT 0,
	`me_apply_overdue`	date	NULL
);

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
	`bo_num`	varchar(20)	NOT NULL PRIMARY KEY,
	`bo_title`	varchar(255)	NOT NULL,
	`bo_type`	varchar(10)	NOT NULL,
	`bo_publisher`	varchar(30)	NOT NULL,
	`bo_author`	varchar(255)	NOT NULL,
	`bo_possible_loan`	int	NOT NULL,
	`bo_possible_reservation`	int	NOT NULL
);

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
	`lo_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`lo_date`	datetime	NOT NULL,
	`lo_me_id`	varchar(15)	NOT NULL,
	`lo_bo_num`	varchar(20)	NOT NULL,
	`lo_expected_date`	date	NOT NULL,
	`lo_return_date`	date	NULL
);

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
	`re_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`re_reservation_date`	date	NOT NULL,
	`re_me_id`	varchar(15)	NOT NULL,
	`re_bo_num`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `book_state`;

CREATE TABLE `book_state` (
	`bs_num`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`bs_desc`	varchar(20)	NOT NULL
);



ALTER TABLE `book` ADD CONSTRAINT `FK_book_state_TO_book_1` FOREIGN KEY (
	`bo_possible_loan`
)
REFERENCES `book_state` (
	`bs_num`
);

ALTER TABLE `book` ADD CONSTRAINT `FK_book_state_TO_book_2` FOREIGN KEY (
	`bo_possible_reservation`
)
REFERENCES `book_state` (
	`bs_num`
);

ALTER TABLE `loan` ADD CONSTRAINT `FK_member_TO_loan_1` FOREIGN KEY (
	`lo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `loan` ADD CONSTRAINT `FK_book_TO_loan_1` FOREIGN KEY (
	`lo_bo_num`
)
REFERENCES `book` (
	`bo_num`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_member_TO_reservation_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_book_TO_reservation_1` FOREIGN KEY (
	`re_bo_num`
)
REFERENCES `book` (
	`bo_num`
);

