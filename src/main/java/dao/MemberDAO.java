package dao;

import db.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public int insert(String name, String phone, String address) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "insert into User_tb(name, phone, address) values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, address);

            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return -1;
    }

    public int updateByNumber(String name,String phone, String address, int number) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "update user_tb set name = ?, phone = ?, address =? where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, address);
            pstmt.setInt(4, number);
            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteByNumber(int number) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "delete from user_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public User SelectByNumber(int number) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "select * from user_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,number);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(
                        rs.getInt("number"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<User> SelectAll() {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "select * from user_tb order by number desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("number"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("address")
                );
                userList.add(user);
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


