package com.hk.controller;

import com.hk.Service.SchoolService;
import com.hk.po.College;
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
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/school")
    public String school(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                     Pageable pageable, Model model){
        model.addAttribute("page",schoolService.listCollege(pageable));
        return "school";
    }

    @GetMapping("/school/input")
    public String schoolInput(Model model){
        model.addAttribute("college",new College());
        return "school-input";
    }

    @PostMapping("/school")
    public String post(@Valid College college) {
//        College college1 = schoolService.selCollege(college.getId());
//        if(college1!=null){
//            return "school-input";
//        }
        College t = schoolService.insCollege(college);
        return "redirect:/index/school";
    }

    @GetMapping("/school/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("college",schoolService.selCollege(id));
        return "school-input";
    }

    @PostMapping("/school/{id}")
    public String editPost(@Valid College college,@PathVariable Long id) {
//        College college1 = schoolService.selCollege(college.getId());
//        if (college1 != null) {
//            return "/school";
//        }
        College t = schoolService.updCollege(id,college);
        return "redirect:/index/school";
    }

    @GetMapping("/school/{id}/delete")
    public String delete(@PathVariable Long id){
        schoolService.delCollege(id);
        return "redirect:/index/school";
    }
}
