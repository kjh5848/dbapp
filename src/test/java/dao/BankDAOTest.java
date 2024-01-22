package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;


public class BankDAOTest {

    @Test
    public void selectAll_test() {
        //given이 필요없다.

        //when
        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList+"\n");
        //then
    }


    @Test
    public void selectByNumber_test() {
        int number = 6;

        BankDAO dao = new BankDAO();
        Account account = dao.selectByNumber(number);

        if (account == null) {
            System.out.println(number + "로 조회된 값이 없습니다.");
        } else {
            System.out.println(account);
//            System.out.print(account.getMunber()+", ");
//            System.out.print(account.getPassword()+", ");
//            System.out.print(account.getBalance()+", ");
//            System.out.print(account.getCreatedAt());
        }
    }

    @Test
    public void deleteByNumber_test() {
        //given
        int number = 1;

        //when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNumber(number);

        //then
        if (result == 1) {
            System.out.println("삭제성공");
        } else if (result == 0) {
            System.out.println(number + "번호를 찾을 수 없습니다.");
        } else {
            System.out.println("삭제실패");
        }
    }

    @Test
    public void insert_test() {
        //given
        String password = "넌 0이 어떻게 나와?";
        int balance = 200000;

        //when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password,balance);
        //then
        if (result == 1) {
            System.out.println("insert 성공");
        } else if (result == 0) {
            System.out.println(password + balance + "가 올바르게 입력되지 않았습니다.");
        } else {
            System.out.println("insert 실패");
        }
    }

    @Test
    public void updateByNumber_test() {
        //given
        int balance = 500000;
        int number = 1;

        //when
        BankDAO dao = new BankDAO();
        int result = dao.updateByNumber(balance, number);

        //then
        if (result == 1) {
            System.out.println("update 성공");
        } else if (result == 0) {
            System.out.println(number + "번호에 "  + balance + "원이 올바르게 입력되지 않았습니다.");
        } else {
            System.out.println("update 실패");
        }
    }


}
