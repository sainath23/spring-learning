package com.doitgeek.springformdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.doitgeek.springformdemo.entity.CustomerEntity;

@Controller
public class HomeController {
	
	// Add initbinder to convert trim input strings
	// remove leading and trailing whitespaces
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String showHome() {
		return "index";
	}
	
	@GetMapping("/show-form")
	public String showCustomerForm(Model model) {
		CustomerEntity customer = new CustomerEntity();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/process-form")
	public String processForm(@Valid @ModelAttribute("customer") CustomerEntity customer, BindingResult bindingResult, Model model) {
		System.out.println(">>> Last Name: |" + customer.getLastName() + "|");
		System.out.println(">>> Binding result: " + bindingResult);
		System.out.println("\n\n\n\n");
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
	}
}
