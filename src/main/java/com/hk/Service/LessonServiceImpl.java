package com.hk.Service;

import com.hk.Dao.LessonRepository;
import com.hk.po.College;
import com.hk.po.Lesson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService{

    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public Lesson insLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson selLesson(Long id) {
        return lessonRepository.findOne(id);
    }

    @Override
    public Lesson updLesson(Long id, Lesson lesson) {
        Lesson lesson1=lessonRepository.findOne(id);
        if(lesson1==null){
            System.out.println("莫得这个值");
        }
        BeanUtils.copyProperties(lesson,lesson1);
        return lessonRepository.save(lesson1);
    }

    @Override
    public void delLesson(Long id) {
        lessonRepository.delete(id);
    }

    @Override
    public Page<Lesson> listLesson(Pageable pageable) {
        return lessonRepository.findAll(pageable);
    }
}
