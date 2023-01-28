package com.Isha.ContactInfo.services;

import java.util.List;

import com.Isha.ContactInfo.Model.Contactinfo;
import com.Isha.ContactInfo.Model.UserInfo;

public interface ServicesI {
	
	public boolean SaveData(Contactinfo contactinfo);
	
	public List<Contactinfo> viewContacts();
	
	public Contactinfo getContactByid(Integer id);
	
	public boolean deleteByidcontact(Integer contactid);
	
	public boolean saveUser(UserInfo userInfo);
	
	

}
