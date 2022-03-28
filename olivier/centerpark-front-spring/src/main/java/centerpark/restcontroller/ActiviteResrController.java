package centerpark.restcontroller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.id.ResultSetIdentifierConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import centerpark.exception.ActiviteException;
import centerpark.model.Activite;
import centerpark.model.JsonViews;
import centerpark.model.Safari;
import centerpark.model.Vehicule;
import centerpark.services.ActiviteService;

@RestController
@RequestMapping("/api/activite")
public class ActiviteResrController {

	@Autowired
	private ActiviteService activiteService;

	@JsonView(JsonViews.ActiviteWithVehicule.class)
	@GetMapping("")
	public List<Activite> getAll() {
		return activiteService.getAll();
	}

	@JsonView(JsonViews.ActiviteWithVehicule.class)
	@GetMapping("/{id}")
	public Activite getById(@PathVariable Integer id) {
		return activiteService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		activiteService.delete(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(JsonViews.ActiviteWithVehicule.class)
	public Activite create(@Valid @RequestBody Activite activite, BindingResult br) {
		return save(activite, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.ActiviteWithVehicule.class)
	public Activite update(@PathVariable Integer id, @Valid @RequestBody Activite activite, BindingResult br) {
		activite.setId(id);
		return save(activite, br);
	}

	private Activite save(Activite activite, BindingResult br) {
		if (br.hasErrors()) {
			throw new ActiviteException();
		}
		return activiteService.save(activite);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.ActiviteWithVehicule.class)
	public Activite partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Activite activite = activiteService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("heure")) {
				List<Integer> heureRecuperee = (List<Integer>) v;
				activite.setHeure(LocalTime.of(heureRecuperee.get(0), heureRecuperee.get(1)));
			} else if (k.equals("date")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				activite.setDate(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} else if (k.equals("vehicule")) {
				if (activite instanceof Safari) {
					String value = v.toString();

					Vehicule vehicule = new Vehicule();
					vehicule.setId(Integer.parseInt(value.substring(value.indexOf("=") + 1, value.length() - 1)));
					((Safari) activite).setVehicule(vehicule);
				}
			} else {
				Field field = ReflectionUtils.findField(Activite.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, activite, v);
			}
		});
		return activiteService.save(activite);
	}
}
