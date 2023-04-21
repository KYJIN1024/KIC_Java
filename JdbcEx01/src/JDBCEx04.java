import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt  = null;
		
			try {
				//처리 로직
				Class.forName("org.mariadb.jdbc.Driver");
				System.out.println("드라이버 로딩 완료");

				conn = DriverManager.getConnection(url, user, password);
				System.out.println("연결성공");
				
				stmt = conn.createStatement();
				
				String deptno = "20";
				String dname = "개발";
				String loc = "대전";
				
				//String sql = "insert into dept2 values (" + deptno + ", '"+ dname + "', '"+ loc + "' )";
				String sql = String.format("insert into dept2 values (%s,'%s','%s' )", deptno, dname, loc);
				int result = stmt.executeUpdate( sql );
				
				System.out.println("실행결과 :" + result);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("[에러]"+ e.getMessage() );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("[에러]"+ e.getMessage() );
			}finally {
				if(stmt != null ) try { stmt.close();} catch( SQLException e ) {} ;
				if(conn != null ) try { conn.close();} catch( SQLException e ) {} ;
		}
				
	}

}
