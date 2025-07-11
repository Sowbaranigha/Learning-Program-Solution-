package com.cognizant.ormlearn;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.util.HibernateUtil;

public class TestAddCountry {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Country country = new Country("JP", "Japan"); // 👈 insert country

        session.persist(country); // or session.save(country)
        tx.commit();
        session.close();

        System.out.println("Country inserted successfully: " + country);
    }
}
