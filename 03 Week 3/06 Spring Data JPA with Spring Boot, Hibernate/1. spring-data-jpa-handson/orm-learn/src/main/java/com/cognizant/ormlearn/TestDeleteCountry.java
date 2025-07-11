package com.cognizant.ormlearn;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.util.HibernateUtil;

public class TestDeleteCountry {

    public static void main(String[] args) {
        // Step 1: Open Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Step 2: Begin transaction
        Transaction tx = session.beginTransaction();

        // Step 3: Retrieve the country to delete
        Country country = session.get(Country.class, "JP"); // Delete Japan

        if (country != null) {
            // Step 4: Delete the country
            session.remove(country); // or session.delete(country);

            // Step 5: Commit transaction
            tx.commit();
            System.out.println("Deleted successfully: " + country);
        } else {
            System.out.println("Country with code JP not found.");
            tx.rollback();
        }

        // Step 6: Close session
        session.close();
    }
}
