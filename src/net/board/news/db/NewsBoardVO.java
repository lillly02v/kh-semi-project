package net.board.news.db;

import java.sql.Date;

public class NewsBoardVO {
	private int nenum;		//뉴스 번호
	private String aid;		//관리자 아이디
	private String aname;	//관리자 이름
	private String nesub;	//뉴스 제목
	private String necont;	//뉴스 내용
	private String nefiles;	//뉴스 첨부파일
	private Date nedate;	//뉴스 작성일
	private int nevisit;	//뉴스 조회수
	
	public int getNenum() {
		return nenum;
	}
	public void setNenum(int nenum) {
		this.nenum = nenum;
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
	public String getNesub() {
		return nesub;
	}
	public void setNesub(String nesub) {
		this.nesub = nesub;
	}
	public String getNecont() {
		return necont;
	}
	public void setNecont(String necont) {
		this.necont = necont;
	}
	public String getNefiles() {
		return nefiles;
	}
	public void setNefiles(String nefiles) {
		this.nefiles = nefiles;
	}
	public Date getNedate() {
		return nedate;
	}
	public void setNedate(Date nedate) {
		this.nedate = nedate;
	}
	public int getNevisit() {
		return nevisit;
	}
	public void setNevisit(int nevisit) {
		this.nevisit = nevisit;
	}
}
