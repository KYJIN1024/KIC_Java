import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
			try {
				//처리 로직
				Class.forName("org.mariadb.jdbc.Driver");
				
				conn = DriverManager.getConnection(url, user, password);
				
				String sql = "delete from where deptno=?";
				pstmt = conn.prepareStatement( sql );
				
				pstmt.setString( 1, "10");

				
				int result = pstmt.executeUpdate();
				System.out.println("실행완료 :"+ result);
				
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("[에러]"+ e.getMessage() );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("[에러]"+ e.getMessage() );
			}finally {
				if(pstmt != null ) try { pstmt.close();} catch( SQLException e ) {} ;
				if(conn != null ) try { conn.close();} catch( SQLException e ) {} ;
		}
				
	}

}