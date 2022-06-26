package it.uniroma3.siw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.Validator.UtenteValidator;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.UtenteService;

@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService us;
	
	@Autowired
	private UtenteValidator uv;
	
	@RequestMapping(value = "/utenti", method = RequestMethod.GET)
	public String mostraListaUtenti (Model model) {
		model.addAttribute("utenti", this.us.getAllUtenti());
		return "utenti.html";
	}
	
	@RequestMapping(value = "/utenti/{id}", method = RequestMethod.GET)
	public String getUtente (@PathVariable("id") Long id, Model model) {
		model.addAttribute("utente", this.us.findById(id));
		return "utente.html";
	}
	
	//modifica un utente
	@GetMapping("/modificaUtente/{id}")
	public String modificaUtente(@PathVariable("id") Long id, Model model) {
		Utente utente = us.findById(id).get();
		model.addAttribute("utenti", utente);
		return "modificaUtente.html";
	}
	
	//Form per modificare un utente
		@PostMapping("/modificaUtente/{id}")
		public String modificaUtenteForm(@PathVariable("id") Long id, @Valid @ModelAttribute Utente newUtente,
				BindingResult utenteBindingResult, Model model) {
			this.uv.validate(newUtente, utenteBindingResult);
			if (!utenteBindingResult.hasErrors()) {
				this.us.update(this.us.findById(id).get(), newUtente);
				List<Utente> utens = this.us.getAllUtenti();
				model.addAttribute("utens", utens);
				return "utenti.html";
			}
			return "modificaUtente.html";
		}
		
		//Elimina uno chef
		@GetMapping("/deleteUtente/{id}")
		public String deleteUtente(@PathVariable("id") Long id, Model model) {
			this.us.delete(id);
			return "utenti.html";
		}

}
