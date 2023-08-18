package com.heavyrent.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.heavyrent.pojo.RoleType;
import com.heavyrent.pojo.User;

@Repository
public interface UserDao  extends JpaRepository<User, Long>{

	Optional<User> findByEmailAndPassword(String email,String password);
	Optional<User> findByEmail(String email);
	List<User> findAllByRole(RoleType role);
	
//	@Query("SELECT u FROM User u WHERE"
//		+ " u.%?2% LIKE %?1%")
//		+ " OR u.name LIKE %?1%"
//		+ " OR u.mobile_no LIKE %?1%"
//		+ " OR u.email LIKE %?1%"
//		+ " OR u.pin LIKE %?1%"
//		+ " OR u.address LIKE %?1%")
//		+ " OR u.role ='%?1%'")
//		    + "CONCAT(u.user_id, u.name, u.address)"
//		    + " LIKE '%?1%'") 
////			+"AND u.RoleType='CUSTOMER'")
//	List<User> findAllByRole(String keyword,String column);
	
	List<User> findByEmailContainingAndAddressContainingAndNameContaining(
            String email,String address,String name);
	
}
