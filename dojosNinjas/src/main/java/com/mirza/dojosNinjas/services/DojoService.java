package com.mirza.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mirza.dojosNinjas.models.Dojo;
import com.mirza.dojosNinjas.repositories.DojoRepository;



@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
//-------------------------------------------------------------------------------------------------
// CREATES a Dojo
//-------------------------------------------------------------------------------------------------
    public Dojo createDojo(Dojo createDojo) {
        return dojoRepository.save(createDojo);
    }
//-------------------------------------------------------------------------------------------------
// READS all the Dojo's
//-------------------------------------------------------------------------------------------------
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
//-------------------------------------------------------------------------------------------------
// RETRIEVES one Dojo by ID
//-------------------------------------------------------------------------------------------------
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
//-------------------------------------------------------------------------------------------------
// DELETES one Dojo by ID
//-------------------------------------------------------------------------------------------------
 	public void deleteDojo(Long id) {
 		Dojo deleteDojo= this.findDojo(id);
 		dojoRepository.delete(deleteDojo);
 	}
}
