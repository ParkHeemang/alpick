create table users (ID varchar2(20) primary key not null, pw varchar2(20) not null, nickname varchar2(20) not null, year varchar2(10) not null, user_type varchar2(10) default 0)

create table al_info(product_no varchar2(20) primary key not null, barcode varchar2(15) default 0, product_name varchar2(20), alcohol varchar2(20), price varchar2(20), volume varchar2(10))

create table al_dict(sequence_no number(10) primary key not null, product_no varchar2(20) references al_info(product_no) not null, member_id varchar2(20) references users(ID) not null, score varchar2(10) default 0, time varchar2(10) not null)

create table theme(atmosphere varchar2(20) not null, place varchar2(20), with_who varchar2(20) not null, anniversary varchar2(20), product_no varchar2(10) references al_info(product_no) not null)

create sequence sequence_no start with 1 increment by 1;


drop sequence sequence_no;


drop table users
drop table al_info
drop table al_dict
drop table theme

insert into al_info values('2','1234567890124','카스','10','2000','500')
insert into users values('kim','1234','kim','1992-05-19','AAAA');


select * from users
select * from al_info;
select * from al_dict;





insert into al_dict values(sequence_no.nextval,'1','park3','5',to_char(sysdate,'YYYY-MM-DD'));
insert into al_info values('1','참이슬','30','3000','250')

