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
import org.springframework.web.bind.annotation.RequestParam;

import centerpark.model.Activite;
import centerpark.model.Aquatique;
import centerpark.model.Participant;
import centerpark.model.Reservation;
import centerpark.model.Safari;
import centerpark.model.Statut;
import centerpark.services.ActiviteService;
import centerpark.services.ParticipantService;
import centerpark.services.ReservationService;
import centerpark.web.dto.ReservationWeb;

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
	public String addAQuatique(Model model) {
		ReservationWeb reservation = new ReservationWeb();
		model.addAttribute("activites", activiteService.getAllAquatique());
		model.addAttribute("type", "aquatique");
		return goEdit(model, reservation);
	}

	@GetMapping("/add/safari")
	public String addSafari(Model model) {
		ReservationWeb reservation = new ReservationWeb();
		model.addAttribute("activites", activiteService.getAllSafari());
		model.addAttribute("type", "safari");
		return goEdit(model, reservation);
	}

	private String goEdit(Model model, ReservationWeb reservation) {
		model.addAttribute("reservation", reservation);
		model.addAttribute("statuts", Statut.values());
		model.addAttribute("participants", participantService.getAll());
		return "reservation/edit";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Integer id) {
		Reservation reservation = reservationService.getById(id);
		ReservationWeb reservationWeb = new ReservationWeb(reservation.getId(), reservation.getDate(),
				reservation.getStatut(), reservation.getParticipant().getId(), reservation.getActivite().getId(),
				reservation.getNote());
		if (reservation.getActivite() instanceof Safari) {
			model.addAttribute("activites", activiteService.getAllSafari());
			model.addAttribute("type", "safari");
		} else {
			model.addAttribute("activites", activiteService.getAllAquatique());
			model.addAttribute("type", "aquatique");
		}
		return goEdit(model, reservationWeb);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		reservationService.delete(id);
		return "redirect:/reservation";
	}

	@PostMapping("/save")
	public String saveAquatique(Model model, @Valid @ModelAttribute ReservationWeb reservation, BindingResult br,
			@RequestParam String type) {
		if (br.hasErrors()) {
			System.out.println(br);
			return goEdit(model, reservation);
		}
//		Activite activite=null;
//		if(type.equals("aquatique")) {
//			activite=new Aquatique();
//		}else {
//			activite=new Safari();
//		}
		Activite activite = (type.equals("aquatique")) ? new Aquatique() : new Safari();
		activite.setId(reservation.getIdActivite());
		Participant participant = new Participant();
		participant.setId(reservation.getIdParticipant());
		Reservation r = new Reservation(reservation.getId(), activite, null, participant, reservation.getNote(),
				reservation.getStatut(), reservation.getDate());
		reservationService.save(r);
		return "redirect:/reservation";
	}

}
