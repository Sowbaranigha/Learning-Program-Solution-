package com.example.countryquery.dao;

import com.example.countryquery.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CountryDao {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void delete(String code) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            Country country = session.get(Country.class, code);
            if (country != null) {
                transaction = session.beginTransaction();
                session.delete(country);
                transaction.commit();
                System.out.println("✔ Country deleted: " + code);
            } else {
                System.out.println("⚠ Country with code '" + code + "' not found.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
