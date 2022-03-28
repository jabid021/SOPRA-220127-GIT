package centerpark.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import centerpark.model.Aquatique;
import centerpark.model.Reservation;
import centerpark.model.Statut;
import centerpark.services.ActiviteService;
import centerpark.services.ParticipantService;
import centerpark.services.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ParticipantService participantService;
	@Autowired
	private ActiviteService activiteService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("reservations", reservationService.getAll());
		return "reservation/list";
	}

	@GetMapping("/add/aquatique")
	public String add(Model model) {
		Reservation reservation=new Reservation();
		reservation.setActivite(new Aquatique());
		model.addAttribute("activites", activiteService.getAllAquatique());
		return goEdit(model, reservation);
	}
	
	

	private String goEdit(Model model, Reservation reservation) {
		model.addAttribute("reservation", reservation);
		model.addAttribute("statuts", Statut.values());
		model.addAttribute("participants", participantService.getAll());
		return "reservation/edit";
	}

	@GetMapping("/edit")
	public String edit(Model model, Integer id) {
		return null;
	}

	@GetMapping("/delete")
	public String delete(Integer id) {
		return null;
	}

	@PostMapping("/save")
	public String save(Model model, @Valid @ModelAttribute Reservation reservation, BindingResult br) {
		if (br.hasErrors()) {
			System.out.println(br);
			return goEdit(model, reservation);
		}
		reservationService.save(reservation);
		return "redirect:/reservation";
	}

}
