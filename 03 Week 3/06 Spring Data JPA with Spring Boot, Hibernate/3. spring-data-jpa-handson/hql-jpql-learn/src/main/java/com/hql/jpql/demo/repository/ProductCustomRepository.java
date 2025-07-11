package com.hql.jpql.demo.repository;

import com.hql.jpql.demo.model.Product;
import com.hql.jpql.demo.model.ProductFilter;

import java.util.List;

public interface ProductCustomRepository {
    List<Product> filterProducts(ProductFilter filter);
}
