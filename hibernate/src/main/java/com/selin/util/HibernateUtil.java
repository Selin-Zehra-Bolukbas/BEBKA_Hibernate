package com.selin.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



    public class HibernateUtil {
        private static final SessionFactory sessionFactory;

        static {
            try {
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }finally {

            }
        }
        public static SessionFactory getSession() {
            return sessionFactory;
        }
    }
