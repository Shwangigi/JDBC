package com.board.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.board.www.dao.BoardDAO;
import com.board.www.dto.MemberDTO;
import com.board.www.service.BoardService;
import com.board.www.service.MemberService;

public class BoardMain {
	// 필드
	public static Scanner scanner = new Scanner(System.in);
	//public static BoardDAO boardDAO = new BoardDAO(); // JDBC 담당
	public static Connection connection = null;
	public static MemberDTO LoginMember = null; // 로그인 후 객체
	// 생성자
	public BoardMain() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.111.103:1521:orcl", "boardtest", "boardtest"); // 2단계
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 명 또는 ojdbc6.를 확인해주세요.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("url, id,pw나 쿼리문이 잘못됨");
			e.printStackTrace();
			System.exit(0); // 프로세스 강제 종료
		}
	} // 1_2단계 처리용
	
	// 메서드
	public static void main(String[] args) throws SQLException  {
		// 기본적인 설명 : 스케너 , jdbc 연동 , 주메뉴
		BoardMain boardMain = new BoardMain(); // 생성자 호출 -> 1단계 , 2단계 실행
		boolean run = true;
		System.out.println("MBC 아카데미 대나무숲 오신 걸 환영합니다.");
		while(run) {
		System.out.println("1. 회원 | 2.게시판 | 3.종료");
		System.out.print(">>>");
		int select = scanner.nextInt();
		switch(select) {
		case 1:
			System.out.println("회원 전용페이지로 이동합니다.");
			MemberService memberService = new MemberService();
			LoginMember = memberService.memberMenu(scanner,LoginMember,connection);
			System.out.println(LoginMember.getMid() + "님 환영합니다.");
			// 회원서비스에서 나올 떼 로그인 정보가 유지되어야 함
			break;
		case 2:
			System.out.println("게시판 페이지로 이동합니다.");
			BoardService boardService = new BoardService();
			boardService.boardMenu(scanner, connection);
			break;
		case 3:
			System.out.println("대나무 숲을 종료합니다.");
			run = false;
			break;
		default:
			System.out.println(">>> 입력 오류 <<<");
		} // switch문 종료
		}// while문 종료
	}// main 종료

}
