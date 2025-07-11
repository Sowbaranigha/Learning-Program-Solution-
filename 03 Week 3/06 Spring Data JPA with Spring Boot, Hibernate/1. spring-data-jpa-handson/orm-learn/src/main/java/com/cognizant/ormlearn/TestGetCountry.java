package com.cognizant.ormlearn;

import org.hibernate.Session;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.util.HibernateUtil;

public class TestGetCountry {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Get the country by primary key
        Country country = session.get(Country.class, "IN");

        // Print result
        System.out.println(country);

        session.close();
    }
}
