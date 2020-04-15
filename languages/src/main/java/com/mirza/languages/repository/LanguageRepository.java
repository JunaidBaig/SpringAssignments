package com.mirza.languages.repository;

import org.springframework.data.repository.CrudRepository;

import com.mirza.languages.models.Language;
import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	// this method retrieves all the books from the database
    List<Language> findAll();
    // this method finds books with descriptions containing the search string
    Optional<Language> findById(Long id);
    // this method counts how many titles contain a certain string
//    Long countByNameContaining(String search);
//    // this method deletes a book that starts with a specific name
//    Long deleteByTitleStartingWith(String search);
}
