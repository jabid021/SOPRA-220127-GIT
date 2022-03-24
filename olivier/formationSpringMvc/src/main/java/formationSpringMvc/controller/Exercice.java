package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formationSpringMvc.model.Login;

@Controller
@RequestMapping("/exo")
public class Exercice {

	@GetMapping("/form")
	public String formulaire() {
		return "exo/form";
	}

	@PostMapping("/connect")
	public String connect(@ModelAttribute Login login, Model model) {
		if (check(login)) {
			model.addAttribute("login", login.getLogin());
			return "exo/hello";
		}
		return "exo/form";
	}

	private boolean check(Login login) {
		return (login.getLogin().equals("toto") && login.getPassword().equals("toto"));
	}
}
