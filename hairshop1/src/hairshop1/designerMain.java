package hairshop1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



import hairshop1.service.DesignerService;

 public class designerMain {
	public static Scanner scanner = new Scanner(System.in);
	public static Connection connection = null;
//	public static MemberDTO LoginMember = null; // 로그인 후 객체
	// 생성자
	public designerMain() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.120:1521:orcl", "ann", "8422"); // 2단계
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 명 또는 ojdbc6.를 확인해주세요.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("url, id,pw나 쿼리문이 잘못됨");
			e.printStackTrace();
			System.exit(0); // 프로세스 강제 종료
		}
	} // 1_2단계 처리용
	public static void main(String[] args) {
		designerMain designMain = new designerMain();
		
		DesignerService designerService = new DesignerService();
		designerService.designerMenu(scanner,connection);
	}

}
 