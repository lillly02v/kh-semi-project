package net.board.notice.db;

import java.sql.Date;

public class NTBoardVO {
	private int ntnum;
	private String aid;
	private String aname;
	private String ntsub;
	private String ntcont;
	private String ntfiles;
	private Date ntdate;
	private int ntvisit;
	
	public int getNtnum() {
		return ntnum;
	}
	public void setNtnum(int ntnum) {
		this.ntnum = ntnum;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getNtsub() {
		return ntsub;
	}
	public void setNtsub(String ntsub) {
		this.ntsub = ntsub;
	}
	public String getNtcont() {
		return ntcont;
	}
	public void setNtcont(String ntcont) {
		this.ntcont = ntcont;
	}
	public String getNtfiles() {
		return ntfiles;
	}
	public void setNtfiles(String ntfiles) {
		this.ntfiles = ntfiles;
	}
	public Date getNtdate() {
		return ntdate;
	}
	public void setNtdate(Date ntdate) {
		this.ntdate = ntdate;
	}
	public int getNtvisit() {
		return ntvisit;
	}
	public void setNtvisit(int ntvisit) {
		this.ntvisit = ntvisit;
	}
}
