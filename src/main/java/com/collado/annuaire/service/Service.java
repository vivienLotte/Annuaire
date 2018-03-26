package com.collado.annuaire.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


public class Service {
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "Salut toi";
	}
	
	@GetMapping("/test")
	
	public String test(@RequestParam(required = false)String name,Model model) {
		model.addAttribute("name", name);
		return "/index";
	}
}
