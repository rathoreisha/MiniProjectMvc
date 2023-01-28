package com.Isha.ContactInfo.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Isha.ContactInfo.Model.UserInfo;
import com.Isha.ContactInfo.Repository.Userrepo;

public class UserInfoDetailsServices implements UserDetailsService {

	@Autowired
	private Userrepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userinfo = userrepo.findByName(username);
		return userinfo.map(Userinfodetails::new).orElseThrow();
	}

}
