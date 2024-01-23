package comtroller;

import dao.BankDAO;
import lombok.AllArgsConstructor;

/**
 * 책임 : 유효성검사(바디데이터), 파싱(바디데이터), 적절한 DAO
 */

@AllArgsConstructor
public class BankController {
    private BankDAO dao;

    @RequsetMapping(uri="insert")
    public void insert() {
        System.out.println("controller : insert");
        dao.insert("1234",10000);
    }

    @RequsetMapping(uri="detete")
    public void delete() {
        System.out.println("controller : delete");
        dao.deleteByNumber(1);
    }

    @RequsetMapping(uri="update")
    public void update() {
        System.out.println("controller : update");
        dao.updateByNumber(5000,1);
    }

    @RequsetMapping(uri="selectOne")
    public void selectOne() {
        System.out.println("controller : selectOne");
        dao.selectByNumber(9);
    }

    @RequsetMapping(uri="selectAll")
    public void selectAll() {
        System.out.println("controller : selectAll");
        dao.selectAll();
    }
}
