package com.mirza.lookify.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mirza.lookify.models.Lookify;

import java.util.List;


@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll();
	List<Lookify> findByArtistContaining(String search);
	List<Lookify> findTop10ByOrderByRatingDesc();
	
}
