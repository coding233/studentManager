package com.hk.Service;

import com.hk.po.College;
import com.hk.po.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    Student selStudent(Long id);
    Student updStudent(Long id,Student student);
    List<Student> listStudent();

    Page<Student> listStudent(Pageable pageable);
}
