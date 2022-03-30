package centerpark.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import centerpark.exception.VehiculeException;
import centerpark.model.JsonViews;
import centerpark.model.Vehicule;
import centerpark.services.VehiculeService;

@RestController
@RequestMapping("/api/vehicule")
public class VehiculeRestController {

	@Autowired
	private VehiculeService vehiculeService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Vehicule> getAll() {
		return vehiculeService.getAll();
	}
	
	@JsonView(JsonViews.VehiculeWithSafari.class)
	@GetMapping("/{id}/safaris")
	public Vehicule getByIdWithSafari(@PathVariable Integer id) {
		return vehiculeService.getByIdWithSafari(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Vehicule getById(@PathVariable Integer id) {
		return vehiculeService.getById(id);
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Vehicule create(@Valid @RequestBody Vehicule vehicule, BindingResult br) {
		return createOrUpdate(vehicule, br);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Vehicule update(@PathVariable Integer id, @Valid @RequestBody Vehicule vehicule, BindingResult br) {
		vehicule.setId(id);
		return createOrUpdate(vehicule, br);
	}

	private Vehicule createOrUpdate(Vehicule vehicule, BindingResult br) {
		if (br.hasErrors()) {
			throw new VehiculeException();
		}
		return vehiculeService.save(vehicule);
	}
	
	@JsonView(JsonViews.Common.class)
	@PatchMapping("/{id}")
	public Vehicule PartialUpdate(@RequestBody Map<String, Object> fields,@PathVariable Integer id) {
		Vehicule vehicule=vehiculeService.getById(id);
		fields.forEach((key,value)->{
			//si type simple
			Field field=  ReflectionUtils.findField(Vehicule.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, vehicule, value);	
		});
		return vehiculeService.save(vehicule);	
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		vehiculeService.delete(id);
	}
	
}
