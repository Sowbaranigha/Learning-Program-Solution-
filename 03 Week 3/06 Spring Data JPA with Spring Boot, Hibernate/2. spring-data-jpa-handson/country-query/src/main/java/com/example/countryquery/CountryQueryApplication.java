package com.example.countryquery;

import com.example.countryquery.model.Country;
import com.example.countryquery.model.Stock;
import com.example.countryquery.repository.CountryRepository;
import com.example.countryquery.repository.StockRepository;
import com.example.countryquery.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class CountryQueryApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private CountryService countryService; // ✅ NEW: Injected Service

    public static void main(String[] args) {
        SpringApplication.run(CountryQueryApplication.class, args);
    }

    @Override
    public void run(String... args) {
        runCountryQueries();   // Hands-on 1
        runCountryByCode();    // Hands-on 3
        runCountryUpdate();    // ✅ Hands-on 5
        runStockQueries();     // Hands-on 2
    }

    private void runCountryQueries() {
        System.out.println("🔍 Countries containing 'ou':");
        List<Country> list1 = countryRepository.findByNameContaining("ou");
        list1.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));

        System.out.println("\n🔍 Countries containing 'ou' (sorted):");
        List<Country> list2 = countryRepository.findByNameContainingOrderByNameAsc("ou");
        list2.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));

        System.out.println("\n🔍 Countries starting with 'Z':");
        List<Country> list3 = countryRepository.findByNameStartingWith("Z");
        list3.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
    }

    private void runCountryByCode() {
        System.out.println("\n🔎 Country with Code 'IN':");
        countryRepository.findByCode("IN")
                .ifPresentOrElse(
                        country -> System.out.println(country.getCode() + " - " + country.getName()),
                        () -> System.out.println("Country not found")
                );
    }

    // ✅ Hands-on 5
    private void runCountryUpdate() {
        System.out.println("\n🔧 Updating Country name for 'IN' to 'Bharat'");
        countryService.updateCountryName("IN", "Bharat");
        countryRepository.findById("IN").ifPresent(c ->
                System.out.println("✔ Updated: " + c.getCode() + " - " + c.getName())
        );
    }

    private void runStockQueries() {
        System.out.println("\n📊 Facebook Stock (Sept 2019):");
        stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        ).forEach(System.out::println);

        System.out.println("\n📊 Google Stock with Close > 1250:");
        stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"))
                .forEach(System.out::println);

        System.out.println("\n📊 Top 3 Stocks by Volume:");
        stockRepository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);

        System.out.println("\n📊 Lowest 3 Netflix Closing Prices:");
        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);
    }
}
