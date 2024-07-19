package hairshop1.dto;

import oracle.sql.DATE;

public class DesignerDTO {
	// 멤버
	private String  mid; // 아이디
	private String mpw; // 비밀번호
	private String mname; // 이름: 디자이너
	// 리뷰 
	private int rno;
	private DATE rdate; // 
	private String rwriter;
	private String rcontents;
	private int rdesignernum;
	 // 뷱
	private String bdate;

	// 타임
	private String ttime;
	private String status;
	
	

	//  기본생성자 
	public DesignerDTO() {
		
	}
	
	// 게터, 세터	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTtime() {
		return ttime;
	}


	public void setTtime(String ttime) {
		this.ttime = ttime;
	}
	
	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public int getRno() {
		return rno;
	}



	public void setRno(int rno) {
		this.rno = rno;
	}



	public DATE getRdate() {
		return rdate;
	}



	public void setRdate(DATE rdate) {
		this.rdate = rdate;
	}



	public String getRwriter() {
		return rwriter;
	}



	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}



	public String getRcontents() {
		return rcontents;
	}



	public void setRcontents(String rcontents) {
		this.rcontents = rcontents;
	}



	public int getRdesignernum() {
		return rdesignernum;
	}



	public void setRdesignernum(int rdesignernum) {
		this.rdesignernum = rdesignernum;
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	
}
