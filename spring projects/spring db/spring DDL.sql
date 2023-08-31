drop database if exists spring;
CREATE DATABASE spring;
USE spring;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_email`	varchar(50)	NULL,
	`me_role`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bo_num`	int	NOT NULL,
	`bo_title`	varchar(50)	NULL,
	`bo_contents`	longtext	NULL,
	`bo_views`	int	NULL,
	`bo_reg_date`	datetime	NULL,
	`bo_up_date`	datetime	NULL,
	`bo_ori_num`	int	NULL,
	`bo_me_id`	varchar(15)	NOT NULL,
	`bo_up`	int	NULL,
	`bo_down`	int	NULL,
	`bo_comment`	int	NULL,
	`bo_bt_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `like`;

CREATE TABLE `like` (
	`li_num`	int	NOT NULL,
	`li_state`	int	NULL,
	`li_me_id`	varchar(15)	NOT NULL,
	`li_bo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `board_type`;

CREATE TABLE `board_type` (
	`bt_num`	int	NOT NULL,
	`bt_title`	varchar(20)	NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`co_num`	int	NOT NULL,
	`co_contents`	longtext	NULL,
	`co_ori_num`	int	NULL,
	`co_bo_num`	int	NOT NULL,
	`co_me_id`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL,
	`fi_name`	varchar(100)	NULL,
	`fi_ori_name`	varchar(50)	NULL,
	`fi_bo_num`	int	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`bo_num`
);

ALTER TABLE `like` ADD CONSTRAINT `PK_LIKE` PRIMARY KEY (
	`li_num`
);

ALTER TABLE `board_type` ADD CONSTRAINT `PK_BOARD_TYPE` PRIMARY KEY (
	`bt_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`co_num`
);

ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
	`fi_num`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_board_type_TO_board_1` FOREIGN KEY (
	`bo_bt_num`
)
REFERENCES `board_type` (
	`bt_num`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_member_TO_like_1` FOREIGN KEY (
	`li_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `like` ADD CONSTRAINT `FK_board_TO_like_1` FOREIGN KEY (
	`li_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (
	`co_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`co_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

