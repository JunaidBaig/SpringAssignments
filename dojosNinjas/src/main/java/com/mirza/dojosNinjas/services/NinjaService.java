package com.mirza.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mirza.dojosNinjas.models.Ninja;
import com.mirza.dojosNinjas.repositories.NinjaRepository;



@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
//-------------------------------------------------------------------------------------------------
// CREATES one Ninja
//-------------------------------------------------------------------------------------------------
	public Ninja createNinja(Ninja createNinja) {
		return ninjaRepository.save(createNinja);
	}
//-------------------------------------------------------------------------------------------------
// READS all the Ninja's
//-------------------------------------------------------------------------------------------------
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
//-------------------------------------------------------------------------------------------------
// DELETES one Ninja by ID
//-------------------------------------------------------------------------------------------------
	public void deleteNinja(Long id) {
		Ninja deleteNinja= this.findNinja(id);
	 	ninjaRepository.delete(deleteNinja);
	 }
//-------------------------------------------------------------------------------------------------
// FINDS one Ninja by ID
//-------------------------------------------------------------------------------------------------
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}

