package com.socmour.springsecurity.demo.config.DAO;

import com.socmour.springsecurity.demo.config.Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Student> theQuery = currentSession.createQuery("from Student as s",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public Student getStudentWithId(int studentId ) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Student> theQuery = currentSession.createQuery("from Student as s where s.id =: student_id",Student.class);
        theQuery.setParameter("student_id", studentId);

        return theQuery.getSingleResult();
    }


}
