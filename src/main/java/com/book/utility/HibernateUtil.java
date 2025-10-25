package com.book.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            factory = cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getHibernateSession() {
        return factory.openSession();
    }
}

