package com.mirza.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mirza.lookify.models.Lookify;
import com.mirza.lookify.services.LookifyService;

@RestController
public class LookifyApi {
	private final LookifyService lookService;
    public LookifyApi(LookifyService lookService){
        this.lookService = lookService;
    }
    @RequestMapping("/api/dashboard")
    public List<Lookify> index() {
        return lookService.allSongs();
    }
    
    @RequestMapping(value="/api/songs/new", method=RequestMethod.POST)
    public Lookify create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") Integer rating) {
    	Lookify songs = new Lookify(title, artist, rating);
        return lookService.create(songs);
    }
    
    @RequestMapping("/api/songs/{id}")
    public Lookify show(@PathVariable("id") Long id) {
    	Lookify songs = lookService.find(id);
        return songs;
    }
    
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        lookService.delete(id);
    }
    
    @RequestMapping("/api/search/topTen")
    public List<Lookify> topTen(){
    	return lookService.topTen();
    }
    @RequestMapping("/api/search/{artist}")
    public List<Lookify> search(@PathVariable("artist") String artist){
    	return lookService.search(artist);
    }
}
