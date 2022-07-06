/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.datit.dao;

import com.datit.hibernate.HibernateUtils;
import com.datit.log.WriteLog;
import com.datit.model.Budget;
import com.datit.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BudgetDAO {

    private final String SELECT_ALL = "From Budget bg "
            + "Where bg.User = :User "
            + "AND MONTH(bg.createDate) = :month "
            + "AND YEAR(bg.createDate) = :year";

    public List selectBudgetAll(User us, int month, int year) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        List<Budget> budgets = null;
        try {
            budgets = session.createQuery(SELECT_ALL)
                    .setParameter("User", us)
                    .setParameter("month", month)
                    .setParameter("year", year)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            WriteLog.writeLog(e, "BudgetApp");
        } finally {
            session.close();
        }
        return budgets;
    }

    public Budget selectBudgetById(long id) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Budget budget = null;
        try {
            budget = session.get(Budget.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            WriteLog.writeLog(e, "BudgetApp");

        } finally {
            session.close();
        }
        return budget;
    }

    public boolean insertBudget(Budget bg, User us) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            bg.setUser(us);
            session.save(bg);
            tx.commit();
            success = true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            WriteLog.writeLog(e, "BudgetApp");

        } finally {
            session.close();
        }
        return success;
    }

    public boolean updateBudget(Budget bg) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        boolean success = false;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(bg);
            tx.commit();
            success = true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            WriteLog.writeLog(e, "BudgetApp");

        } finally {
            session.close();
        }
        return success;
    }

    public boolean deleteBudget(long id) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Budget bg = session.get(Budget.class, id);
        boolean success = false;
        if (bg != null) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();

                session.delete(bg);
                tx.commit();
                success = true;
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
                WriteLog.writeLog(e, "BudgetApp");

            } finally {
                session.close();
            }
        }
        return success;
    }
}
