
drop table VT_MATCH;
drop sequence VT_MATCH_SEQ;

drop table WR_MATCH;
drop sequence WR_MATCH_SEQ;

create table VT_MATCH(
	MNUM NUMBER NOT NULL PRIMARY KEY,
	BOARDNUM NUMBER NOT NULL,
	REQUESTMB VARCHAR2(30) NOT NULL,
	RESPONSEMB VARCHAR2(30) NOT NULL,
	MATCHING VARCHAR2(20),
	CONFIRM VARCHAR2(20),
	MATCHDATE DATE NOT NULL,
	APPROVEDATE DATE
)

create table WR_MATCH(
	MNUM NUMBER NOT NULL PRIMARY KEY,
	BOARDNUM NUMBER NOT NULL,
	REQUESTMB VARCHAR2(30) NOT NULL,
	RESPONSEMB VARCHAR2(30) NOT NULL,
	MATCHING VARCHAR2(20),
	CONFIRM VARCHAR2(20),
	MATCHDATE DATE NOT NULL,
	APPROVEDATE DATE
)


alter table vt_match rename column VMNUM to MNUM;
alter table wr_match rename column WMNUM to MNUM;

select BOARDNUM from VT_MATCH minus select VBNUM from VT_BOARD;



alter table VT_MATCH add constraint volunteerBoardNum foreign key(BOARDNUM) references VT_BOARD(VBNUM) on delete cascade;
alter table WR_MATCH add constraint welfareBoardNum foreign key(BOARDNUM) references WR_BOARD(WBNUM) on delete cascade;

create sequence VT_MATCH_SEQ
start with 1
increment by 1
nocache;

create sequence WR_MATCH_SEQ
start with 1
increment by 1
nocache;

insert into VT_MATCH(MNUM, BOARDNUM, REQUESTMB, RESPONSEMB, MATCHING, MATCHDATE) values(VT_MATCH_SEQ.NEXTVAL, 12, 'admin', 'qwer', '매칭중', sysdate);
insert into WR_MATCH(MNUM, BOARDNUM, REQUESTMB, RESPONSEMB, MATCHING, MATCHDATE) values(WR_MATCH_SEQ.NEXTVAL, 13, 'admin', 'qwer', '매칭중', sysdate);
insert into VT_MATCH values(VT_MATCH_SEQ.NEXTVAL, 17, 'admin', 'qwer', '매칭중', sysdate, null);

select * from vt_match;
select * from wr_match;

update VT_MATCH set MATCHING = '매칭완료', MATCHDATE = sysdate where boardnum = 2
	where MNUM = 1 and BOARDNUM = 11 and REQUESTMB = 'admin' and RESPONSEMB ='asdf';

delete vt_match;
delete wr_match;