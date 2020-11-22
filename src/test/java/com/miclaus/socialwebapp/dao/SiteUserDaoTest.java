package com.miclaus.socialwebapp.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.miclaus.socialwebapp.models.SiteUser;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = true)
public class SiteUserDaoTest {

	@Autowired
	private SiteUserDao siteUserDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void shouldFindAUserByEmail() {
		SiteUser siteUser = new SiteUser();
		siteUser.setEmail("test2@mail.com");
		siteUser.setPassword(encoder.encode("test"));
		siteUser.setRole("ROLE_USER");
		siteUserDao.save(siteUser);
		SiteUser expectedUser = null;
		Optional<SiteUser> opt = siteUserDao.findByEmail("test2@mail.com");
		if(opt.isPresent())
			expectedUser=opt.get();
		
		assertNotNull(expectedUser);
	}
	
}
