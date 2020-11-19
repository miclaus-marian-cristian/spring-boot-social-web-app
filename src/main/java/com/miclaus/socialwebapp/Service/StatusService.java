package com.miclaus.socialwebapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.miclaus.socialwebapp.dao.StatusDao;
import com.miclaus.socialwebapp.models.Status;

@Service
public class StatusService {

	private final static int PAGESIZE = 3;

	@Autowired
	private StatusDao statusDao;

	public void save(Status status) {
		statusDao.save(status);
	}

	public Status getLatest() {
		return statusDao.findFirstByOrderByAddedTimeDesc();
	}

	public Page<Status> getPage(int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber - 1, PAGESIZE, Direction.DESC, "addedTime");
		return statusDao.findAll(request);
	}

	public void delete(Long id) {
		statusDao.deleteById(id);
	}
}
