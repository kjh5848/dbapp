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
        Scanner sc = new Scanner(System.in);

        // http://bank.com/account GET (바디x)
        // http://bank.com/account/10 GET (10번 account 요청)
        // http://bank.com/account POST (바디O)
        // http://bank.com/account/1 DELETE (바디x)
        // http://bank.com/account/1 PUT (바디O)

        System.out.print("메서드를 입력하세요: ");
        String method = sc.nextLine();
        System.out.print("식별자를 입력하세요(/account/번호): ");
        String action = sc.nextLine();

        String body = "";

        BankDAO dao = new BankDAO();

        if (method.equals("GET")) {
            if (action.equals("/account")) {
                List<Account> accountList = dao.selectAll();
                System.out.println(accountList);
            } else {
                String accountKey = action.split("/")[2];
                int id = Integer.parseInt(accountKey);
                Account account = dao.selectByNumber(id);
                System.out.println(account);
            }

        } else if (method.equals("POST")) {
            System.out.println("body 데이터를 입력하세요");
            body = sc.nextLine();

            //password=1234&balance=1000

            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance = Integer.parseInt(st1[1].split("=")[1]);

            if (action.equals("/account")) {
                dao.insert(password, balance);
            }

        } else if (method.equals("DELETE")) {
            // "/account"만 있는 경우 에러 메시지 출력
            if (action.equals("/account/")) {
                System.out.println("계정 ID가 URL에 포함되어야 합니다.");
            } else {
                String accountKey = action.split("/")[2];

                int id = Integer.parseInt(accountKey);

                int result = dao.deleteByNumber(id);
                System.out.println(result + "개의 계정이 삭제되었습니다.");
            }

        } else if (method.equals("PUT")) {
            System.out.println("금액을 입력하세요: ");
            int balance = sc.nextInt();

            if (action.equals("/account/")) {
                System.out.println("계정 ID가 URL에 포함되어야 합니다.");
            } else {
                String accountKey = action.split("/")[2];

                int number = Integer.parseInt(accountKey);

                dao.updateByNumber(balance,number);
                System.out.println(number+ "번의"  + "금액이 " + balance+"원으로 변경되었습니다.");
            }
        }
    }
}
