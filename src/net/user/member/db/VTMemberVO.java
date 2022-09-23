/*
 * 	데이터 빈(DataBean) 클래스 작성
 * 게시판에서 사용되는 정보들을 데이터 빈이라는 하나의 객체에 저장하게 되고
 * 이 객체를 전달하면 각 정보를 하나씩 전달할 필요가 없으며
 * 한꺼번에 모든 정보가 전달됩니다.
 * 이런 클래스를 DTO(Data Transfer Object),
 * VO(Value Object)라고 합니다.
 * DB에서 만들었떤 컬럼명과 동일하게 프로퍼티를 생성합니다.
 */
package net.user.member.db;

import java.util.Date;

public class VTMemberVO {
	private int num;
	private String id;
	private String pass;
	private String name;
	private int resid;
	private String gender;
	private String job;
	private String phone;
	private String email;
	private String post;
	private String address;
	private double addrlat;
	private double addrlng;
	private String key;
	private String intro;
	private Date date;
	private String secret;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getResid() {
		return resid;
	}
	public void setResid(int resid) {
		this.resid = resid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAddrlat() {
		return addrlat;
	}
	public void setAddrlat(double addrlat) {
		this.addrlat = addrlat;
	}
	public double getAddrlng() {
		return addrlng;
	}
	public void setAddrlng(double addrlng) {
		this.addrlng = addrlng;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
}
