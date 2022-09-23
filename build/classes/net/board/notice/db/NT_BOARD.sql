drop table NT_BOARD;
create sequence board_seq start with 1 increment by 1;

create table NT_BOARD(
	NTNUM		NUMBER(10) not null primary key,
	AID			VARCHAR2(30),
	ANAME		VARCHAR2(30) not null,
	NTSUB		VARCHAR2(100) not null,
	NTCONT		VARCHAR2(4000) not null,
	NTFILES		VARCHAR2(200),
	NTDATE		DATE not null,
	NTVISIT		NUMBER(10) not null
);

select * from NT_BOARD;

delete from NT_BOARD where ntnum = 23;

select * from(select rownum rnum, NTNUM, AID,  ANAME, NTSUB, NTCONT, NTFILES,NTDATE, NTVISIT
	from NT_BOARD order by ntdate desc)

alter table NT_BOARD modify ntcont varchar2(4000)