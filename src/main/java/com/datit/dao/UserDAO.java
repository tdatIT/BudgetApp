/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datit.dao;

import com.datit.hibernate.HibernateUtils;
import com.datit.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAO {

    private static String SELECT = "FROM User us WHERE us.id= :id";
    private static String SELECT_ALL = "From User";
    private static String VALIDATE = "From User us "
            + "Where us.username = :username And us.password = :password";

    public User selectUser(int id) {
        User us = null;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        try {

            us = session.createQuery(SELECT, User.class).setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            

        } finally {
            session.close();
        }
        return us;
    }

    public List selectAllUser() {
        List<User> users = null;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        try {
            users = session.createQuery(SELECT_ALL).list();
        } catch (Exception e) {
            e.printStackTrace();
            

        } finally {
            session.close();
        }
        return users;
    }

    public boolean insertUser(User us) {
        boolean success = false;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(us);
            tx.commit();
            success = true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            

        } finally {
            session.close();
        }
        return success;
    }

    public User validateAccount(String username, String pass) {

        User us = null;
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        try {
            us = session.createQuery(VALIDATE, User.class)
                    .setParameter("username", username)
                    .setParameter("password", pass).uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            

        } finally {
            session.close();
        }
        return us;
    }

}
