package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.BranoService;

@Controller
public class MainController {
	/*
	@Autowired
	private AutoreService cs;
	
	@Autowired
	private BranoService bs;

	
	@GetMapping("/")
	public String goHome(Model model) {
		model.addAttribute("autori", this.cs.findAllAutore());
		model.addAttribute("branoList", this.bs.listaBrani());
		return "index.html";
	}
	*/
	/*
	//@GetMapping("/login")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login.html";
	}
	
	//@GetMapping("/logout")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "index.html";
	}
	*/
	//get logged user
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home (Model model) {
		return "home.html";
	}
	
}
