package com.miclaus.socialwebapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miclaus.socialwebapp.models.Status;

@Repository
public interface StatusDao extends CrudRepository<Status, Long>{

	public Status findFirstByOrderByAddedTimeDesc();
	
}
