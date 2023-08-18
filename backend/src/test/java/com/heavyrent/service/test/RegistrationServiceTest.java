package com.heavyrent.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.heavyrent.dao.UserDao;
import com.heavyrent.pojo.RoleType;
import com.heavyrent.pojo.Status;
import com.heavyrent.pojo.User;


@DataJpaTest //spring boot test annotation to enable ONLY DAO layer n entities
@AutoConfigureTestDatabase(replace = Replace.NONE) // DO NOT replace 
//main db by test db
@Rollback(false) //after completion of test cases DO NOT rollback tx.
class RegistrationServiceTest {
	
	@Autowired
	private  UserDao dao; 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testRegistrationServiceImpl() {
		 // TODO
		
		User user = new User();
		user.setName("Suyash");
		user.setAddress("Buldana");
		user.setEmail("suyash@123");
		
		  User user1 = dao.save(user);
		  
		  if(user1 != null)
			  System.out.println("Registered");
		
	}

	@Test
	final void testSaveUser() {
		fail("Not yet implemented"); // TODO
	}

}
