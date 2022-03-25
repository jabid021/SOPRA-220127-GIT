package centerpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import centerpark.model.Activite;
import centerpark.model.Aquatique;
import centerpark.model.Meteo;
import centerpark.model.Safari;
import centerpark.services.ActiviteService;
import centerpark.services.VehiculeService;

@Controller
@RequestMapping("/activite")
public class ActiviteController {

	@Autowired
	private ActiviteService activiteService;
	@Autowired
	private VehiculeService vehiculeService;
	
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("activites", activiteService.getAll());
		return "activite/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Integer id,Model model) {
		return goEdit(model, activiteService.getById(id));
	}
	
	@GetMapping("/add/safari")
	public String addSafari(Model model) {
		return goEdit(model,new Safari());
	}
	
	@GetMapping("/add/aquatique")
	public String addAquatique(Model model) {
		return goEdit(model, new Aquatique());
	}
	
	public String goEdit(Model model,Activite activite) {
		model.addAttribute("activite", activite);
		model.addAttribute("allMeteos", Meteo.values());
		model.addAttribute("vehicules", vehiculeService.getAll());
		return "activite/edit";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		activiteService.delete(id);
		return "redirect:/activite";
	}
	
	@GetMapping("/save/safari")
	public String saveSafari(@ModelAttribute Safari safari) {
		return save(safari);
	}
	
	@GetMapping("/save/aquatique")
	public String saveAquatique(@ModelAttribute Aquatique aquatique) {
		return save(aquatique);
	}
	
	private String save(Activite activite) {
		activiteService.save(activite);
		return "redirect:/activite";
	}
	
}
