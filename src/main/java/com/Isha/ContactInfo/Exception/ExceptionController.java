package com.Isha.ContactInfo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NullPointerException.class)
	public String nullPointerexception(Model model)
	{
		model.addAttribute("Msg", "Null Pointer Exception Please Check....");
		return "Exception";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=ArithmeticException.class)
	public String Arithmeticexception(Model model)
	{
		model.addAttribute("Msg", "Aritmetic Exception Please Check....");
		return "Exception";
	}

}
