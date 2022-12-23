package br.com.senior.ASC.main.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.ASC.main.dtos.MedicoDTO;
import br.com.senior.ASC.main.model.Medico;
import br.com.senior.ASC.main.services.MedicoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/medicals")
public class MedicoResource {

	@Autowired
	private MedicoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicoDTO> findById(@PathVariable Integer id) {
		MedicoDTO objDTO = new MedicoDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> findAll() {

		List<MedicoDTO> listDTO = service.findAll().stream().map(obj -> new MedicoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	

	@PostMapping
	public ResponseEntity<Medico> create(@Valid @RequestBody Medico obj) {
		Medico newObj = service.create(obj);

		return ResponseEntity.ok().body(newObj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MedicoDTO> update(@PathVariable Integer id, @Valid @RequestBody Medico obj) {
		MedicoDTO newObj = new MedicoDTO(service.update(id, obj));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/findByEspecialidade/{especialidade}")
	public List<Medico> findByEspecialidade(@PathVariable("especialidade") String especialidade) {
		return service.findByEspecialidade(especialidade);
	}

}
