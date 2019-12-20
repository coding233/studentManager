package com.hk.controller;

import com.hk.Service.LessonService;
import com.hk.po.Lesson;
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
public class GradeController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/grade")
    public String school(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                 Pageable pageable, Model model){
        model.addAttribute("page",lessonService.listLesson(pageable));
        return "grade";
    }

    @GetMapping("/grade/input")
    public String schoolInput(Model model){
        model.addAttribute("lesson",new Lesson());
        return "grade-input";
    }

    @PostMapping("/grade")
    public String post(@Valid Lesson lesson) {
        Lesson l = lessonService.insLesson(lesson);
        return "redirect:/index/grade";
    }

    @GetMapping("/grade/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("lesson",lessonService.selLesson(id));
        return "grade-input";
    }

    @PostMapping("/grade/{id}")
    public String editPost(@Valid Lesson lesson, @PathVariable Long id) {
        Lesson t = lessonService.updLesson(id,lesson);
        return "redirect:/index/grade";
    }

    @GetMapping("/grade/{id}/delete")
    public String delete(@PathVariable Long id){
        lessonService.delLesson(id);
        return "redirect:/index/grade";
    }
}
