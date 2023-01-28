package com.Isha.ContactInfo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Isha.ContactInfo.Constant.Appconstant;
import com.Isha.ContactInfo.Model.UserInfo;
import com.Isha.ContactInfo.props.AppProps;
import com.Isha.ContactInfo.services.ServicesI;

@Controller
public class UserController {
	@Autowired
	private ServicesI servicesI;
	
	@Autowired
	private AppProps appProps;
	
	@GetMapping("/user")
	public String userForm(Model model)
	{
		UserInfo userInfo=new UserInfo();
		model.addAttribute("userInfo", userInfo);
		return Appconstant.USERINFO;
	}
	
	@PostMapping("userLogin")
	public String userLogin(UserInfo userInfo,Model model)
	{
		boolean saveUser = servicesI.saveUser(userInfo);
		Map<String,String> messages = appProps.getMessages();
		
		if(saveUser)
		{
			model.addAttribute(Appconstant.SUCCESS, messages.get(Appconstant.SAVE_SUCCESS));
		}
		else {
			model.addAttribute(Appconstant.FAIL, messages.get(Appconstant.SAVE_FAIL));
		}
		return Appconstant.USERINFO;
		
	}

}
