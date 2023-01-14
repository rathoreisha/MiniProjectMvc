package com.Isha.ContactInfo.services;

import java.util.List;

import com.Isha.ContactInfo.Model.Contactinfo;

public interface ServicesI {
	
	public boolean SaveData(Contactinfo contactinfo);
	
	public List<Contactinfo> viewContacts();
	
	public Contactinfo getContactByid(Integer id);
	
	public boolean deleteByidcontact(Integer contactid);

}
