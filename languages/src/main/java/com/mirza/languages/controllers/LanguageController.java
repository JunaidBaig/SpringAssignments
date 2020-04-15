package com.mirza.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mirza.languages.models.Language;
import com.mirza.languages.services.LanguageService;


@Controller
public class LanguageController {
	private final LanguageService langService;
    
    public LanguageController(LanguageService langService) {
        this.langService = langService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = langService.all();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
    
    @RequestMapping("/languages/new")
    public String newBook(@ModelAttribute("language") Language language) {
        return "/languages/new.jsp";
    }
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/new.jsp";
        } else {
            langService.create(language);
            return "redirect:/languages";
        }
    }
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language language = langService.find(id);
        model.addAttribute("language", language);
        return "/languages/show.jsp";
    }
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = langService.find(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
            langService.update(id, language.getName(), language.getCreator(), language.getCurrentVersion());
            return "redirect:/languages";
        }
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        langService.delete(id);
        return "redirect:/languages";
    }

}
