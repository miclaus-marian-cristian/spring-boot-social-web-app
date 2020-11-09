package com.miclaus.socialwebapp.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.miclaus.socialwebapp.dao.StatusDao;
import com.miclaus.socialwebapp.models.Status;

@DataJpaTest
public class StatusTest {
	
	@Autowired
	private StatusDao statusDao;
	
	@Test
	public void testSave(){
		Status status = new Status("Hi, this is my first status!");
		Status savedStatus = statusDao.save(status);
		assertNotNull(savedStatus);
	}
	
	@Test
	void testFindFirstByOrderByAddedTimeDesc() throws InterruptedException {
		Status status1 = new Status("first one...");
		Status status2 = new Status("second one..");
		statusDao.save(status1);
		Thread.sleep(300);
		statusDao.save(status2);
		Status latestStatus = statusDao.findFirstByOrderByAddedTimeDesc();
		assertEquals(status2, latestStatus);
	}
	
}
