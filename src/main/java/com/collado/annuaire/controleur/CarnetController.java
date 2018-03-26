package com.collado.annuaire.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.collado.annuaire.carnet.Carnet;
import com.collado.annuaire.service.CarnetService;

@RestController

public class CarnetController {
	@Autowired
	private CarnetService carnetService;
	
	

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Carnet> getAll() {
		return carnetService.getAll();
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
	public Carnet getById(@PathVariable int id) {
		return carnetService.getById(id);
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
	public void DelById(@PathVariable Integer id) {
		carnetService.DelById(id);
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public void add(@RequestBody Carnet carnet) {
		carnetService.add(carnet);
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
	public Carnet update(@RequestBody Carnet carnet, @PathVariable Integer id) {
		return carnetService.update(carnet, id);
	}

	@RequestMapping(value = "/vueAll", method = RequestMethod.GET)
	
	public ModelAndView afficherLesCarnets(){
		ModelAndView maVue = new ModelAndView("/pages/carnets");
		maVue.addObject("carnets", carnetService.getAll());
		return maVue;
	}

	@RequestMapping(value = "/vue/{id}", method = RequestMethod.GET)
	public ModelAndView afficherLesCarnets(@PathVariable int id){
		ModelAndView maVue = new ModelAndView("/pages/carnets");
		maVue.addObject("carnets", carnetService.getById(id));
		return maVue;
	}
	
	@PostMapping("/ajout")
	public void ajout(@ModelAttribute("formulaire") @Valid Carnet carnet, HttpServletResponse response) throws IOException {
		carnetService.addCarnet(carnet);
		response.sendRedirect("/vueAll");
	}
}
