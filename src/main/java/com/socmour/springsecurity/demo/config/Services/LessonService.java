package com.socmour.springsecurity.demo.config.Services;

import com.socmour.springsecurity.demo.config.Entities.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLessons();

    Lesson getLessonById(int lessonId);

    List<Lesson> getAllLessonsByTeacherId(int teacherId);

}
