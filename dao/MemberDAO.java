package com.board.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.www.dto.MemberDTO;

public class MemberDAO {
	// 회원 DB에 대한 C(회원가입) R(로그인) U(회원정보수정) D(회원탈퇴)

	public MemberDAO() {

	} // 기본생성자:커스텀 있으면 무조건 만들어줘야 함

	public MemberDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	} // 커스텀 생성자

	public int register(Connection connection, MemberDTO joinMemberDTO) {
		PreparedStatement preparedStatement = null;
//		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet = null;
		try {
			// ID 중복 확인
			String ipCheck = "SELECT mid FROM member";
			preparedStatement = connection.prepareStatement(ipCheck);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getString("mid").equals(joinMemberDTO.getMid())) {

					return 0;
				}
			}
			resultSet.close();
			preparedStatement.close();

			String sql = "insert into member(mno, mid, mpw, mdate) values(board_seq.nextval, ?, ?, sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, joinMemberDTO.getMid());
			preparedStatement.setString(2, joinMemberDTO.getMpw());

			int result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println(result + "개 입력 확인");
			}

			preparedStatement.close();
			return result;

		} catch (SQLException e) {
			System.out.println("회원 : id와 pw를 확인하세요");
			e.printStackTrace();
		}

		return 0;
	} // 회원가입 종료

	public MemberDTO login(Connection connection, MemberDTO loginMemberDTO) { // 로그인
		// connection -> main에서 넘어온 jdbc 1,2단계
		// loginMemberDTO -> 로그인시 키보드로 입력받은 id,pw 값이 들어 있다.
		// db에 있는 로그인 값을 찾아옴
		MemberDTO loginDTO = new MemberDTO();
		// 리턴용 빈 객체
		try {
			String sql = "select mno,mid,mpw,mdate from member where mid =? and mpw = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginMemberDTO.getMid());
			// service에서 받은 id가 첫번째 ?에 적용
			preparedStatement.setString(2, loginMemberDTO.getMpw());
			// service에서 받은 pw가 두번째 ?에 적용

			ResultSet resultSet = preparedStatement.executeQuery();
			// 위에서 만든 쿼리문을 실행하고 결과를 resultSet 표로 만든다.

			while (resultSet.next()) {

				loginDTO.setMno(resultSet.getInt("mno"));
				loginDTO.setMid(resultSet.getString("mid"));
				loginDTO.setMpw(resultSet.getString("mpw"));
				loginDTO.setMdate(resultSet.getDate("mdate"));
				// resultSet 표에 있는 정보를 MemberDTO 객체에 넣음
			}

			resultSet.close();
			preparedStatement.close();
//			return loginDTO;
		} catch (SQLException e) {
			System.out.println("찾는 id 와 pw가 없습니다.");
			System.out.println("관리자 : sql문을 확인하세요");
			System.out.println("회원 : id와 pw를 확인하세요");
			e.printStackTrace();
		}
		return loginDTO; // 로그인 완성용 객체
	} // 로그인 종료

	public void update() { // 회원정보 수정

	} // 회원정보 수정 종료

	public void delete() { // 회원정보 삭제

	} // 회원정보 삭제 종료
}
