package centerpark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import centerpark.model.Participant;
import centerpark.services.ParticipantService;

@Controller
@RequestMapping("/participant")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;
	
	@GetMapping("")
	public String list(Model model){
		model.addAttribute("participants", participantService.getAll());
		return "participant/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Integer id,Model model) {
		return goEdit(model, participantService.getById(id));
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Participant());
	}
	
	private String goEdit(Model model,Participant participant) {
		model.addAttribute("participant", participant);
		return "participant/edit";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		participantService.delete(id);
		return "redirect:/participant";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant) {
		participantService.save(participant);
		return "redirect:/participant";
	}
}
