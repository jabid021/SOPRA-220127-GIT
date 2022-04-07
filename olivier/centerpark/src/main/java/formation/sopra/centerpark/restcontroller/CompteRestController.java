package formation.sopra.centerpark.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.centerpark.exception.ClientException;
import formation.sopra.centerpark.model.Client;
import formation.sopra.centerpark.model.JsonViews;
import formation.sopra.centerpark.services.ClientService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins = "*")
public class CompteRestController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ClientService clientService;

	@PostMapping("/client/inscription")
	@JsonView(JsonViews.Common.class)
	public Client creationClient(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClientException();
		}
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		clientService.create(client);
		return client;
	}
}
