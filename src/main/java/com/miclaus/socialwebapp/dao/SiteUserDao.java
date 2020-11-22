package com.miclaus.socialwebapp.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miclaus.socialwebapp.models.SiteUser;

@Repository
public interface SiteUserDao extends CrudRepository<SiteUser, Long> {

	Optional<SiteUser> findByEmail(String email);
	
}
