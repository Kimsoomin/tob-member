create table member(
userid varchar2(20),
password varchar2(20), 
name varchar2(20),
birth varchar2(20),
phone varchar2(20),
email varchar2(50),
gender varchar2(10),
addr varchar2(50),
regdate varchar2(20),
profile varchar2(20),
constraint member_pk primary key userid
);

alter table member
add constraint member_pk primary key(userid);