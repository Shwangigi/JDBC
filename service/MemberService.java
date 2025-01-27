package com.board.www.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.board.www.dao.MemberDAO;
import com.board.www.dto.MemberDTO;

public class MemberService {
	// 회원에 대한 처리 C(회원가입),R(로그인),U(회원정보수정),D(회원탈퇴)
	public static int result = 0;

	public MemberDTO memberMenu(Scanner scanner, MemberDTO loginMember, Connection connection) throws SQLException { // while문으로
																														// 부메뉴
																														// 반복
																														// 처리
		System.out.println("-----------회원관리영 서비스--------");
		boolean memberRun = true;

		while (memberRun) {
			System.out.println("1.회원가입 | 2.로그인 | 3.회원수정 | 4.회원탈퇴 | 5.종료");
			System.out.print(">>>");
			int memberSelect = scanner.nextInt();
			switch (memberSelect) {
			case 1:
				join(scanner, connection);
				break;
			case 2:
				loginMember = login(scanner, loginMember, connection);
				break;
			case 3:
				modify(scanner,connection);
				break;
			case 4:
				delete(scanner, connection);
				break;
			case 5:
				System.out.println("회원관리 메서드를 종료합니다.");
				memberRun = false;
			} // switch문 종료
		} // while문 종료
		return loginMember;
	} // memberMenu() 종료

	public void join(Scanner scanner, Connection connection) { // 회원가입용 메서드
		System.out.println("회원가입 메서드로 진입");
		System.out.print("id : ");
		String joinId = scanner.next();
		System.out.print("pw : ");
		String joinPw = scanner.next();
		MemberDTO joinMemberDTO = new MemberDTO();
		joinMemberDTO.setMid(joinId);
		joinMemberDTO.setMpw(joinPw);
		MemberDAO memberDAO = new MemberDAO();
		result = memberDAO.register(connection, joinMemberDTO);
		if (result == 0) {
			System.out.println("중복된 id가 존재합니다!");
		} else if (result > 0) {
			System.out.println(joinMemberDTO.getMid() + "님의 회원가입을 축하합니다.");
		}
	}// 회원가입용 동작 종료

	public MemberDTO login(Scanner scanner, MemberDTO loginMember, Connection connection) { // 로그인용 메서드
		System.out.println("로그인 메서드로 진입");
		System.out.print("id : ");
		String loginId = scanner.next();
		System.out.print("pw : ");
		String loginPw = scanner.next();
		MemberDTO loginMemberDTO = new MemberDTO(loginId, loginPw);
		// 키보드로 입력받은 값을 객체로 생성
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.login(connection, loginMemberDTO);
		return memberDAO.login(connection, loginMemberDTO);
		// db에서 넘어온 객체를 리턴한다.
	} // 로그인 메서드 종료

	public void modify(Scanner scanner, Connection connection) { // 회원정보 수정 종료 메서드
		System.out.println("회원정보 수정 메서드로 진입");
		MemberDTO modifyDTO = new MemberDTO();
		modifyDTO = search(scanner, connection);
		System.out.println("------수정할 pw-------");
		System.out.println("pw :");
		String mdPw = scanner.next();
		modifyDTO.setMpw(mdPw);
		// 키보드로 입력받은 객체 생성		
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.update(connection, modifyDTO);
		
	} // 정보수정 종료

	public void delete(Scanner scanner, Connection connection) { // 회원탈퇴 메서드
		System.out.println("회원탈퇴 메서드로 진입");
		MemberDTO deleteDTO = new MemberDTO();
		deleteDTO = search(scanner, connection);
		System.out.println("정말 탈퇴를 진행하시겠습니까?");
		System.out.println("1.예 | 2.아니요");
		int deleteS = scanner.nextInt();
		switch(deleteS) {
		case 1:
			System.out.println("탈퇴를 진행하겠습니다.\npw를 입력해주세요.");
			System.out.println("pw : ");
			String deletepW = scanner.next();
			deleteDTO.setMpw(deletepW);	
			MemberDAO deleteDAO = new MemberDAO();
			// 아이디 확인 메시지 3번 나옴 추후 수정
			deleteDAO.delete(connection, deleteDTO);
			break;
		case 2:
			System.out.println(deleteDTO.getMid() + "다시 한번 환영합니다.");
			break;
		default:
			System.out.println(">>> 입력 오류 <<<");
		}// switch문 종료
		
	} // 회원탈퇴 메서드 종료
	
	
	public MemberDTO search(Scanner scanner,Connection connection ) { // 아이디 중복검사 메서드
		System.out.println("---------id,pw-------");
		System.out.print("id : ");
		String searchId = scanner.next();
		System.out.print("pw : ");
		String searchPw = scanner.next();
		MemberDTO searchDTO = new MemberDTO(searchId,searchPw);
		//키보드로 입력 받은 객체 생성
		MemberDAO searchDAO = new MemberDAO();
		searchDAO.searchId(connection, searchDTO);
		return searchDTO;
	}
}
