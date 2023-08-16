/*
inner join : 두 테이블이 외래키로 연결 되었을 때, 양쪽 다 데이터가 있는 경우
outer join : 두 테이블이 외래키로 연결 되었을 때, 한 테이블을 기준으로 연결할때 사용

- 상품별 리뷰수를 조회하는 경우, 리뷰가 등록이 안된 상품은 inner join을 이용해서 리뷰수를 알 수 없음..

- outer join 문법 : *기준테이블이 매우 중요
- inner join은 A join B와 B join A가 같지만,
  outer join은 A outer join B와 B outer join A는 결과가 다름 (순서 중요)
- 종류 : left, right
- left join : 기준 테이블을 기준으로 연결
- right join : 참조 테이블을 기준으로 연결 

A left join B == B right join A // 결과가 같다(a를 기준으로 b를 이어 붙임)

select * from 기준테이블 
	join 참조테이블
    on 기준테이블.외래키 = 참조테이블.기본키
[where절]
[group by절]
[having절]
[order by절]
[limit절]
*/
-- 제품별 '리뷰 개수'를 조회하는 쿼리(리뷰가 등록된 제품만 조회)
-- option 이 오른쪽에! 왜냐면,, 리뷰가 있는데 제품이 없을 수는 없어서... 랬나??ㅜ
/* select op_pr_code as 제품코드, count(*) as 리뷰수 */
select op_pr_code as 제품코드, count(re_num) as 리뷰수
from review 
	right join `option` on op_num = re_op_num
group by op_pr_code;
