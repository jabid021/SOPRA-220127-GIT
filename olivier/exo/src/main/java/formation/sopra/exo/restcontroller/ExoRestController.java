package formation.sopra.exo.restcontroller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.exo.UtilisateurException;
import formation.sopra.exo.entity.JsonViews;
import formation.sopra.exo.entity.Role;
import formation.sopra.exo.entity.Utilisateur;
import formation.sopra.exo.repositories.UtilisateurRepository;

@RestController
public class ExoRestController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@PreAuthorize("isAnonymous()")
	@JsonView(JsonViews.Common.class)
	@PostMapping("/api/inscription")
	public Utilisateur inscriptionUtilisateur(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		return inscription(utilisateur, br, false);
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("/api/inscription/admin")
	public Utilisateur inscriptionAdmin(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		return inscription(utilisateur, br, true);
	}

	private Utilisateur inscription(Utilisateur utilisateur, BindingResult br, boolean admin) {
		if (br.hasErrors()) {
			throw new UtilisateurException();
		}
		Set<Role> roles = new HashSet(Arrays.asList(Role.ROLE_USER));
		if (admin) {
			roles.add(Role.ROLE_ADMIN);
		}
		utilisateur.setRoles(roles);
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		return utilisateurRepo.save(utilisateur);
	}

	@GetMapping("/api/hello")
	public String hello(@AuthenticationPrincipal Utilisateur utilisateur  ) {
		return "hello "+utilisateur.getLogin();
	}

	@GetMapping("/api/admin")
	public String admin() {
		return "admin";
	}

}
