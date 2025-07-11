package com.example.countryquery.repository;

import com.example.countryquery.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findByNameContaining(String keyword);

    List<Country> findByNameContainingOrderByNameAsc(String keyword);

    List<Country> findByNameStartingWith(String prefix);

    // ✅ Add this for Hands-on 3
    Optional<Country> findByCode(String code);
}
