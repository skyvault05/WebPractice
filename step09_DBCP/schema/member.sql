select *from member; -- option+x

drop table member;
--회원가입 테이블 생성

create table member(
   id varchar2(20) primary key ,
   pwd varchar2(20) not null,
   name varchar2(20) not null,
   age int,
   phone varchar(15),
   addr varchar2(50),
   join_date date not null
);

select * from member;
--레코드 추가
insert into member(id,pwd,name,age,phone,addr, join_date)
values('jang','1234','장희정',20,'010-8875-8253','서울시 광진구', sysdate);

commit;

SELECT * FROM member WHERE lower(id) = lower('jang');