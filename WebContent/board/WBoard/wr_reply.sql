drop table wr_reply;

create table wr_reply(
wrnum number(10) not null,
wwbnum number not null,
usid varchar2(30),
wrcont varchar2(300) not null,
wrdate date,
wrsecret varchar2(15),
constraint pk_wr primary key(wrnum),
constraint fk_wr foreign key(wwbnum) references wr_board(wbnum)
);

insert into wr_reply values( 1 , 1 , 'admin' , '안녕하세요' , sysdate , '비밀' );

create sequence seq_wr_reply;

select*from wr_reply;

http://all-record.tistory.com/143?category=733042

select seq_wr_reply.currval from dual;

select * from wr_reply where wrnum = ();