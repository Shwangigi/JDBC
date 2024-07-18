package com.board.www.dto;

import java.sql.Date;

public class MemberDTO {
	//필드
	private int mno;
	private String mid;
	private String mpw;
	private Date mdate;

	// 생성자
	public MemberDTO() {
		
	}// 기본생성자 -> new MemberDTO();
	
	
	
	public MemberDTO(String loginId, String loginPw) {
		this.mid = loginId;
		this.mpw = loginPw;
	} // 커스텀 생성자 -> id와 pw 처리용



	// 메서드 -> 게터, 세터 (필드를 보호하기 위함)
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	

}
