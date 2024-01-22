package dao;

import model.User;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;
import java.util.List;

public class MemberDAOTest {
    @Test
    public void insert_test() {
        //given
        String name = "박찬혁";
        String phone = "010-9999-0000";
        String address = "부산 기장 정관";

        //when
        MemberDAO dao = new MemberDAO();
        int result = dao.insert(name, phone, address);

        //then
        if (result == 1) {
            System.out.println("insert 성공");

        } else if (result == 0) {
            System.out.println(name + " " + phone + " " + address + " 를 찾을 수 없습니다.");
        } else {
            System.out.println("insert 실패");
        }

    }

    @Test
    public void updateByNumber_test() {
        //given
        String name = "김주혁";
        String phone = "010-2705-2184";
        String address = "부산 금정구 구서동";
        int number = 2;

        //when
        MemberDAO dao = new MemberDAO();
        int result = dao.updateByNumber(name, phone, address, number);

        //then
        if (result == 1) {
            System.out.println("update 성공");
        } else if (result == 0) {
            System.out.println(name + " " + address + "update를 하지 못했습니다.");
        } else {
            System.out.println("update 실패");
        }

    }

    @Test
    public void deleteByNumber_test() {
        int number = 1;

        MemberDAO dao = new MemberDAO();
        int result = dao.deleteByNumber(number);

        if (result == 1) {
            System.out.println("delete 성공");

        } else if (result == 0) {
            System.out.println(number + "번호를 찾지 못했습니다.");

        } else {
            System.out.println("delete 실패");
        }
    }

    @Test
    public void selectByNumber_test() {
        int number= 2;

        MemberDAO dao = new MemberDAO();
        User user = dao.SelectByNumber(number);

        if (user == null) {
            System.out.println("조회된 값이 없습니다.");
        } else {
            System.out.println(user);
        }
    }

    @Test
    public void selectAll() {

        MemberDAO dao = new MemberDAO();
        List<User> userList = dao.SelectAll();

        System.out.println(userList);
    }
}
