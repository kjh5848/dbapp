import dao.MemberDAO;

import java.awt.*;
import java.util.Scanner;

public class MemberApp {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("추가할 이름, 폰 번호, 주소를 입력하세요.");

        String name = sc.nextLine();
        String phone = sc.nextLine();
        String address = sc.nextLine();

        MemberDAO dao = new MemberDAO();
        int result = dao.insert(name, phone, address);

        if (result == 1) {
            System.out.println("성공");

        } else {
            System.out.println("실패");
        }
    }




}
