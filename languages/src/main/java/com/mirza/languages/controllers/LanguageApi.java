package com.mirza.languages.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mirza.languages.models.Language;
import com.mirza.languages.services.LanguageService;
import java.util.List;

@RestController
public class LanguageApi {
	private final LanguageService langService;
    public LanguageApi(LanguageService langService){
        this.langService = langService;
    }
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return langService.all();
    }
    
    @RequestMapping(value="/api/language", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
    	Language language = new Language(name, creator, currentVersion);
        return langService.create(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
    	Language language = langService.find(id);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id,@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") String currentVersion) {
        Language language = langService.update(id, name, creator, currentVersion);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        langService.delete(id);
    }
}
