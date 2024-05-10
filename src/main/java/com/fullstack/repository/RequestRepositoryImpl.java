package com.fullstack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fullstack.model.Request;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
@Transactional
public class RequestRepositoryImpl implements RequestRepository{

	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Request save(Request request) {
		if(request!=null) {
			entityManager.persist(request);
		}
		return null;
	}

	@Override
	public List<Request> getAll() {
		Query query= entityManager.createQuery("from Request");
		return query.getResultList();
	}



}
