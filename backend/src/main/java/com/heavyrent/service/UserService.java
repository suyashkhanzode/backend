package com.heavyrent.service;




import com.heavyrent.dto.LoginRequestAuth;
import com.heavyrent.dto.UserRequestDto;
import com.heavyrent.dto.EmailPasswordDTO;
import com.heavyrent.dto.UserResponse;
//import com.heavyrent.dto.LoginRequestAuth;
import com.heavyrent.pojo.User;

public interface UserService {

	//User getUser(LoginRequestAuth loginRequest);
	UserResponse getUserDetails(LoginRequestAuth loginRequestobj);
	User getUserbyid(Long user_id);
	String setNewPassword(EmailPasswordDTO forPassRequest) ;
	String setchangedPassword(EmailPasswordDTO forPassRequest) ;
	String CustomerForUpdate(UserRequestDto userForUpdate);
	String OrgForUpdate(UserRequestDto userForUpdate);
}
