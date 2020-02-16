package com.lawrence.dojos.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.lawrence.dojos.models.Dojo;
import com.lawrence.dojos.models.Ninja;
import com.lawrence.dojos.services.AppService;

@Controller
public class DojosCtrl {
	private final AppService aS;
	
	
	
	public DojosCtrl(AppService aS) {
		this.aS = aS;
	}
	@GetMapping("/")
	public String index(){
		return "/dojos/index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String displayDojos(@ModelAttribute("dojo")Dojo dojo) {

		return "/dojos/newdojo.jsp";
	}
	@GetMapping("/ninjas/new")
	public String displayNinjas(@ModelAttribute("newninja")Ninja ninja, Model model) {
		List<Ninja> ninjas= this.aS.allNinjas();
		List<Dojo>	dojos = this.aS.allDojos();
		model.addAttribute("ninjas", ninjas);	
		model.addAttribute("dojos", dojos);
		return "/ninjas/newninja.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/newdojo.jsp";
		} else {
			aS.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
    @PostMapping("/ninjas/new")
    public String newninja(Model model,@Valid @ModelAttribute("newninja")Ninja ninja, BindingResult result) {
    	if (result.hasErrors()) {
            List<Dojo> dojos = aS.allDojos();
        	model.addAttribute("dojos", dojos);
    		return "/ninjas/newninja.jsp";
    	} else {
    		aS.createNinja(ninja);
    		return "redirect:/";
    	}
    }
    @GetMapping("/dojos/{id}")
    public String displayDojo(@PathVariable("id")Long id, Model model) {

    	Dojo dojo = this.aS.getDojo(id);
    	List<Ninja> ninjas= this.aS.getByDojoId(id);
    	model.addAttribute("dojo", dojo);
    	model.addAttribute("ninjas", ninjas);
    	return "/dojos/displayDojo.jsp";
    }
}
