package centerpark.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {

	@PostMapping("/hello")
	String sayHello(){
		return "bonjour olivier";
	}
	
	@GetMapping("/hello/{prenom}")
	String sayHello(@PathVariable("prenom") String prenom) {
		return "bonjour "+prenom.toUpperCase();
	}
	
	@GetMapping("/personne")
	public Personne getPersonne() {
		return new Personne("olivier","gozlan");
	}
	
	@GetMapping("/personnes")
	public List<Personne> getPersonnes(){
		return Arrays.asList(new Personne("olivier","gozlan",new Adresse("chez olivier")),new Personne("Mohamed","Fofana"));
	}
}
