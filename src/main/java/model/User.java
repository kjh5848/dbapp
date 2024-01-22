package model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@AllArgsConstructor

public class User {
    private int number;
    private String name;
    private String phone;
    private String address;

}
