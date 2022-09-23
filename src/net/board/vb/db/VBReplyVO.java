package net.board.vb.db;

import java.util.Date;

public class VBReplyVO {
	private int vrnum;
	private int vvbnum;
	private String usid;
	private String upass;
	private String vrcont;
	private Date vrdate;
	private int vrparent;
	private String vrsecret;
	
	public int getVrnum() {
		return vrnum;
	}
	public void setVrnum(int vrnum) {
		this.vrnum = vrnum;
	}
	public int getVvbnum() {
		return vvbnum;
	}
	public void setVvbnum(int vvbnum) {
		this.vvbnum = vvbnum;
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
	public String getVrcont() {
		return vrcont;
	}
	public void setVrcont(String vrcont) {
		this.vrcont = vrcont;
	}
	public Date getVrdate() {
		return vrdate;
	}
	public void setVrdate(Date vrdate) {
		this.vrdate = vrdate;
	}
	public int getVrparent() {
		return vrparent;
	}
	public void setVrparent(int vrparent) {
		this.vrparent = vrparent;
	}
	public String getVrsecret() {
		return vrsecret;
	}
	public void setVrsecret(String vrsecret) {
		this.vrsecret = vrsecret;
	}
	
	
}
