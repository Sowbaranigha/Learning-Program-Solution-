package com.cognizant.ormlearn;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.util.HibernateUtil;

public class TestUpdateCountry {

    public static void main(String[] args) {
        // Step 1: Open session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Step 2: Begin transaction
        Transaction tx = session.beginTransaction();

        // Step 3: Get existing country
        Country country = session.get(Country.class, "JP"); // Update Japan

        if (country != null) {
            // Step 4: Modify the country name
            country.setName("Nippon");

            // Step 5: No need to explicitly call update — Hibernate tracks it
            tx.commit();
            System.out.println("Updated successfully: " + country);
        } else {
            System.out.println("Country with code JP not found.");
            tx.rollback();
        }

        // Step 6: Close session
        session.close();
    }
}
