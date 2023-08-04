use shoppingmall;

-- 회원 아이디가 abc123, 비번이 1234, 번호가 011-1234-5678, 이름이 홍길동
-- 서울시 서초구 KH빌딩, 주소 상세가 6층 361반, 우편번호가 01234인 회원이 가입을 했을 때 쿼리 작성
-- 권한은 ADMIN, USER 중 하나 
insert into member(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY)
	value('abc123', '1234', '011-1234-5678', '서울시 서초구 kh빌딩', '6층 361반' '01234', 'USER', '홍길동');
    
insert into member(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY)
	value('admin', 'amdin', '011-1111-7777', '서울시 마포구 kh빌딩', '3층 101반' '01231', 'ADMIN', '김미소');
insert into member(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY)
	value('qwe123', 'qwe1234', '011-9999-7541', '서울시 서초구 kh빌딩', '1층 161반' '01234', 'USER', '안심해');
    
-- 제품코드가 ABC001, 제품명이 KH무선마우스, 제품설명이 KH무선마우스입니다., 가격이 15000원, 
-- 종류가 무선 / 유선인 제품을 등록하는 쿼리를 작성
-- (product 테이블과 option 테이블에 데이터를 추가하는 문제)
insert into product(pr_code, pr_name, pr_detail, pr_price) 
	values('ABC001', 'KH무선마우스', 'KH무선마우스입니다', 15000);
insert into `option`(op_name, op_pr_code) values('무선', 'ABC001'), ('유선', 'ABC001');

-- 제품 코드가 ABC001인 제품의 제품 정보와 옵션을 조회하는 쿼리
select * from product
	join `option` on pr_code = op_pr_code
    where pr_code = 'ABC001';