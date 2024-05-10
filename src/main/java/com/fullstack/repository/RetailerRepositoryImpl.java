package com.fullstack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.model.Product;
import com.fullstack.model.Retailer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
@Transactional
public class RetailerRepositoryImpl implements RetailerRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Retailer save(Retailer retailer) {
		if(retailer!=null) {
			entityManager.persist(retailer);
		}
		return null;
	}

	@Override
	public List<Retailer> getAllRet() {
		Query query= entityManager.createQuery("from Retailer");
		return query.getResultList();
	}

	@Override
	public Retailer deleteById(int retId) {
		Retailer obj = entityManager.find(Retailer.class, retId);
		entityManager.remove(obj);
		return obj;

	}

}
