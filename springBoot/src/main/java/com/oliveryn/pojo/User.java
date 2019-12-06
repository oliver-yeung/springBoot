package com.oliveryn.pojo;



import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date create;
    private Date update;
    private String note;

}
