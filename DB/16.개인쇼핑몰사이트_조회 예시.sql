-- 8/7 select 조회 예제--
-- qwe123회원이 '구매(환불, 반품을 제외)한 제품명과 옵션명 목록'을 확인하는 쿼리 (x)
select or_me_id as 주문아이디, pr_name as 제품명, op_name as 옵션명, 
pr_price as 제품가격, ol_amount as 구매수량
from `order`
	join order_list on ol_or_num = or_num
    join `option` on ol_op_num = op_num
    join product on op_pr_code = pr_code
where or_state not in('환불', '반품') and or_me_id = 'qwe123';
;

-- 'abc123 회원'이 '장바구니'에 담은 (제품명, 옵션명, 수량)을 확인하는 쿼리 (x)
select ba_me_id as 회원아이디, pr_name as 제품명, op_name as 옵션명, ba_amount as 수량
 from basket
join `option` on ba_op_num = op_num
	join product on op_pr_code = pr_code
where ba_me_id = 'abc123';

-- 'abc123 회원'이 등록한 (배송지 정보)를 조회하는 쿼리 (x)
select * from address where ad_me_id = 'abc123';

-- '등록된 모든 제품'을 검색하는 쿼리 (O)
-- 옵션정보도 추가하고 싶으면 어떻게 join을 써야할까?
select * from product;

-- 'KH가 제품명에 포함된 제품들'을 검색하는 쿼리 (50%)
select * from product where pr_name like '%KH%';
select * from product where pr_name like concat('%', 'KH', '%');

-- KH가 제품명에 포함된 제품들 중에서 '1페이지에 해당하는 제품들을' 검색하는 쿼리(한 페이지에는 제품이 최대 5개)
select *from product where pr_name like '%KH%' limit 0, 5;
-- KH가 제품명에 포함된 제품들 중에서 '2페이지에 해당하는 제품들을' 검색하는 쿼리(한 페이지에는 제품이 최대 5개)
select *from product where pr_name like '%KH%' limit 5, 5;

-- ---------------
-- abc123회원이 작성한 모든 리뷰를 조회하는 쿼리
select * from review where re_me_id = 'abc123';
-- abc123회원이 작성한 리뷰가 있는 제품명을 조회
select pr_name as 리뷰제품 from review
	join `option` on re_op_num = op_num
    join product on pr_code = op_pr_code;
    
-- '제품 코드가 ABC001'이고, '옵션명이 무선'인 제품에 달린 '리뷰'를 조회
select * from review
	join `option` on op_num = re_op_num
where op_pr_code = 'ABC001' and op_name = '무선';

-- 제품명이 'KH무선마우스'인 제품의 '리뷰 개수'를 조회하는 쿼리(x)
select count(*) as 'KH무선마우스 리뷰수' from review
	join `option` on re_op_num = op_num
where op_pr_code = (select pr_code from product where pr_name = 'KH무선마우스');

-- 제품별 '리뷰 개수'를 조회하는 쿼리(리뷰가 등록된 제품만 조회) (x)
select op_pr_code as 제품코드, count(*) as 리뷰개수 from review
	join `option` on op_num = re_op_num,
--  join product on pr_code = re_pr_code -- 제품명을 테이블 속성? 가운데에 넣고 싶다.......  사실 위에도 아래도 이해 안된다..
group by op_pr_code;

-- 제품별 '옵션의 개수'를 조회하는 쿼리(제품명, 옵션수)
select pr_name as 제품명, count(*) as 옵션개수 
from product
	join `option` on pr_code = op_pr_code
group by pr_code; 

-- ----

-- 제품별 '판매량(반품, 환불을 제외한)'을 조회하는 쿼리(제품명, 판매량)
-- outer join 이용, 판매가 안된 제품도 개수 조회할 수 있음
-- 제품은 order나 order_list와 바로 연결이 안됨ㅠ 일단 옵션이랑 연결
select pr_name as 제품명, sum(ol_amount) as 판매량 
from product
	join `option` on op_pr_code = pr_code
	left join order_list on ol_op_num = op_num
	left join `order` on or_num = ol_or_num
where or_state is null or or_state not in('반품', '환불')
group by pr_code;

-- 제품 옵션별 '판매량(반품, 환불을 제외한)'을 조회하는 쿼리(제품명, 옵션명, 판매량)
select pr_name as 제품명, op_name as 옵션명, ifNull(sum(ol_amount),0) as 판매량 
from `option`
	join product on pr_code = op_pr_code
    left join order_list on ol_op_num = op_num
	left join `order` on or_num = ol_or_num
where or_state is null or or_state not in('반품', '환불')
group by op_num;

-- 제품 옵션별 '판매량(반품, 환불을 제외한)'을 조회하는 쿼리(제품명, 옵션명, 판매량, 총판매금액) (X_X)
select pr_name as 제품명, op_name as 옵션명, ifnull(sum(ol_amount),0) as 판매량, 
	   pr_prce * ifnull(sum(ol_amount),0) as 총판매금액
from `option`
	join product on pr_code = op_pr_code
	left join order_list on ol_op_num = op_num
	left join `order` on or_num = ol_or_num
where or_state is null or or_state not in('반품', '환불')
group by op_num;

-- 옵션별 리뷰수를 조회하는 쿼리(제품명, 옵션명, 리뷰수)
-- 제품별 리뷰 개수를 조회하는 쿼리(리뷰가 등록된 제품만 조회) (x)
select pr_name as 제품명, op_name as 옵션명, count(re_num) as 리뷰수
from review 
	right join `option` on re_op_num  = op_num
    join product on pr_code = op_pr_code
group by op_num;
