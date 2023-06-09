import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteZipcodeEx2 {

    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/project";
        String user = "project";
        String password = "1234";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String dongName = "대치";

            String sql = "SELECT * FROM zipcode WHERE dong LIKE '%" + dongName + "%';";

            rs = stmt.executeQuery(sql);

            System.out.println("우편번호\t시도\t구군\t동\t리\t번지");
            while (rs.next()) {
                System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n",
                        rs.getString("zipcode"), rs.getString("sido"),
                        rs.getString("gugun"), rs.getString("dong"),
                        rs.getString("ri"), rs.getString("bunji"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("[에러] " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("[에러] " + e.getMessage());
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}
