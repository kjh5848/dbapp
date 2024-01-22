package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getInstance() {

        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://192.168.0.35:3306/cosdb";

        // 프로토콜이 적용된 소켓
        try {

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("db connection success");
            return conn;

        } catch (Exception e) {
            // 원인파악을 하기 위해서 printStackTrace를 사용하자.
            e.printStackTrace();
        }
        // 리턴을 잊지 말자.
        return null;
    }
}
