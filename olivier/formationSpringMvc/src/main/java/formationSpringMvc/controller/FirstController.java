package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import formationSpringMvc.model.Personne;

@Controller
@RequestMapping("/hello")
public class FirstController {

	//@RequestMapping(path = "/hello",method = RequestMethod.GET)
	@GetMapping("")
	public String hello(@RequestParam(name = "prenom", required = false, defaultValue = "world") String prenom,
			@RequestParam(name = "nom", required = false, defaultValue = "world") String nom,Model model) {
		
		Personne personne=new Personne(prenom, nom);
		model.addAttribute("personne", personne);
		return "hello";
	}
	
	@RequestMapping("/objet")
	public String hello2(@ModelAttribute Personne personne,Model model) {
		model.addAttribute("personne", personne);
		return "hello";
	}

	@RequestMapping("/bye")
	public String bye() {
		return null;
	}

}
