package com.socmour.springsecurity.demo.config.DAO;

import com.socmour.springsecurity.demo.config.Entities.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonDaoImpl implements LessonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Lesson> getAllLessons() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Lesson> theQuery = currentSession.createQuery("from Lesson as l", Lesson.class);
        return theQuery.getResultList();
    }

    @Override
    public Lesson getLessonById(int lessonId) {
        return null;
    }

    @Override
    public List<Lesson> getAllLessonsByTeacherId(int teacherId) {
        return null;
    }
}
