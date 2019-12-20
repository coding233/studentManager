package com.hk.Dao;

import com.hk.po.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long>{
}
