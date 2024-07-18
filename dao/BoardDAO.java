package com.board.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.www.dto.BoardDTO;
import com.board.www.dto.MemberDTO;

public class BoardDAO {
	// 데이터베이스 처리용 crud
	
	public void list(Connection ceonnection) { // 전체리스트 출력
//		BoardDTO boardDTO = null;
		try {
			String sql = "select bno,btitle,bcontent,bwriter,bdate from board order by bno desc";
			// board 테이블에 있는 데이터를 가져옴
			PreparedStatement preparedStatement = ceonnection.prepareStatement(sql); // 3단계
			ResultSet resultSet = preparedStatement.executeQuery(); // 4단계
//		    boardDTO = new BoardDTO();
			while(resultSet.next()) { // 표형식으로 리턴된 값 유무 판단
				System.out.print(resultSet.getInt("bno") + "\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bcontent") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
				
//				boardDTO.setBno(resultSet.getInt("bno"));
//				boardDTO.setBtitle(resultSet.getString("btitle"));
//				boardDTO.setBcontent(resultSet.getString("bcontent"));
//				boardDTO.setBwriter(resultSet.getString("bwriter"));
//				boardDTO.setBdate(resultSet.getDate("bdate"));
			}
			// 5단계
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("BoardDAO.list() sql문 오류");
			e.printStackTrace();
		} 
	}

	public void register(Connection connection, BoardDTO rgBoardDTO ) { // 게시물 등록
		try {
			String sql = "insert into board(bno, btitle, bcontent, bwriter,bdate) values(board_seq.nextval, ?, ?,?, sysdate)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, rgBoardDTO.getBtitle());
			preparedStatement.setString(2, rgBoardDTO.getBcontent());
			preparedStatement.setString(3, rgBoardDTO.getBwriter());
              
			int result = preparedStatement.executeUpdate();
			
			if(result > 0 ) {
				System.out.println("게시물이 등록되었습니다.");
			}else {
				System.out.println("게시물이 등록되지 않았습니다.");
			}
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println(">>> 입력 오류 <<<");
			e.printStackTrace();
		}

		
	
		
	} // 등록 종료

	public void search(Connection connection,BoardDTO srBoardDTO  ) { // 검색
		try {
			String sql = "select bno,btitle,bcontent,bwriter,bdate from board where bwriter=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, srBoardDTO.getBwriter());

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt("bno") + "\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bcontent") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("게시물 또는 닉네임이 존재하지 않습니다.");
			e.printStackTrace();
		}
		
	
	
	
	
	} // 검색 종료

	public void modify(Connection connection, BoardDTO moBoardDTO) { // 게시글 수정
		try {
			String sql = "UPDATE board SET btitle = ?, bcontent = ?, bdate = sysdate WHERE bno = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.setString(1, moBoardDTO.getBtitle());
	         preparedStatement.setString(2, moBoardDTO.getBcontent());
	         preparedStatement.setInt(3, moBoardDTO.getBno());

			
			int result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정되었습니다.");
			} else {
				System.out.println("수정이 실패하였습니다.");
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println(">>> 게시글 번호 오류 <<<");
			e.printStackTrace();
		}
	} // 게시글 수정 종료

	public void delete(Connection connection,BoardDTO delBoardDTO ) {
		try {
			String Sql ="delete from board where bno=?";
			PreparedStatement preparedStatement = connection.prepareStatement(Sql);		
			preparedStatement.setInt(1,delBoardDTO.getBno());
			
			
			int result = preparedStatement.executeUpdate();
					
			if(result > 0) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("삭제가  실패하였습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // 
	

}
