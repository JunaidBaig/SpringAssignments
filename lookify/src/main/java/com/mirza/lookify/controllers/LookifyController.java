package com.mirza.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mirza.lookify.models.Lookify;
import com.mirza.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private LookifyService lookService;

	public LookifyController(LookifyService lookService) {
		this.lookService = lookService;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> songs = lookService.allSongs();
		model.addAttribute("songs", songs);
		return "/songs/dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
    public String newBook(@ModelAttribute("song") Lookify song) {
        return "/songs/new.jsp";
    }
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/new.jsp";
        } else {
            lookService.create(song);
            return "redirect:/dashboard";
        }
    }
	@RequestMapping(value="/search/topTen")
	public String topSongs(Model model) {
		List<Lookify> topSongs = lookService.topTen();
		model.addAttribute("songs", topSongs);
		return "/songs/topTen.jsp";
	}
	
	@RequestMapping(value="/search")
    public String search(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "/dashboard";
        } else {
        	String artist = song.getArtist();
            return "redirect:/search/" + artist;
        }
    }
	@RequestMapping(value="/search/{artist}")
	public String showArtist(@PathVariable("artist") String artist, Model model) {
		List<Lookify> songs = lookService.search(artist);
		model.addAttribute("songs", songs);
		return "/songs/showArtist.jsp";
	}
	@RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Lookify song = lookService.find(id);
        model.addAttribute("song", song);
        return "/songs/show.jsp";
    }
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        lookService.delete(id);
        return "redirect:/dashboard";
    }
	
}
