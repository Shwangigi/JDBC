package com.board.www.service;

import java.sql.Connection;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

import com.board.www.dao.BoardDAO;
import com.board.www.dao.MemberDAO;
import com.board.www.dto.BoardDTO;
import com.board.www.dto.MemberDTO;

public class BoardService {
	// board의 부메뉴 (c,r,u,d)
	public void boardMenu(Scanner scanner,Connection connection) { // 보드 본체
	boolean run = true;
	while(run) {
	System.out.println("=========게시판=========");
	System.out.println("1.전체리스트 | 2.게시물등록 | 3.게시물 검색 | 4.게시물 수정 | 5.게시물 삭제 | 6.종료");
	int boardSelect = scanner.nextInt();
	switch(boardSelect){
	case 1:
		list(connection);
		break;
	case 2:
		register(scanner, connection);
		break;
	case 3:
		search(scanner, connection);
		break;
	case 4:
		modify(scanner, connection);
		break;
	case 5:
		delete(scanner, connection);
		break;
	case 6:
		System.out.println("게시판 메뉴를 종료합니다.");
		run = false;
		break;
		default:
			System.out.println(">>> 입력오류 <<<");
	}
	} // while문 종료
} // 보드 본체
	public void list(Connection connection) { // 게시물 목록 보기
		BoardDAO boardDAO = new BoardDAO();
		System.out.println("==========================");
		System.out.println("=====대나무 숲 게시판=========");
		System.out.println("[게시물 목록]");
		System.out.println("-----------------------------------------------");
		System.out.println("no       title          writer             date");
		System.out.println("-----------------------------------------------");
		
		boardDAO.list(connection);
	}

	public void register(Scanner scanner, Connection connection) { // 게시물 등록
		System.out.println("-------------게시물 등록-----------");
		System.out.println("제목 : ");
		String rgTitle = scanner.next();
		System.out.println("내용 : ");
		String rgContent = scanner.next();
		System.out.println("닉네임 : ");
		String rgWriter = scanner.next();
		BoardDTO rgBoardDTO = new BoardDTO(rgTitle, rgContent,rgWriter);
		BoardDAO rgBoardDAO = new BoardDAO();
		rgBoardDAO.register(connection, rgBoardDTO);
	} // 게시물 등록 종료

    public void search(Scanner scanner, Connection connection) { // 게시물 검색
    	System.out.println("------게시물 검색------");
    	System.out.println("검색한 게시글의 닉네임 : ");
    	String srWriter = scanner.next();
    	BoardDTO srBoardDTO = new BoardDTO(srWriter);
    	BoardDAO srBoardDAO = new BoardDAO();
    	srBoardDAO.search(connection, srBoardDTO);
    } // 게시물 검색 종료

    public void modify(Scanner scanner, Connection connection) { // 게시물 수정
    	search(scanner, connection);
    	System.out.println("-------------------");
    	System.out.println("수정할 게시글 번호 : ");
    	int mono = scanner.nextInt();
    	System.out.println("수정할 제목 : ");
    	String moTitle = scanner.next();
    	System.out.println("수정할 내용 : ");
    	String mocontent = scanner.next();
    	BoardDTO moBoardDTO = new BoardDTO();
    	moBoardDTO.setBno(mono);
    	moBoardDTO.setBtitle(moTitle);
    	moBoardDTO.setBcontent(mocontent);
    	BoardDAO moBoardDAO = new BoardDAO();
    	moBoardDAO.modify(connection,moBoardDTO);
    } // 게시물 수정 종료

    public void delete(Scanner scanner, Connection connection) { // 게시물 삭제
    	search(scanner, connection);
    	System.out.println("----------------");
    	System.out.println("삭제할 게시글 번호 : ");
    	int delNo = scanner.nextInt();
    	BoardDTO delBoardDTO = new BoardDTO();
    	delBoardDTO.setBno(delNo);
    	BoardDAO delBoardDAO = new BoardDAO();
    	delBoardDAO.delete(connection, delBoardDTO);
    } // 게시물 삭제 종료


}
