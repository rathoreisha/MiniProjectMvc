package com.Isha.ContactInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Isha.ContactInfo.Model.Contactinfo;
import com.Isha.ContactInfo.services.ServicesI;

@Controller
public class ViewController {
	
	@Autowired
	private ServicesI servicesI;
	
	@GetMapping("/edit")
	public String getContacts(@RequestParam("contactId") Integer cid,Model model)
	{
		Contactinfo contactByid = servicesI.getContactByid(cid);
		model.addAttribute("contactinfo", contactByid);
		return "contactInfo";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") Integer id,Model model)
	{
		servicesI.deleteByidcontact(id);
		return "redirect:viewContact";
	}

}
