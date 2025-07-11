package com.hql.jpql.demo.service;

import com.hql.jpql.demo.model.Product;
import com.hql.jpql.demo.model.ProductFilter;
import com.hql.jpql.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> filterProducts(ProductFilter filter) {
        return productRepository.filterProducts(filter);
    }
}
