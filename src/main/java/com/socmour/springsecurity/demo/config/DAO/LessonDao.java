package com.socmour.springsecurity.demo.config.DAO;

import com.socmour.springsecurity.demo.config.Entities.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getAllLessons();

    Lesson getLessonById(int lessonId);

    List<Lesson> getAllLessonsByTeacherId(int teacherId);
}
