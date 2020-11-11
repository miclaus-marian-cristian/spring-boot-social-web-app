package com.miclaus.socialwebapp.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.miclaus.socialwebapp.models.Status;

@Repository
public interface StatusDao extends PagingAndSortingRepository<Status, Long> {

	public Status findFirstByOrderByAddedTimeDesc();
	
}
