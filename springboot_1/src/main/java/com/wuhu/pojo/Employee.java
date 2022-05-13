package com.wuhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer sex;
    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer sex, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        this.birth = new Date();
    }
}
