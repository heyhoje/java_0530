use CGV;
-- 등록된 영화를 조회하는 쿼리
select * from movie;

-- 장르가 드라마인 '영화'를 조회하는 쿼리(x)
select * from movie
	join movie_genre on mo_num = mg_mo_num
where mg_ge_name = '드라마';

-- 개봉전인 영화를 조회하는 쿼리
select * from movie
where now() < mo_opening_date;

-- 상영 종료된 영화를 조회하는 쿼리(현재 개봉중인 영화는 오늘을 기준으로 2주까지 스케줄이 반드시 등록이 됨) -- (이해x)
select mo_title as 상영종료영화
from movie
	left join -- 상영 종료된 영화는 상영 정보가 없기 때문에 inner join을 하면 상영 종료된 영화가 조회되지 않음
    movie_schedule on mo_num = ms_mo_num
where now() >= mo_opening_date
having count(ms_num) = 0; -- 집계합수는 where절에 넣을 수 없다
