package com.hql.jpql.demo.service;

import com.hql.jpql.demo.model.Product;
import com.hql.jpql.demo.model.ProductFilter;

import java.util.List;

public interface ProductService {
    List<Product> filterProducts(ProductFilter filter);
}
