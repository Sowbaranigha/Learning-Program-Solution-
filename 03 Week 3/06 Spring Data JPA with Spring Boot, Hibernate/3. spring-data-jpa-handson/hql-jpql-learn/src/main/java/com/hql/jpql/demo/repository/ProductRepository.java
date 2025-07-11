package com.hql.jpql.demo.repository;

import com.hql.jpql.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, ProductCustomRepository {
}
