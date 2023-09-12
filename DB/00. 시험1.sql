use ex1;
create table TB_USER(
user_no intb_usert primary key auto_increment,
user_id varchar(50) unique not null,
user_name varchar(50) not null,
user_age int not null
);

insert into tb_user values(user_no, 'gd_hong', '홍길동', 20);
insert into tb_user values(user_no, 'sh_han', '한소희', 28);
insert into tb_user values(user_no, 'jm_park', '지민', 27);