package com.hql.jpql.demo.repository;

import com.hql.jpql.demo.model.Product;
import com.hql.jpql.demo.model.ProductFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> filterProducts(ProductFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getCpu() != null && !filter.getCpu().isEmpty()) {
            predicates.add(cb.equal(product.get("cpu"), filter.getCpu()));
        }

        if (filter.getOs() != null && !filter.getOs().isEmpty()) {
            predicates.add(cb.equal(product.get("os"), filter.getOs()));
        }

        if (filter.getRam() != null) {
            predicates.add(cb.equal(product.get("ram"), filter.getRam()));
        }

        query.select(product).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
