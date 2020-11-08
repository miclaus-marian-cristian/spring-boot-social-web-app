package com.miclaus.socialwebapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miclaus.socialwebapp.dao.StatusDao;
import com.miclaus.socialwebapp.models.Status;

@Service
public class StatusService {
	@Autowired
	private StatusDao statusDao;
	
	public void save(Status status){
		statusDao.save(status);
	}
	
	public Status getLatest() {
		return statusDao.findFirstByOrderByAddedTimeDesc();
	}
}
