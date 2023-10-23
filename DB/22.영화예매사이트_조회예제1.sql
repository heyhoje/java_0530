-- 처음부터 하는게 나을지도 샘플데이터야 어서와ㅠ/샘플데이터 완

-- 오펜하이머 조회 -- 
-- 영화 오펜하이머에 출연한 감독과 배우들을 조회하는 쿼리
select mo_title as '영화제목', fp_name as '영화인', ro_role as '역할'
from film_person
	join role on fp_num = ro_fp_num
    join movie on mo_num = ro_mo_num
where mo_title = '오펜하이머';

-- 영화 오펜하이머 기본 정보를 조회하는 쿼리(제목, 제목(영문), 개봉일, 런링타임, 줄거리, 연령제한, 예매율
select mo_title as 제목, mo_title_eng as 영문제목, mo_opening_date as 개봉일, mo_running_time as 러닝타임, 
mo_plot as 줄거리, mo_ag_name as 연령제한, concat(mo_reservation_rate, '%') as 예매율 
from movie
where mo_title = '오펜하이머';

-- 영화 오펜하이머의 트레일러와 스틸컷 파일의 개수를 조회하는 쿼리
-- (x) 트레일러랑 스틸컷 각각 세는거 아닌가요? 스틸컷 안나오고 트레일러(8개)로만 나옴 
-- => group by를 fi_state로 하면 해결됨 
select mo_title as '영화제목', fi_state as '타입', count(*) as 개수
from file
	join movie_file on fi_num = mf_fi_num
    join movie on mo_num = mf_mo_num
where mo_title = '오펜하이머'
group by fi_state;

