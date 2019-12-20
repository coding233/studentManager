package com.hk.Service;

import com.hk.Dao.StudentRepository;
import com.hk.po.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student selStudent(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Student updStudent(Long id, Student student) {
        Student s=studentRepository.findOne(id);
        if(s==null){
            System.out.println("莫得这个值");
        }
        BeanUtils.copyProperties(student,s);
        return studentRepository.save(s);
    }

    @Override
    public List<Student> listStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> listStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

}
