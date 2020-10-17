package com.sda.spring.mvc.jsp.dao;

import com.sda.spring.mvc.jsp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    // TODO: get users from db
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> query = session.createQuery("from User");
        return query.getResultList();
    }

    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
