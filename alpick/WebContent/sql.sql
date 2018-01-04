create table users (ID varchar2(20) primary key not null, pw varchar2(20) not null, nickname varchar2(20) not null, year varchar2(10) not null, user_type varchar2(10) default 0)

create table al_info(product_no varchar2(20) primary key not null, product_name varchar2(20), alcohol varchar2(20), price varchar2(20), volume varchar2(10))

create table al_dict(sequence_no number(10) primary key not null, product_no varchar2(20) references al_info(product_no) not null, member_id varchar2(20) references users(ID) not null, score varchar2(10) default 0, time varchar2(10) not null)



