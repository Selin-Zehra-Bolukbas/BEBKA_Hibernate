package com.selin;


import com.selin.model.Student;
import com.selin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session= HibernateUtil.getSession().openSession();
        Transaction tx= null;

        try {
            tx = session.beginTransaction();

            Student student = new Student("Selin",26);
            session.save(student);

            Student readStudent=session.get(Student.class, student.getId());
            System.out.println(readStudent);

            tx.commit();
        }catch (Exception e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }

    }
}