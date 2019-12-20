package com.hk.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_lesson")
public class Lesson {

    @Id
    @GeneratedValue
    private Long id;

    private String cname;
    private int grade;

//    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH},optional=false)//可选属性optional=false,表示author不能为空。删除文章，不影响用户
//    @JoinColumn(name="student_id")//设置在article表中的关联字段(外键)
//    private Student student;
}
