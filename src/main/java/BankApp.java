import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankApp {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();
        try {
            PreparedStatement pstmt = conn.prepareStatement("insert into account_tb(password, balance, created_at) values(?,?,now())");
            pstmt.setString(1,"12345");
            pstmt.setInt(2, 3);

            int num = pstmt.executeUpdate();
            System.out.println(num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
