package com.lawrence.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawrence.dojos.models.Dojo;
import com.lawrence.dojos.models.Ninja;
import com.lawrence.dojos.repositories.DojoRepo;
import com.lawrence.dojos.repositories.NinjaRepo;

@Service
public class AppService {
	@Autowired
	private DojoRepo dR;
	private NinjaRepo nR;

	public AppService(DojoRepo dR, NinjaRepo nR) {
		this.dR = dR;
		this.nR = nR;
	}

	public List<Dojo> allDojos() {
		return dR.findAll();
	}

	public Dojo createDojo(Dojo dojo) {
		return dR.save(dojo);
	}

	public List<Ninja> allNinjas() {

		return nR.findAll();
	}

	public Ninja createNinja(Ninja ninja) {

		return nR.save(ninja);
	}

	public Dojo getDojo(Long id) {
		Optional<Dojo> optionalDojo = this.dR.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}

		return null;
	}

	public List<Ninja> getByDojoId(Long id) {

		return this.nR.findByDojoId(id);
	}
}
