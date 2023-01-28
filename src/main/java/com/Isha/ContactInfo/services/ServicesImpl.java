package com.Isha.ContactInfo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Isha.ContactInfo.Constant.Appconstant;
import com.Isha.ContactInfo.Model.Contactinfo;
import com.Isha.ContactInfo.Model.UserInfo;
import com.Isha.ContactInfo.Repository.ContactRepo;
import com.Isha.ContactInfo.Repository.Userrepo;

@Service
public class ServicesImpl implements ServicesI {

	@Autowired
	private ContactRepo contactRepo;
	
	@Autowired
	private Userrepo userrepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public  boolean  SaveData(Contactinfo contactinfo) {
		contactinfo.setIsActive(Appconstant.YES);
		
		Contactinfo save = this.contactRepo.save(contactinfo);
		
		if(save!=null && save.getContactId()!=null)
		{
			
			System.out.println(save);
		return true;
		}
		return false;
	}

	@Override
	public List<Contactinfo> viewContacts() {
		List<Contactinfo> findAll = contactRepo.findAll();
		
		return findAll.stream()
				.filter(Contactinfo-> Contactinfo.getIsActive()==Appconstant.YES).collect(Collectors.toList());
		
	}

	@Override
	public Contactinfo getContactByid(Integer id) {
		Optional<Contactinfo> findById = contactRepo.findById(id);
		if(findById.isPresent())
		{ 
			Contactinfo contactinfo = findById.get();
			Contactinfo save = contactRepo.save(contactinfo);
			return save ;
		}
		return null;
	}

	@Override
	public boolean deleteByidcontact(Integer contactid) {
		Optional<Contactinfo> findById = contactRepo.findById(contactid);
		if(findById.isPresent())
		{
			Contactinfo contactinfo = findById.get();
			contactinfo.setIsActive(Appconstant.NO);
			contactRepo.save(contactinfo);
			//contactRepo.delete(contactinfo);
			return true;
		}
		return false;
	}

	@Override
	public boolean saveUser(UserInfo userInfo) {
		
		
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		UserInfo save = userrepo.save(userInfo);
		
		if(save!=null && save.getId()!=null)
		{
			return true;
			
		}
		return false;
		
		
	}

}
