create table news_board(	--뉴스 게시판(자료실or정보마당)
	NENUM		NUMBER not null,			--뉴스 번호
	AID			VARCHAR2(30),	--관리자 아이디
	ANAME		VARCHAR2(30) not null,	-- 관리자 이름
	NESUB		VARCHAR2(200) not null,	--뉴스 제목
	NECONT		VARCHAR2(4000) not null,	--뉴스 내용
	NEFILES		VARCHAR2(200), 		--뉴스 첨부파일
	NEDATE		DATE not null,		--뉴스 작성일
	NEVISIT		NUMBER not null,	--뉴스 조회수
	primary key(NENUM)	
);


select * from news_board where nenum = 23;

alter table news_board modify(nesub varchar2(200));

Delete news_board where nenum = 23;



