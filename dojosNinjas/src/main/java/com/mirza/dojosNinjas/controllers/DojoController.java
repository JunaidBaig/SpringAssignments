package com.mirza.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mirza.dojosNinjas.models.Dojo;
import com.mirza.dojosNinjas.services.DojoService;

@Controller
public class DojoController {
//-------------------------------------------------------------------------------------------------
// Attributes(Controllers need Service Attributes in order to access info from the Service)
//-------------------------------------------------------------------------------------------------
	private final DojoService dojoService;
	//---------------------------------------------------------------------------------------------
	// Constructor Method that Makes Service apart of the instance of the Controller
	//---------------------------------------------------------------------------------------------
	public DojoController(DojoService dojoService) {
		//-----------------------------------------------------------------------------------------
		// Attach Service to instance of Controller
		//-----------------------------------------------------------------------------------------
		this.dojoService = dojoService;
	}
//-------------------------------------------------------------------------------------------------
// GET route for CREATING a new Dojo
//-------------------------------------------------------------------------------------------------
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos_ninjas/createDojo.jsp";
	}
//-------------------------------------------------------------------------------------------------
// POST route for CREATING a new Dojo
//-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dojo/process", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo createDojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos_ninjas/createDojo.jsp";
		} else {
			dojoService.createDojo(createDojo);
			return "redirect:/ninjas/new";
		}
	}
//-------------------------------------------------------------------------------------------------
// GET route for READING all Dojo's
//-------------------------------------------------------------------------------------------------
	@RequestMapping("/")
	public String index(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/dojos_ninjas/readAll.jsp";
	}
//-------------------------------------------------------------------------------------------------
// GET route for READING one Dojo by ID
//-------------------------------------------------------------------------------------------------
	@GetMapping("/dojos/{dojo_id}")
	public String getDojo(@PathVariable("dojo_id") Long id, Model model) { 
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "/dojos_ninjas/readOne.jsp";
	}
//-------------------------------------------------------------------------------------------------
// POST route for DELETING one Dojo by ID
//-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/dojos/{dojo_id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("dojo_id") Long id) {
		dojoService.deleteDojo(id);
		return "redirect:/";
	}
}
