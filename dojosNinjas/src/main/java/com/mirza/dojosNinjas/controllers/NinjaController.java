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
import com.mirza.dojosNinjas.models.Ninja;
import com.mirza.dojosNinjas.services.DojoService;
import com.mirza.dojosNinjas.services.NinjaService;

@Controller
public class NinjaController {
//-------------------------------------------------------------------------------------------------
// Attributes(Controllers need Service Attributes in order to access info from the Service)
//-------------------------------------------------------------------------------------------------
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	//---------------------------------------------------------------------------------------------
	// Constructor Method that Makes Service apart of the instance of the Controller
	//---------------------------------------------------------------------------------------------
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		//-----------------------------------------------------------------------------------------
		// Attach Service to instance of Controller
		//-----------------------------------------------------------------------------------------		
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
//-------------------------------------------------------------------------------------------------
// GET route for CREATING a new Ninja
//-------------------------------------------------------------------------------------------------	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/dojos_ninjas/createNinja.jsp";
	}
//-------------------------------------------------------------------------------------------------
// POST route for CREATING a new Ninja
//-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/ninja/process", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja createNinja, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos_ninjas/createNinja.jsp";
		} else {
			ninjaService.createNinja(createNinja);
			return "redirect:/";
		}
	}
//-------------------------------------------------------------------------------------------------
// GET route for READING all Ninja's
//-------------------------------------------------------------------------------------------------
	@RequestMapping("/ninjas")
	public String index(Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "/dojos_ninjas/readAll.jsp";
	}
//-------------------------------------------------------------------------------------------------
// GET route for READING one Ninja by ID
//-------------------------------------------------------------------------------------------------
	@GetMapping("/ninjas/{ninja_id}")
	public String getPerson(@PathVariable("ninja_id") Long id, Model model) { 
		model.addAttribute("ninja", ninjaService.findNinja(id));
		return "/dojos_ninjas/readOne.jsp";
	}
//-------------------------------------------------------------------------------------------------
// POST route for DELETING one Ninja by ID
//-------------------------------------------------------------------------------------------------	
	@RequestMapping(value = "/ninjas/{ninja_id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("ninja_id") Long id) {
		ninjaService.deleteNinja(id);
		return "redirect:/";
	}
}
