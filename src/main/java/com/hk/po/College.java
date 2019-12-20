package com.hk.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_college")
public class College {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 专业
     */
    private String profession;
    /**
     * 学院
     */
    private String faculty;
    /**
     * 班级
     */
    private String professionClass;
}
