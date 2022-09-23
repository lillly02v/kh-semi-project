DROP TABLE VT_REPLY;

CREATE TABLE VT_REPLY(
	vrnum NUMBER(10) NOT NULL,
	vvbnum number not null,
	usid VARCHAR2(30) NOT NULL,
	vrcont VARCHAR2(300) NOT NULL,    
	vrdate DATE NOT NULL,   
	vrsecret VARCHAR2(15) NOT NULL, 
	constraint pk_vr primary key(vrnum),
	constraint fk_vr foreign key(vvbnum) references VT_BOARD(vbnum)
);

insert into VT_REPLY values( 1 , 1 , 'admin' , '안녕하세요' , sysdate , '비밀' );

SELECT * FROM VT_REPLY;

create sequence VT_REPLY_SEQ;

drop sequence VT_REPLY_SEQ;
