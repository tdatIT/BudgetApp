/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datit.hibernate;

import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        JOptionPane.showConfirmDialog(null,"Connect to Database fail !","Notification",
                    JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
           
        }
        return sessionFactory;
    }
}
