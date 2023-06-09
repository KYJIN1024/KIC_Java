import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteZipcodeEx01 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String url = "jdbc:mariadb://localhost:3306/project";
			String user = "root";
			String password = "123456";
			
			Connection conn = null;
			Statement stmt = null;
			
			BufferedReader br = null;
			
				try {
					//처리 로직
					Class.forName("org.mariadb.jdbc.Driver");
					
					conn = DriverManager.getConnection(url, user, password);
					
					stmt = conn.createStatement();
					
					br = new BufferedReader( new FileReader("./zipcode_seoul_utf8_type2.csv"));
					
					String str ="";
					int count = 0;
					
					while( (str = br.readLine() ) != null   ){
						String[] arrZipcode = str.split( ",");
							
						String sql = String.format( "insert into zipcode value('%s','%s','%s','%s','%s','%s','%s')",
									arrZipcode[0], arrZipcode[1], arrZipcode[2],
									arrZipcode[3], arrZipcode[4], arrZipcode[5], arrZipcode[6] );
							
						stmt.executeUpdate(sql);
						count++;							
						}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("[에러]"+ e.getMessage() );	
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("[에러]"+ e.getMessage() );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("[에러]"+ e.getMessage() );
		
				}finally {
					if(br != null ) try { br.close();} catch( IOException e ) {} ;
					
					
					if(stmt != null ) try { stmt.close();} catch( SQLException e ) {} ;
					if(conn != null ) try { conn.close();} catch( SQLException e ) {} ;
			}
					
		}

	}