package com.mirza.languages.services;

import org.springframework.stereotype.Service;

import com.mirza.languages.models.Language;
import com.mirza.languages.repository.LanguageRepository;


import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
private final LanguageRepository langRepo;
    
    public LanguageService(LanguageRepository langRepo) {
        this.langRepo = langRepo;
    }
    // returns all the books
    public List<Language> all() {
        return langRepo.findAll();
    }
    // creates a book
    public Language create(Language b) {
        return langRepo.save(b);
    }
    // retrieves a book
    public Language find(Long id) {
        Optional<Language> optionalBook = langRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Language update(Long id, String name, String creator, String currentVersion) {
    	Optional<Language> optionalBook = langRepo.findById(id);
        if(optionalBook.isPresent()) {
        	Language edit = optionalBook.get();
            edit.setName(name);
            edit.setCreator(creator);
            edit.setCurrentVersion(currentVersion);
            
            
            return langRepo.save(edit);
            
        } else {
            return null;
        }
    }
    public void delete(Long id) {
    	Optional<Language> book = langRepo.findById(id);
        if(book.isPresent()) {
            langRepo.deleteById(id);
        } else {
            System.out.println("Id doesn't exists");
        }
    }
}
