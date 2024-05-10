package com.fullstack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Product save(Product product) {
		if (product != null) {
			entityManager.persist(product);
		}
		return product;

	}

	@Override
	public List<Product> getAll() {
		Query query = entityManager.createQuery("from Product");
		return query.getResultList();
	}

	@Override
	public Product deleteById(int prodId) {
		Product obj = entityManager.find(Product.class, prodId);
		entityManager.remove(obj);
		return obj;

	}

}
