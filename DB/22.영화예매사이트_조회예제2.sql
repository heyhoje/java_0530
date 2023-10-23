-- 8/9 --
-- abc123회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 좌석명)
select me_id as 아이디, mo_title as 영화명, ms_start_time as 상영시간, se_name as 좌석명 from reservation
	join reservation_list on rv_num = rl_rv_num
    join seat on se_num = rl_se_num
    join movie_schedule on ms_num = rv_ms_num
    join movie on mo_num = ms_mo_num
    join member on me_id = rv_me_id
where rv_me_id = 'abc123';
    
-- abc회원의 예매 내역을 조회하는 쿼리(영화명, 시간, 성인 X명, 청소년 X명)
select me_id as 아이디, rv_num as 예매번호, mo_title as 영화명, ms_start_time as 상영시간,
	sum(rv_adult) as 성인수, sum(rv_teenager) as 청소년수
from reservation
	join member on me_id = rv_me_id
    join movie_schedule on rv_ms_num = ms_num
    join movie on mo_num = ms_mo_num
where me_id = 'abc123'
group by rv_num;

-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리
select se_name as 좌석
from seat
	join screen on se_sc_num = sc_num
    join movie_schedule on ms_sc_num = sc_num
where ms_num = 8 and se_num not in (
	select rl_se_num from reservation	
		join reservation_list on rl_rv_num = rv_num
        where rv_ms_num = 8
	);
    
-- CGV강남 영화관에서 콘크리트 유토피아 20:50에 예매 가능한 좌석을 조회하는 쿼리(outer join 이용)(x 에러뜸)
select se_name from seat
	join screen on se_sc_num = sc_num
    join movie_schedule on ms_sc_num = sc_num
    left join -- 예약과 예약리스트를 join하는게 아니라 예약 리스트와 좌석을 join
    reservation_list on se_num = rl_se_num
where ms_num = 8 and rl_se_num is null;

use cgv;
-- 8/10 9:00 --
-- CGV강남 영화관애서 콘크리트 유토피아 20:50에 있는 좌석들과 좌석들 예매 여부를 조회하는 쿼리 (x 에러뜸)
select se_name as '좌석 번호', 
	case when rl_se_num is null then 'Y'
	else 'N' 
    end as '예약 가능 여부'
 from seat
	join screen on se_sc_num = sc_num
    join movie_schedule on ms_sc_num = sc_num
    left join -- 예약과 예약리스트를 join하는게 아니라 예약 리스트와 좌석을 join
    reservation_list on se_num = rl_se_num
where ms_num = 8;

-- 'abc123'회원이 '관람했던(본) 영화 목록'을 조회하는 쿼리 (안나옴........ 똑같은데 reservation테이블에 있는데)
select mo_title as '관람 영화' from reservation
-- 영화정보
	join movie_schedule on ms_num = rv_ms_num
    join movie on ms_mo_num = mo_num
where rv_me_id = 'abc123' and now() >= concat(ms_date, ' ', ms_start_time) -- <= 볼 영화 / >= 본 영화
-- 동일 영화가 여러번 조회될 수 있음
group by mo_num -- 같은 영화를 여러번 봐도 관람영화 목록에는 1번만 출력됨;
;

-- '예약 가능한' 모든 상영 영화 정보를 조회하는 쿼리 (이해안되는데 일단 침)
SELECT DISTINCT *
FROM MOVIE_SCHEDULE
	JOIN MOVIE ON MO_NUM = MS_MO_NUM
WHERE NOW() < CONCAT(MS_DATE, ' ', MS_START_TIME) AND MS_POSSIBLE_SEAT > 0;

-- CGV에서 이벤트로 한 영화를 여러번 본 회원 중에 가장 많이 본 회원 3명을 뽑으려고 한다.
-- 각 영화를 각 회원이 몇 번봤는지 조회하는 쿼리
SELECT MO_TITLE AS 영화, RV_ME_ID AS 아이디, COUNT(RV_NUM) AS 회수 
FROM RESERVATION
	JOIN MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
    JOIN MOVIE ON MS_MO_NUM = MO_NUM
WHERE NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME)
GROUP BY RV_ME_ID, MS_MO_NUM;
USE CGV;
-- 회원들 중 금액 사용이 가장 많은 3명의 회원을 조회하는 쿼리
-- 사용 금액이 같은 회원이 여러명인 경우, 누구는 순위에 포함되고 누구는 순위에 포함되지 않을 수 있음
SELECT MO_TITME AS 영화명, RV_ME_ID AS 아이디, COUNT(RV_NUM) AS  FROM RESERVATION
	JOIN MOVIE_SCHEDULE ON MS_NUM = RV_MS_NUM
    JOIN MOVIE ON MS_MO_NUM = MO_NUM
WHERE NOW() >= CONCAT(MS_DATE, ' ', MS_START_TIME)
GROUP BY RV_ME_ID, MS_MO_NUM;

-- --------------------------------
-- 영화인별로 배우로 참여한 영화 개수를 조회하는 쿼리
select fp_name as 영화인, isnull(count(ro_num, 0) as '참여영화수(배우)' from film_person
	left join (select * from role where ro_role = '배우') as role2 on ro_fp_num = fp_num
group by fp_num;

-- 각 '스케줄별' 예약한 좌석 수를 조회하는 쿼리 (x)
select mo_title as 영화, ms_date as 상영일, ms_start_time as 상영시간, sc_total_seat - ms_possible_seat as '예약된 좌석수'
from movie_schedule
	join screen on sc_num = ms_sc_num
    join movie on mo_num = ms_mo_num;
    
-- 영화관별 '상영 영화 목록'을 보여주는 쿼리 (x)
-- select th_num as 영화관, mo_title as 상영영화 from theater
-- 	join screen on th_num = sc_th_num
--     join movie_schedule on ms_sc_num = sc_num
--     join movie on mo_num = ms_mo_num
-- group by mo_title;
select th_name as 영화관, mo_title as 영화, ms_start_time as 상영시간 from movie_schedule -- 극장에 따라 상영 영화가 달라짐
	join screen on ms_sc_num = sc_num -- 영화관과 연결을 위해 먼저 상영관과 연결
    join theater on th_num = sc_th_num -- 영화관명을 조회하기 위해 영화관 연결
    join movie on ms_mo_num = mo_num -- 영화 제목을 조회하기 위해 영화관 연결
where now() <= concat(ms_date, ' ', ms_start_time)
group by th_num, ms_mo_num;

-- 오펜하이머를 '상영하는 영화관'을 조회하는 쿼리
-- select * from theater -- 영화를 선택하면, 그것을 상영하는 극장 보여줌
-- 	join screen on th_num = sc_th_num
--     join movie_schedule on sc_num = mo_sc_num
--     join movie on ms_mo_num = mo_num
-- where mo_title = '오펜하이머';

select th_name as 영화관, ms_start_time as 상영시간 from movie_schedule -- 극장에 따라 상영 영화가 달라짐
	join screen on ms_sc_num = sc_num -- 영화관과 연결을 위해 먼저 상영관과 연결
    join theater on th_num = sc_th_num -- 영화관명을 조회하기 위해 영화관 연결
    join movie on ms_mo_num = mo_num -- 영화 제목을 조회하기 위해 영화관 연결
where now() <= concat(ms_date, ' ', ms_start_time) and mo_title = '오펜하이머'
group by th_num, ms_mo_num;
