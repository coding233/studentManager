package com.hk.Service;

import com.hk.po.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LessonService {

    Lesson insLesson(Lesson lesson);
    Lesson selLesson(Long id);
    Lesson updLesson(Long id,Lesson lesson);
    void delLesson(Long id);
    //分页查询
    Page<Lesson> listLesson(Pageable pageable);
}
