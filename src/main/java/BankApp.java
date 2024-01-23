import comtroller.BankController;
import dao.BankDAO;
import db.DBConnection;
import lombok.Getter;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class BankApp {
    public static void main(String[] args) {
        String url = "selectAll";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con);
        dis.route(url);
    }
}
