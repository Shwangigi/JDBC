package hairshop1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hairshop1.dto.DesignerDTO;

public class DesignerDAO {

	public void schedule(Connection connection, DesignerDTO scheduleDTO) { // 일정관리
		try {
			String updateSql ="UPDATE timetable SET status = '예약 불가' WHERE ttime = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, scheduleDTO.getTtime());
			
			int result = preparedStatement.executeUpdate();
					
			if(result > 0) {
				
				System.out.println("예약이 막혔습니다.");
			}else {
				System.out.println("예약이 막히지 않았습니다.");
			}
		} catch (SQLException e) {
			System.out.println("예약을 막는 중 오류 발생하였습니다.");
			e.printStackTrace();
		}
		
	} // 일정관리 종료
	
	
	public void schedule3(Connection connection, DesignerDTO schedule3DTO) { // 일정관리
		try {
			String updateSql ="UPDATE timetable SET status = '예약 가능' WHERE ttime = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, schedule3DTO.getTtime());
			
			int result = preparedStatement.executeUpdate();
					
			if(result > 0) {
				
				System.out.println("예약이 풀렸습니다.");
			}else {
				System.out.println("예약이 풀리지 않았습니다.");
			}
		} catch (SQLException e) {
			System.out.println("예약을 푸는 중 오류 발생하였습니다.");
			e.printStackTrace();
		}
		
	} // 일정관리 종료
	
	public void search(Connection connection, DesignerDTO searchDTO) { // 예약검색
		
		try {
			String searhCheck = "select bdate,busernum, btime, bcut from book where bdate =?";
			PreparedStatement preparedStatement = connection.prepareStatement(searhCheck);
			preparedStatement.setString(1, searchDTO.getBdate());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			boolean search = false; // 예약 있는지
			while (resultSet.next()) {
				search = true;
				String bdate = resultSet.getString("bdate");
				String busernum = resultSet.getString("busernum");
			    String btime = resultSet.getString("btime");		          
			    String bcut = resultSet.getString("bcut");
			    
			    System.out.println("------------------------");
			    System.out.println("날짜 : " + bdate);	
			    System.out.println("예약자 번호 : " + busernum);
			    System.out.println("시간 : " + btime);	
			    System.out.println("커트 : " + bcut);
			    System.out.println("------------------------");
				
				} // while문 종료
			
			if(!search) {
				System.out.println("해당날짜에 예약이 없습니다.");
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
		    System.out.println("예약확인 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
	} // 예약검색
	
	
	public void viewReservation(Connection connection) { // 예약확인
		try {
			String reservatuonSql = "select bdate,btime,bcut from book order by bdate asc";
			PreparedStatement preparedStatement = connection.prepareStatement(reservatuonSql); // 3단계
			ResultSet resultSet = preparedStatement.executeQuery(); // 4단계

			while(resultSet.next()) { 		        
		          String bdate = resultSet.getString("bdate");
		          String btime = resultSet.getString("btime");		          
		          String bcut = resultSet.getString("bcut");
		          
		          System.out.println("날짜 : " + bdate);		          		         		            
		          System.out.println("시간 : " + btime);	
		          System.out.println("커트 : " + bcut);
		          System.out.println("------------------------");
			}
			// 5단계
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("리뷰가 확인 중 오류가 발생했습니다.");
			e.printStackTrace();
		} 
	} // 예약확인 종료
	
	public void viewReview(Connection connection) { // 리뷰확인
		try {
			String sql = "select rwriter,rcontents,rdate from review order by rno desc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql); // 3단계
			ResultSet resultSet = preparedStatement.executeQuery(); // 4단계

			while(resultSet.next()) { 		        
		          String rwriter = resultSet.getString("rwriter");
		          String rcontents = resultSet.getString("rcontents");		          
		          Date rdate = resultSet.getDate("rdate");
		          
		          System.out.println("작성자: " + rwriter);		          		         		            
		          System.out.println("내용: " + rcontents);	
		          System.out.println("날짜: " + rdate);
		          System.out.println("-------------------------------");
			}
			// 5단계
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("리뷰가 확인 중 오류가 발생했습니다.");
			e.printStackTrace();
		} 
	} // 리뷰확인 종료

    public void schedule2(Connection connection ) { // 일정확인
    	try {
			String sql = "select tno,ttime ,status from timetable where status='예약 가능' order by tno asc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql); // 3단계
			ResultSet resultSet = preparedStatement.executeQuery(); // 4단계
			
			while(resultSet.next()) { 	
			      String ttime = resultSet.getString("ttime");
			      String status = resultSet.getString("status") ;
			      
			      System.out.println(ttime +" : "+ status);		          		         		            
			      System.out.println("---------------");
   }
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("예약 가능시간 호출 중 오류 발생");
			e.printStackTrace();
		}
    }


}
