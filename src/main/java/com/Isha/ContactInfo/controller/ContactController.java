package com.Isha.ContactInfo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Isha.ContactInfo.Constant.Appconstant;
import com.Isha.ContactInfo.Model.Contactinfo;
import com.Isha.ContactInfo.props.AppProps;
import com.Isha.ContactInfo.services.ServicesI;

@Controller
public class ContactController {
	
	@Autowired
	private ServicesI servicesI;
	
	@Autowired
	private AppProps appProps;
	
	@GetMapping("/ContactPage")
	public String ContactPage(Model model)
	{
	    Contactinfo contactinfo=new Contactinfo();
		model.addAttribute("contactinfo", contactinfo);
		
		return Appconstant.CONTACTINFO;
		
	}
	
	
	
	@PostMapping("/SaveContact")
	public String SaveData(Contactinfo contactinfo,Model model)
	{
		
		boolean saveData = servicesI.SaveData(contactinfo);
		Map<String,String> messages = appProps.getMessages();
		if(saveData)
		{
			model.addAttribute(Appconstant.SUCCESS, messages.get(Appconstant.SAVE_SUCCESS));
		}
		else {
			model.addAttribute(Appconstant.FAIL, messages.get(Appconstant.SAVE_FAIL));
		}
		return Appconstant.CONTACTINFO;
		
	}
	@GetMapping("/viewContact")
	public String viewContacts(Model model)
	{
		List<Contactinfo> viewContacts = servicesI.viewContacts();
		model.addAttribute(Appconstant.CONTACT, viewContacts);
		return Appconstant.CONTACT;
	}

}
