import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcEx13 {
    public static void main(String[] args) throws IOException {
        // 데이터베이스 연결
        String url = "jdbc:mariadb://localhost:3306/project";
        String userName = "project";
        String password = "1234";
        Connection conn = null;
        BufferedReader br = null;
        PreparedStatement pstmt = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(url, userName, password);

            // CSV 파일 읽기
            br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv", StandardCharsets.UTF_8));

            // PreparedStatement 객체 생성
            pstmt = conn.prepareStatement(
                    "INSERT INTO zipcode (zipcode, sido, gugun, dong, bunji) VALUES (?, ?, ?, ?, ?)");

            // CSV 파일 구문 분석
            String[] header = null;
            String[] record;
            boolean firstLine = true;

            while ((record = br.readLine().split(",")) != null) {
                if (firstLine) {
                    header = record;
                    firstLine = false;
                    continue;
                }

                // 각 레코드에 대해 PreparedStatement 에 파라미터 바인딩
                pstmt.setString(1, record[0]);
                pstmt.setString(2, record[1]);
                pstmt.setString(3, record[2]);
                pstmt.setString(4, record[3]);
                pstmt.setString(5, record[4]);

                // PreparedStatement 실행
                pstmt.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (br != null) {
                    br.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}