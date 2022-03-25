package centerpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import centerpark.model.Vehicule;
import centerpark.repositories.VehiculeRepository;

@Controller
@RequestMapping("/vehicule")
public class VehiculeController {

	@Autowired
	private VehiculeRepository vehiculeRepo;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("vehicules", vehiculeRepo.findAll());
		return "vehicule/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Vehicule());
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Integer id) {
		return goEdit(model, vehiculeRepo.findById(id).orElseThrow());
	}

	private String goEdit(Model model, Vehicule vehicule) {
		model.addAttribute("vehicule", vehicule);
		return "vehicule/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Vehicule vehicule) {
		if (vehicule.getId() != null) {
			// update
			Vehicule vehiculeBase = vehiculeRepo.findById(vehicule.getId()).orElseThrow();
			vehicule.setVersion(vehiculeBase.getVersion());
		}
		vehiculeRepo.save(vehicule);
		return "redirect:/vehicule";
	}
	
	@GetMapping("/delete")
	public String delete(Integer id) {
		vehiculeRepo.deleteById(id);
		return "redirect:/vehicule";
	}
}
