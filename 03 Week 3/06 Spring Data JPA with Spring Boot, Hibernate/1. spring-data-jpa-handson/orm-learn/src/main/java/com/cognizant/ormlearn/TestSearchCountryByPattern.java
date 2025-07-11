package com.cognizant.ormlearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.util.HibernateUtil;

public class TestSearchCountryByPattern {

    public static void main(String[] args) {
        // Step 1: Open Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Step 2: Create HQL query with LIKE pattern
        String pattern = "%an%";  // e.g., India, Japan, Canada, etc.
        Query<Country> query = session.createQuery("from Country where name like :pattern", Country.class);
        query.setParameter("pattern", pattern);

        // Step 3: Execute query
        List<Country> countryList = query.getResultList();

        // Step 4: Display results
        System.out.println("Countries with name containing 'an':");
        for (Country country : countryList) {
            System.out.println(country);
        }

        // Step 5: Close session
        session.close();
    }
}
