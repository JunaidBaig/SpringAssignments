package com.mirza.lookify.services;

import com.mirza.lookify.models.Lookify;
import com.mirza.lookify.repositories.LookifyRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class LookifyService {
	private final LookifyRepository lookifyRepo;
	
	
	public LookifyService(LookifyRepository lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}
	
	public List<Lookify> allSongs() {
        return lookifyRepo.findAll();
    }
    // creates a song
    public Lookify create(Lookify b) {
        return lookifyRepo.save(b);
    }
    // retrieves a song
    public Lookify find(Long id) {
        Optional<Lookify> optionalSong = lookifyRepo.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public void delete(Long id) {
    	Optional<Lookify> book = lookifyRepo.findById(id);
        if(book.isPresent()) {
            lookifyRepo.deleteById(id);
        } else {
            System.out.println("Id doesn't exists");
        }
    }
    
    public List<Lookify> search(String artist) {
    	return lookifyRepo.findByArtistContaining(artist);
    }
    
    public List<Lookify> topTen(){
    	return lookifyRepo.findTop10ByOrderByRatingDesc();
    }
}
