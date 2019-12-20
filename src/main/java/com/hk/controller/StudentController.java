package com.hk.controller;

import com.hk.Service.StudentService;
import com.hk.po.College;
import com.hk.po.Student;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/index")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String student(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                      Pageable pageable, Model model){
        model.addAttribute("list",studentService.listStudent());
        return "student";
    }

    @GetMapping("/student/input")
    public String studentInput(Model model){
        model.addAttribute("student",new Student());
        return "student-input";
    }

    @PostMapping("/student/{id}")
    public String editPost(@Valid Student student, @PathVariable Long id,Model model) {
        model.addAttribute("student",studentService.selStudent(id));
        Student s = studentService.updStudent(id,student);
        return "redirect:/index/student";
    }
}
