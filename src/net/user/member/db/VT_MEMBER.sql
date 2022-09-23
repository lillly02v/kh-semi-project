DROP TABLE VT_MEMBER;

CREATE TABLE VT_MEMBER(
	VID VARCHAR2(30) NOT NULL PRIMARY KEY,
	VPASS VARCHAR2(30) NOT NULL,
	VNAME VARCHAR2(30) NOT NULL,
	VRESID NUMBER(20) NOT NULL,
	VGENDER VARCHAR2(10) NOT NULL,
	VJOB VARCHAR2(30) NOT NULL,
	VPHONE VARCHAR2(20) NOT NULL,
	VEMAIL VARCHAR2(30) NOT NULL,
	VPOST VARCHAR2(10) NOT NULL,
	VADDRESS VARCHAR2(200) NOT NULL,
	VADDRLAT NUMBER(30, 25) NOT NULL,
	VADDRLNG NUMBER(30, 25) NOT NULL,
	VKEY VARCHAR2(100) NOT NULL,
	VINTRO VARCHAR2(500),
	VDATE DATE NOT NULL,
	VSECRET VARCHAR2(15) NOT NULL
)

select * from vt_member where vid = 'qwer';

select substr(VDATE, 4, 2) from vt_member group by VDATE;

select month, count(month) from
	(select substr(VDATE, 4, 2) as month from vt_member)
		group by month order by month;
select substr(VDATE, 4, 2) from vt_member where vid = 'admin';

select substr(VRESID, 3, 8) from vt_member where vid = 'admin';

select (sysdate - VRESID) from vt_member where vid = 'admin';

select AGE, count(AGE) from
	(select (FLOOR((MONTHS_BETWEEN(SYSDATE, TO_DATE(VRESID, 'YYYYMMDD'))/12)/10) * 10) AS AGE FROM VT_MEMBER) 
		group by AGE order by AGE;

update vt_member set vdate = to_date('2018-03-05 10:13:15','YYYY-MM-DD HH24:MI:ss') where vid ='qwe10';

select * from 
	(select rownum num, VID, VPASS, VNAME, VRESID, VGENDER, VJOB,
			VPHONE, VEMAIL, VPOST, VADDRESS, VADDRLAT, VADDRLNG,
			VKEY, VINTRO, VDATE, VSECRET FROM
		(select VID, VPASS, VNAME, VRESID, VGENDER, VJOB,
				VPHONE, VEMAIL, VPOST, VADDRESS, VADDRLAT, VADDRLNG,
				VKEY, VINTRO, VDATE, VSECRET FROM VT_MEMBER ORDER BY VNAME ASC));
			

update VT_MEMBER set VRESID = 19920518 where VID = 'zxcv';

update VT_MEMBER set VPASS = '111', VRESID = 901001, VGENDER = '남자', VJOB = '학생', VPHONE = '010-1111-2222', 
			VEMAIL = 'admin12@gmail.com', VPOST = 123, VADDRESS = '강원도 원주시', VADDRLAT = 57, VADDRLNG = 123, 
			VKEY = '언변이 좋아요', VINTRO = '안녕', VSECRET = '공개'
			where VID = 'admin4';
			

			
delete from vt_member where vid='admin';


