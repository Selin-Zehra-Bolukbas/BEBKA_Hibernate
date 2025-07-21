package com.selin;


import com.selin.model.Student;
import com.selin.model.User;
import com.selin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session= HibernateUtil.getSession().openSession();
        Transaction tx= null;

        try {
            tx = session.beginTransaction();

           // Student student = new Student("Selin",26);
           // session.save(student);

            //Student readStudent=session.get(Student.class, student.getId());
           // System.out.println(readStudent);

            // create
           /* User user=new User();
            user.setEmail("selin@gmail.com");
            user.setName("Selin");

            session.save(user);*/


            // read
            User readUser=session.get(User.class, 2);
            System.out.println(readUser);
            List<User> users =  session.createQuery("from User", User.class).list();

            for (User user : users) {
                System.out.println(user);
            }

            // update
            readUser.setName("Sude");
            readUser.setEmail("sude@gmail.com");
            session.update(readUser);

            // delete
            session.delete(readUser);

            tx.commit();
        }catch (Exception e) {
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
}