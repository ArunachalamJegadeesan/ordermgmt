package com.caveofprogramming.spring.web.controller;

import com.caveofprogramming.spring.web.model.Offer;
import org.springframework.web.client.RestTemplate;

//import com.caveofprogramming.spring.web.model.User;
//import com.caveofprogramming.spring.web.validator.UserValidator;
import com.caveofprogramming.spring.web.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class OfferController {
	
	//@Autowired
	//private UserValidator userValidator;
	
	Logger logger = LoggerFactory.getLogger(OfferController.class);
	
	@RequestMapping(value = "/createoffer", method = RequestMethod.GET)
	public String createOffer(Model model) {
		
		logger.debug("inside createOffer>>>>");
		model.addAttribute("offerForm", new Offer());

		return "createoffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate( @ModelAttribute("offerForm") Offer offerForm,Model model,BindingResult bindingResult) {
		
		logger.debug("inside new Offer>>>>");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation(System.getenv("offerservice.endpoint"),offerForm);
		
	
		if (bindingResult.hasErrors()) {
			return "createoffer";
		}		
		//userService.save(offerForm);
		logger.debug("after save offer>>>>");

		return "redirect:/offercreated";
	}

	
	@RequestMapping(value = "/offercreated", method = RequestMethod.GET)
	public String offerCreated(Model model) {
		logger.debug("Inside offercraeted>>>>>");
		
		return "offercreated";

	}
	
	@RequestMapping(value = "/offers", method = RequestMethod.GET)
	public String showOffers(Model model) {
		
		logger.debug("Inside showOffers>>>>>"+System.getenv("offerservice.endpoint"));
		
		
		RestTemplate restTemplate = new RestTemplate();
		Offer[] offers=  restTemplate.getForObject(System.getenv("offerservice.endpoint"), Offer[].class);
	
		
		model.addAttribute("offers", offers);
		
		return "offers";

	}

	

}
