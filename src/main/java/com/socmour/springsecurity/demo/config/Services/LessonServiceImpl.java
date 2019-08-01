package com.socmour.springsecurity.demo.config.Services;

import com.socmour.springsecurity.demo.config.DAO.LessonDao;
import com.socmour.springsecurity.demo.config.Entities.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonDao lessonDao;


    @Override
    @Transactional
    public List<Lesson> getAllLessons() {
        return lessonDao.getAllLessons();
    }

    @Override
    @Transactional
    public Lesson getLessonById(int lessonId) {
        return null;
    }

    @Override
    @Transactional
    public List<Lesson> getAllLessonsByTeacherId(int teacherId) {
        return null;
    }
}
