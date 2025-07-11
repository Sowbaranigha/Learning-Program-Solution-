package com.cognizant.ormlearn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.util.HibernateUtil;

public class TestCountry {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Country> query = session.createQuery("from Country", Country.class);
        List<Country> countryList = query.getResultList();
        for (Country country : countryList) {
            System.out.println(country);
        }
        session.close();
    }
}
