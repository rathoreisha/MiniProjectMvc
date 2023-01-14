package com.Isha.ContactInfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Isha.ContactInfo.Constant.Appconstant;
import com.Isha.ContactInfo.Model.Contactinfo;
import com.Isha.ContactInfo.Repository.ContactRepo;

@Service
public class ServicesImpl implements ServicesI {

	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public  boolean  SaveData(Contactinfo contactinfo) {
		contactinfo.setIsActive(Appconstant.YES);
		Contactinfo save = this.contactRepo.save(contactinfo);
		if(save!=null && save.getContactName()!=null)
		{
			
			System.out.println(save);
		return true;
		}
		return false;
	}

	@Override
	public List<Contactinfo> viewContacts() {
		List<Contactinfo> findAll = contactRepo.findAll();
		
		return findAll;
	}

	@Override
	public Contactinfo getContactByid(Integer id) {
		Optional<Contactinfo> findById = contactRepo.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteByidcontact(Integer contactid) {
		Optional<Contactinfo> findById = contactRepo.findById(contactid);
		if(findById.isPresent())
		{
			Contactinfo contactinfo = findById.get();
			contactRepo.delete(contactinfo);
			return true;
		}
		return false;
	}

}
