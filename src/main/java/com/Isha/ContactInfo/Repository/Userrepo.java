package com.Isha.ContactInfo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Isha.ContactInfo.Model.UserInfo;

@Repository
public interface Userrepo extends JpaRepository<UserInfo, Integer> {
	
	 Optional<UserInfo> findByName(String name);

}
