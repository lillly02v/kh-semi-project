package net.board.wb.db;

import java.util.Date;

public class WBReplyVO {
	private int wrnum;
	private int wwbnum;
	private String usid;
	private String upass;
	private String wrcont;
	private Date wrdate;
	private int wrparent;
	
	public int getWrparent() {
		return wrparent;
	}
	public void setWrparent(int wrparent) {
		this.wrparent = wrparent;
	}
	private String wrsecret;
	
	public int getWwbnum() {
		return wwbnum;
	}
	public void setWwbnum(int wwbnum) {
		this.wwbnum = wwbnum;
	}
	public int getWrnum() {
		return wrnum;
	}
	public void setWrnum(int wrnum) {
		this.wrnum = wrnum;
	}

	public String getUsid() {
		return usid;
	}
	public void setUsid(String usid) {
		this.usid = usid;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getWrcont() {
		return wrcont;
	}
	public void setWrcont(String wrcont) {
		this.wrcont = wrcont;
	}
	public Date getWrdate() {
		return wrdate;
	}
	public void setWrdate(Date wrdate) {
		this.wrdate = wrdate;
	}
	public String getWrsecret() {
		return wrsecret;
	}
	public void setWrsecret(String wrsecret) {
		this.wrsecret = wrsecret;
	}
	
}
