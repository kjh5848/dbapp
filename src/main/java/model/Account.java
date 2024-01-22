package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * DB에 Select 한 데이터를 담기 위한 오브젝트
 */
@Getter
@AllArgsConstructor
@ToString

public class Account {
    private int munber;
    private String password;
    private int balance;

    //java.sql의 Timestamp
    //카멜표기법 사용하기
    private Timestamp createdAt;


}
