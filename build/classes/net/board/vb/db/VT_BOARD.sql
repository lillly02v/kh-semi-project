DROP TABLE VT_BOARD;

CREATE TABLE VT_BOARD(
	VBNUM NUMBER(10) NOT NULL,  
	VID VARCHAR2(30) NOT NULL,
	VPASS VARCHAR2(30) NOT NULL,
	VNAME VARCHAR2(30) NOT NULL,    
	VBSUB VARCHAR2(100) NOT NULL,   
	VBCONT VARCHAR2(3000) NOT NULL,    
	VBWEEK VARCHAR2(50) NOT NULL,  
	VBPOSTIME VARCHAR2(50) NOT NULL,   
	VBAREA VARCHAR2(20) NOT NULL,   
	VBRELIG VARCHAR2(20) NOT NULL,
	VBCHRAC VARCHAR2(50) NOT NULL,   
	VBEXPER VARCHAR2(20) NOT NULL,   
	VBEXCONT VARCHAR2(300) NOT NULL,  
	VBCERTI  VARCHAR2(1500),
	VBDATE DATE NOT NULL,     
	VBVISIT NUMBER(10) NOT NULL, 
	VBREADCOUNT NUMBER NOT NULL,
	PRIMARY KEY(VBNUM) 
);

insert into VT_BOARD (VBNUM, VID, VPASS, VNAME, VBSUB, VBCONT, VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, VBEXCONT, VBCERTI, VBDATE, VBVISIT, VBREADCOUNT) VALUES
										(1, 'ADMIN', 1111, 'ADMIN', 'EX', 'HI', 'MONDAY', 'WHENEVER', 'SEOUL', 'NOTHING', 'ACTIVE', 'NONE', 'NOTHING', 'NONE', sysdate, 2, 2)

SELECT * FROM VT_BOARD;

DROP SEQUENCE VT_BOARD_SEQ;

SELECT VBNUM, VID, VPASS, VNAME, VBSUB, VBCONT, VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, VBEXCONT, VBCERTI, VBDATE, VBVISIT
FROM (SELECT * FROM VT_BOARD ORDER BY VBNUM DESC);

select * from (select rownum rnum, VBNUM, VID, VNAME, VBSUB, VBCONT, 
	VBWEEK, VBPOSTIME, VBAREA, VBRELIG, VBCHRAC, VBEXPER, 
	VBEXCONT, VBDATE, VBVISIT, VBCERTI, VBREADCOUNT from 
	(select * from VT_BOARD order by VBNUM desc))
	where vid = 'admin';