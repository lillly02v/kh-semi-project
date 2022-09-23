package net.user.member.db;

import java.util.Date;

public class VTMatchVO {
	private int mNum;
	private int boardNum;
	private String requestMb;
	private String responseMb;
	private String matching;
	private String confirm;
	private Date matchDate;
	private Date approveDate;
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getRequestMb() {
		return requestMb;
	}
	public void setRequestMb(String requestMb) {
		this.requestMb = requestMb;
	}
	public String getResponseMb() {
		return responseMb;
	}
	public void setResponseMb(String responseMb) {
		this.responseMb = responseMb;
	}
	public String getMatching() {
		return matching;
	}
	public void setMatching(String matching) {
		this.matching = matching;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	
}
