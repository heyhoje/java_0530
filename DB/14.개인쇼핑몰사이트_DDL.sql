drop database if exists shoppingmall;
create database shoppingmall;

use shoppingmall;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)	NOT NULL primary key,
	`me_pw`	varchar(255)	not NULL,
	`me_phone`	varchar(13)	not NULL,
	`me_addr`	varchar(50)	NULL,
	`me_addr_detail`	varchar(50)	NULL,
	`me_post`	char(5)	NULL,
	`me_point`	int	not NULL default 0,
	`me_authority`	varchar(5)	not NULL default 'USER',
    `me_name` varchar(20) not NULL
);

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
	`ad_num`	int	NOT NULL primary key auto_increment,
	`ad_name`	varchar(15)	not NULL,
	`ad_addr`	varchar(50)	not NULL,
	`ad_addr_detail`	varchar(50) not	NULL,
	`ad_post`	char(5)	not NULL,
	`ad_me_id`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_code`	char(6)	NOT NULL primary key,
	`pr_name`	varchar(20)	not NULL,
	`pr_detail`	longtext	 not NULL,
	`pr_price`	int	not NULL
);

DROP TABLE IF EXISTS `option`;

CREATE TABLE `option` (
	`op_num`	int	NOT NULL primary key auto_increment,
	`op_name`	varchar(20)	not NULL,
	`op_amount`	int	not NULL default 0,
	`op_pr_code`	char(6)	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL primary key auto_increment,
	`fi_name`	varchar(50)	not NULL,
	`fi_pr_code`	char(6)	NOT NULL
);

DROP TABLE IF EXISTS `point`;

CREATE TABLE `point` (
	`po_num`	int	NOT NULL primary key auto_increment,
	`po_content`	varchar(30)	not NULL,
	`po_amount`	int	not NULL,
	`po_me_id`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`or_num`	int	NOT NULL primary key auto_increment,
	`or_total`	int	not NULL,
	`or_price`	int	not NULL,
	`or_use_point`	int	not NULL default 0,
	`or_save_point`	int	not NULL,
	`or_state`	varchar(10)	not NULL default '제품준비중',
	`or_me_id`	varchar(15)	NOT NULL,
	`or_ad_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `order_list`;

CREATE TABLE `order_list` (
	`ol_num`	int	NOT NULL primary key auto_increment,
	`ol_amount`	int	not NULL,
	`ol_price`	int	not NULL,
	`ol_or_num`	int	NOT NULL,
	`ol_op_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`ba_num`	int	NOT NULL primary key auto_increment,
	`ba_amount`	int	not NULL default 1,
	`ba_me_id`	varchar(15)	NOT NULL,
	`ba_op_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`re_num`	int	NOT NULL primary key auto_increment,
	`re_content`	longtext	not NULL,
	`re_thumb`	varchar(50)	NULL,
	`re_me_id`	varchar(15)	NOT NULL,
	`re_op_num`	int	NOT NULL
);

ALTER TABLE `address` ADD CONSTRAINT `FK_member_TO_address_1` FOREIGN KEY (
	`ad_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `option` ADD CONSTRAINT `FK_product_TO_option_1` FOREIGN KEY (
	`op_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_product_TO_file_1` FOREIGN KEY (
	`fi_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `point` ADD CONSTRAINT `FK_member_TO_point_1` FOREIGN KEY (
	`po_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`or_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_address_TO_order_1` FOREIGN KEY (
	`or_ad_num`
)
REFERENCES `address` (
	`ad_num`
);

ALTER TABLE `order_list` ADD CONSTRAINT `FK_order_TO_order_list_1` FOREIGN KEY (
	`ol_or_num`
)
REFERENCES `order` (
	`or_num`
);

ALTER TABLE `order_list` ADD CONSTRAINT `FK_option_TO_order_list_1` FOREIGN KEY (
	`ol_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_member_TO_basket_1` FOREIGN KEY (
	`ba_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_option_TO_basket_1` FOREIGN KEY (
	`ba_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_option_TO_review_1` FOREIGN KEY (
	`re_op_num`
)
REFERENCES `option` (
	`op_num`
);

ALTER TABLE `review` ADD CONSTRAINT `FK_member_TO_review_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

