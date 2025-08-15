package com.selin.dao.impl;

import com.selin.dao.UserDao;
import com.selin.model.User;
import com.selin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao {
    @Override
    public void create(User user) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSession().openSession()) {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            System.out.println("Kullanıcı başarıyla eklendi..");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Kullanıcı kaydı yapılamadı!!");
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(Long id) {
        Transaction tx = null;
        User user = null;

        try (Session session = HibernateUtil.getSession().openSession()) {
            tx = session.beginTransaction();
            return session.get(User.class, id);

        } catch (Exception e) {
            System.err.println("Kayıt bulunamadı!!");
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            System.out.println("Kullanıcı güncellendi: " + user);
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.err.println("Kullanıcı güncellenemedi!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Long id) {
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSession().openSession()) {
            transaction = session.beginTransaction();
            session.delete(session.get(User.class, id));
            transaction.commit();
            System.out.println("🗑 Kullanıcı silindi: " + user);
        } catch (Exception e) {
            System.err.println("Kullanıcı silinemedi!!");
            e.printStackTrace();
        }
    }

}
