package br.com.senior.ASC.main.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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

import br.com.senior.ASC.main.dtos.PacienteDTO;
import br.com.senior.ASC.main.model.Paciente;
import br.com.senior.ASC.main.services.PacienteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/patients")
public class PacienteResource {

	@Autowired
	private PacienteService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PacienteDTO> findById(@PathVariable Integer id) {
		PacienteDTO objDTO = new PacienteDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}

	@PostMapping
	public ResponseEntity<Paciente> create(@Valid @RequestBody Paciente obj) {
		Paciente newObj = service.create(obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findAll(@PageableDefault(size = 5, sort = "name", direction = Direction.ASC) Pageable paginacao) {
		List<PacienteDTO> listDTO = service.findAll(paginacao).stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PacienteDTO> update(@PathVariable Integer id, @Valid @RequestBody Paciente obj) {
		PacienteDTO newObj = new PacienteDTO(service.update(id, obj));
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping(value = "/sintoma/{sintoma}")
	public ResponseEntity<List<PacienteDTO>> sintoma(@PathVariable("sintoma") String sintoma, @PageableDefault(size = 5, sort = "name", direction = Direction.ASC) Pageable paginacao) {
		List<PacienteDTO> listDTO = service.findSintoma(sintoma,paginacao).stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
