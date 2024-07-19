package hairshop1.service;

import java.sql.Connection;
import java.util.Scanner;

import hairshop1.dao.DesignerDAO;
import hairshop1.dto.DesignerDTO;

public class DesignerService {
	// 디자이너 메뉴
	public void designerMenu(Scanner scanner, Connection connection) { // 디자이너 본체 
		boolean run = true;
		while(run) {
		System.out.println("=====================디자이너===================");
		System.out.println("1.일정관리 | 2.전체예약 | 3.예약검색 | 4.리뷰 | 5.종료");
		System.out.print(">>>");
		int designerSel = scanner.nextInt();
		switch(designerSel) {
		case 1:
			schedule(connection, scanner);
			break;
		case 2:
			viewReservation(connection);
			break;
		case 3:
			search(connection, scanner);
			break;
		case 4:
			viewReview(connection);
			break;
		case 5:
			System.out.println("디자이너 메뉴를 종료합니다.");
			run = false;
			break;
			default:
				System.out.println(">>> 입력오류 <<<");
		}
		}
	} // 디자이너 본체 종료
	
	public void schedule(Connection connection, Scanner scanner) { // 일정 종료
		System.out.println("----------일정판---------");
		search(connection, scanner);
		schedule2(connection);
		System.out.println("1.예약불가 | 2.예약풀기 | 3.종료");
		System.out.print(">>>");
		int sc = scanner.nextInt();
		switch(sc) {
		case 1:
		System.out.println("예약을 막을 시간(hh:mm) : ");
		String sdTime = scanner.next();
		DesignerDTO scheduleDTO = new DesignerDTO();
		scheduleDTO.setTtime(sdTime);
		DesignerDAO scheduleDAO = new DesignerDAO();
		scheduleDAO.schedule(connection, scheduleDTO);
		break;
		case 2:
			System.out.println("예약을 풀 시간(hh:mm) : ");
			String sdTimes = scanner.next();
			DesignerDTO schedule3DTO = new DesignerDTO();
			schedule3DTO.setTtime(sdTimes);
			DesignerDAO schedule3DAO = new DesignerDAO();
			schedule3DAO.schedule3(connection, schedule3DTO);
			break;
		case 3:
			System.out.println("일정판을 종료합니다.");
			break;
		default:
			System.out.println(">>> 입력 오류 <<<");
		}
	} // 일정관리 종료
	
	public void schedule2(Connection connection) { // 예약가능 시간
		System.out.println("----------예약 가능 시간------------");
		DesignerDAO schedule2 = new DesignerDAO();
		schedule2.schedule2(connection);
	}
	
	
	
	
	public void search(Connection connection, Scanner scanner) {
		System.out.println("날짜를 입력하세요.(yyyy/mm/dd)");
		// yyyy/mm/dd 아니라면 검색이 안되서 수정 요망
		System.out.print(">>>");
		String sh = scanner.next();
		DesignerDTO searchDTO = new DesignerDTO();
		searchDTO.setBdate(sh);
		DesignerDAO searchDAO = new DesignerDAO();
		searchDAO.search(connection, searchDTO);
	}

	
	public void viewReservation(Connection connection) { // 예약확인
		System.out.println("---------예약확인---------");
		DesignerDAO reservationDAO = new DesignerDAO();
		reservationDAO.viewReservation(connection);
	} // 예약확인 종료
	
	public void viewReview(Connection connection) { // 리뷰확인
		System.out.println("-------- 리뷰확인 ---------");
		DesignerDAO viewDAO = new DesignerDAO();
		viewDAO.viewReview(connection);
	} // 리뷰확인 종료
	
	
	
}
