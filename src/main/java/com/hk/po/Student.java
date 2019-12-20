package com.hk.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by limi on 2017/10/14.
 */
@Entity
@Data
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
    private String sex;
    private String birthday;
    private String address;
}
