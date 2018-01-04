create table users (ID varchar2(20) primary key not null, pw varchar2(20) not null, nickname varchar2(20) not null, year varchar2(10) not null, user_type varchar2(10) default 0)

create table al_info(product_no varchar2(20) primary key not null, product_name varchar2(20), alcohol varchar2(20), price varchar2(20), volume varchar2(10))

create table al_dict(sequence_no number(10) primary key not null, product_no varchar2(20) references al_info(product_no) not null, member_id varchar2(20) references users(ID) not null, score varchar2(10) default 0, time varchar2(10) not null)

create table theme(atmosphere varchar2(20) not null, place varchar2(20), with_who varchar2(20) not null, anniversary varchar2(20), product_no varchar2(10) references al_info(product_no) not null)



select * from users
insert into users values('park2','1234','park2','1992-05-19','AAAA');

select * from users;



