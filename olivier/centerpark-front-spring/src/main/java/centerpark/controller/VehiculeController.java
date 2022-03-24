package centerpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import centerpark.repositories.VehiculeRepository;

@Controller
@RequestMapping("/vehicule")
public class VehiculeController {

	@Autowired
	private VehiculeRepository vehiculeRepo;
	
	@GetMapping("")
	public String list(Model model ) {
		model.addAttribute("vehicules", vehiculeRepo.findAll());
		return "vehicule/list";
	}
}
