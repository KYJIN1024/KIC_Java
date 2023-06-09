import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
				//처리 로직
				Class.forName("org.mariadb.jdbc.Driver");
				
				conn = DriverManager.getConnection(url, user, password);
				
				String sql = "select empno, ename, sal, job from emp where ename like ?";
				pstmt = conn.prepareStatement( sql );
				
				pstmt.setString( 1, "s%" );

				
				rs = pstmt.executeQuery();
				while( rs.next()) {
					System.out.printf( "%s %s %s %s%n",
							rs.getString("empno"), rs.getString("ename"),
							rs.getString("sal"), rs.getString("job") );
				}
					
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("[에러]"+ e.getMessage() );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("[에러]"+ e.getMessage() );
			}finally {
				if(rs != null ) try { rs.close();} catch( SQLException e ) {} ;
				if(pstmt != null ) try { pstmt.close();} catch( SQLException e ) {} ;
				if(conn != null ) try { conn.close();} catch( SQLException e ) {} ;
		}
				
	}

}