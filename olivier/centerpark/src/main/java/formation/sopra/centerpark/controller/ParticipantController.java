package formation.sopra.centerpark.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.centerpark.model.Participant;
import formation.sopra.centerpark.services.ParticipantService;

@Controller
@RequestMapping("/participant")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("participants", participantService.getAll());
		return "participant/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(model, participantService.getById(id));
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(model, new Participant());
	}

	private String goEdit(Model model, Participant participant) {
		model.addAttribute("participant", participant);
		return "participant/edit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		participantService.delete(id);
		return "redirect:/participant";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Participant participant, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(model, participant);
		}
		participantService.save(participant);
		return "redirect:/participant";
	}
}
