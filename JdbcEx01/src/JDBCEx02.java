import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// Connector 제공업체에서 알수 있음
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 완료");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러]"+ e.getMessage() );
		}
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("[에러]"+ e.getMessage() );
		} finally {
			if(conn != null ) try { conn.close();} catch( SQLException e ) {} ;
		}
		
	}

}
