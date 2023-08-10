drop database if exists CGV;

create database CGV;

use CGV;

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int	NOT NULL primary key auto_increment,
	`mo_title`	varchar(50) not null,
	`mo_title_eng`	varchar(100)	not NULL,
	`mo_opening_date`	date	NULL,
	`mo_running_time`	int	not NULL,
	`mo_plot`	longtext	not NULL,
	`mo_fi_num`	int	NOT NULL,
	`mo_ag_name`	varchar(10)	NULL,
	`mo_reservation_rate`	int	not NULL default 0
);

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
	`ge_name`	varchar(10)	NOT NULL primary key
    );

DROP TABLE IF EXISTS `movie_genre`;

CREATE TABLE `movie_genre` (
	`mg_num`	int primary key auto_increment	NOT NULL,
	`mg_ge_name`	varchar(10)	NOT NULL,
	`mg_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
	`ct_name`	varchar(20)	NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS `country_production`;

CREATE TABLE `country_production` (
	`cp_num`	int	NOT NULL primary key auto_increment,
	`cp_ct_name`	varchar(20)	NOT NULL,
	`cp_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `film_person`;

CREATE TABLE `film_person` (
	`fp_num`	int	NOT NULL primary key auto_increment,
	`fp_name`	varchar(50)	not NULL,
	`fp_agency`	varchar(50)	NULL,
	`fp_final_education`	varchar(20)	NULL,
	`fp_thumbnail`	varchar(50)	NULL,
	`fp_birthday`	date	not NULL,
	`fp_ct_name`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
	`ro_num`	int	NOT NULL primary key auto_increment,
	`ro_role`	varchar(30)	not NULL,
	`ro_fp_num`	int	NOT NULL,
	`ro_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL primary key auto_increment,
	`fi_name`	varchar(100)	not NULL,
	`fi_state`	varchar(10)	not NULL -- 메인포스트 또는 트레일러/스틸컷 
);

DROP TABLE IF EXISTS `movie_file`;

CREATE TABLE `movie_file` (
	`mf_num`	int	NOT NULL primary key auto_increment,
	`mf_fi_num`	int	NOT NULL,
	`mf_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `age`;

CREATE TABLE `age` (
	`ag_name`	varchar(10)	not NULL primary key -- 전체관람가, 12세 관람가, 15세 관람가, 청소년 관람불가, 제한상영가
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`th_num`	int	NOT NULL primary key auto_increment,
	`th_name`	varchar(20)	not NULL,
    `th_address` 	varchar(50) not null, 
	`th_re_name`	varchar(15)	NOT NULL,
	`th_total_screen`	int	NULL default 1,
	`th_total_seat`	int	not NULL
);

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
	`re_name`	varchar(15)	NOT NULL primary key
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc_num`	int	NOT NULL primary key auto_increment,
	`sc_name`	varchar(20) not	NULL,
	`sc_total_seat`	int not	NULL,
	`sc_th_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	int	NOT NULL primary key auto_increment,
	`se_name`	varchar(4)	not NULL,
	`se_row`	char(1)	not NULL,
	`se_col`	varchar(2)	not NULL,
	`se_state`	varchar(10)	not NULL default '일반', -- 일반/커플/스위트
	`se_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `movie_schedule`;

CREATE TABLE `movie_schedule` (
	`ms_num`	int	NOT NULL primary key auto_increment,
	`ms_mo_num`	int	NOT NULL,
	`ms_sc_num`	int	NOT NULL,
	`ms_date`	date	not NULL,
	`ms_start_time`	time	not NULL,
	`ms_end_time`	time	not NULL,
	`ms_possible_seat`	int	not NULL,
	`ms_discount`	char(1)	not NULL default 'N'
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL primary key,
	`me_pw`	varchar(20)	not NULL,
	`me_name`	varchar(20)	not NULL,
	`me_phone`	varchar(13)	not NULL,
	`me_birthday`	date	not NULL,
    `me_authority` varchar(5) not null default 'user'
);

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
	`rv_num`	varchar(20)	NOT NULL primary key,
	`rv_me_id`	varchar(15)	NOT NULL,
	`rv_ms_num`	int	NOT NULL,
	`rv_adult`	int	not NULL default 0,
	`rv_teenager`	int not	NULL default 0,
	`rv_price`	int	not NULL
);

DROP TABLE IF EXISTS `reservation_list`;

CREATE TABLE `reservation_list` (
	`rl_num`	int	NOT NULL primary key auto_increment,
	`rl_rv_num`	varchar(20)	NOT NULL,
	`rl_se_num`	int	NOT NULL,
	`rl_pr_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
	`pr_num`	int	NOT NULL primary key auto_increment,
	`pr_type`	varchar(3)	not NULL,
	`pr_price`	int	not NULL,
	`pr_discount_price`	int	not NULL
);

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`re_num`	int	NOT NULL primary key auto_increment,
	`re_content`	longtext	not NULL,
	`re_mo_num`	int	NOT NULL,
	`re_me_id`	varchar(15)	NOT NULL,
	`re_total_like`	int	not NULL default 0
);

DROP TABLE IF EXISTS `like`;

CREATE TABLE `like` (
	`li_num`	int	NOT NULL primary key auto_increment,
	`li_me_id`	varchar(15)	NOT NULL,
	`li_re_num`	int	NOT NULL
);

-- 기본키 설정하는 부분 / 외래키 전까지 지우기
-- ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
-- 	`mo_num`
-- );

-- ALTER TABLE `genre` ADD CONSTRAINT `PK_GENRE` PRIMARY KEY (
-- 	`ge_name`
-- );

-- ALTER TABLE `movie_genre` ADD CONSTRAINT `PK_MOVIE_GENRE` PRIMARY KEY (
-- 	`mg_num`
-- );

-- ALTER TABLE `country` ADD CONSTRAINT `PK_COUNTRY` PRIMARY KEY (
-- 	`ct_name`
-- );

-- ALTER TABLE `country_production` ADD CONSTRAINT `PK_COUNTRY_PRODUCTION` PRIMARY KEY (
-- 	`cp_num`
-- );

-- ALTER TABLE `film_person` ADD CONSTRAINT `PK_FILM_PERSON` PRIMARY KEY (
-- 	`fp_num`
-- );

-- ALTER TABLE `role` ADD CONSTRAINT `PK_ROLE` PRIMARY KEY (
-- 	`ro_num`
-- );

-- ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
-- 	`fi_num`
-- );

-- ALTER TABLE `movie_file` ADD CONSTRAINT `PK_MOVIE_FILE` PRIMARY KEY (
-- 	`mf_num`
-- );

-- ALTER TABLE `age` ADD CONSTRAINT `PK_AGE` PRIMARY KEY (
-- 	`ag_name`
-- );

-- ALTER TABLE `theater` ADD CONSTRAINT `PK_THEATER` PRIMARY KEY (
-- 	`th_num`
-- );

-- ALTER TABLE `region` ADD CONSTRAINT `PK_REGION` PRIMARY KEY (
-- 	`re_name`
-- );

-- ALTER TABLE `screen` ADD CONSTRAINT `PK_SCREEN` PRIMARY KEY (
-- 	`sc_num`
-- );

-- ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
-- 	`se_num`
-- );

-- ALTER TABLE `movie-schedule` ADD CONSTRAINT `PK_MOVIE-SCHEDULE` PRIMARY KEY (
-- 	`ms_num`
-- );

-- ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
-- 	`me_id`
-- );

-- ALTER TABLE `reservation` ADD CONSTRAINT `PK_RESERVATION` PRIMARY KEY (
-- 	`rv_num`
-- );

-- ALTER TABLE `reservation_list` ADD CONSTRAINT `PK_RESERVATION_LIST` PRIMARY KEY (
-- 	`rl_num`
-- );

-- ALTER TABLE `price` ADD CONSTRAINT `PK_PRICE` PRIMARY KEY (
-- 	`pr_num`
-- );

-- ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
-- 	`re_num`
-- );

-- ALTER TABLE `like` ADD CONSTRAINT `PK_LIKE` PRIMARY KEY (
-- 	`li_num`
-- );

ALTER TABLE `movie` ADD CONSTRAINT `FK_file_TO_movie_1` FOREIGN KEY (
	`mo_fi_num`
)
REFERENCES `file` (
	`fi_num`
);

ALTER TABLE `movie` ADD CONSTRAINT `FK_age_TO_movie_1` FOREIGN KEY (
	`mo_ag_name`
)
REFERENCES `age` (
	`ag_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_genre_TO_movie_genre_1` FOREIGN KEY (
	`mg_ge_name`
)
REFERENCES `genre` (
	`ge_name`
);

ALTER TABLE `movie_genre` ADD CONSTRAINT `FK_movie_TO_movie_genre_1` FOREIGN KEY (
	`mg_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `country_production` ADD CONSTRAINT `FK_country_TO_country_production_1` FOREIGN KEY (
	`cp_ct_name`
)
REFERENCES `country` (
	`ct_name`
);

ALTER TABLE `country_production` ADD CONSTRAINT `FK_movie_TO_country_production_1` FOREIGN KEY (
	`cp_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `film_person` ADD CONSTRAINT `FK_country_TO_film_person_1` FOREIGN KEY (
	`fp_ct_name`
)
REFERENCES `country` (
	`ct_name`
);

ALTER TABLE `role` ADD CONSTRAINT `FK_film_person_TO_role_1` FOREIGN KEY (
	`ro_fp_num`
)
REFERENCES `film_person` (
	`fp_num`
);

ALTER TABLE `role` ADD CONSTRAINT `FK_movie_TO_role_1` FOREIGN KEY (
	`ro_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie_file` ADD CONSTRAINT `FK_file_TO_movie_file_1` FOREIGN KEY (
	`mf_fi_num`
)
REFERENCES `file` (
	`fi_num`
);

ALTER TABLE `movie_file` ADD CONSTRAINT `FK_movie_TO_movie_file_1` FOREIGN KEY (
	`mf_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `theater` ADD CONSTRAINT `FK_region_TO_theater_1` FOREIGN KEY (
	`th_re_name`
)
REFERENCES `region` (
	`re_name`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_theater_TO_screen_1` FOREIGN KEY (
	`sc_th_num`
)
REFERENCES `theater` (
	`th_num`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_screen_TO_seat_1` FOREIGN KEY (
	`se_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `movie-schedule` ADD CONSTRAINT `FK_movie_TO_movie-schedule_1` FOREIGN KEY (
	`ms_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `movie-schedule` ADD CONSTRAINT `FK_screen_TO_movie-schedule_1` FOREIGN KEY (
	`ms_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_member_TO_reservation_1` FOREIGN KEY (
	`rv_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `reservation` ADD CONSTRAINT `FK_movie-schedule_TO_reservation_1` FOREIGN KEY (
	`rv_ms_num`
)
REFERENCES `movie-schedule` (
	`ms_num`
);

ALTER TABLE `reservation_list` ADD CONSTRAINT `FK_reservation_TO_reservation_list_1` FOREIGN KEY (
	`rl_rv_num`
)
REFERENCES `reservation` (
	`rv_num`
);

ALTER TABLE `reservation_list` ADD CONSTRAINT `FK_seat_TO_reservation_list_1` FOREIGN KEY (
	`rl_se_num`
)
REFERENCES `seat` (
	`se_num`
);

ALTER TABLE `reservation_list` ADD CONSTRAINT `FK_price_TO_reservation_list_1` FOREIGN KEY (
	`rl_pr_num`
)
REFERENCES `price` (
	`pr_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_movie_TO_review_1` FOREIGN KEY (
	`re_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_member_TO_review_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_member_TO_like_1` FOREIGN KEY (
	`li_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_review_TO_like_1` FOREIGN KEY (
	`li_re_num`
)
REFERENCES `review` (
	`re_num`
);

