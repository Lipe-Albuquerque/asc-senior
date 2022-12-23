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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.ASC.main.dtos.AgendamentoDTO;
import br.com.senior.ASC.main.services.AgendamentoServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/scheduling")
public class AgendamentoResource {

	@Autowired
	private AgendamentoServices services;
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<AgendamentoDTO> findById(@PathVariable Integer id) {
		AgendamentoDTO obj = new AgendamentoDTO(services.findById(id));

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<AgendamentoDTO>> findAll() {
		List<AgendamentoDTO> list = services.findAll().stream().map(obj -> new AgendamentoDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<AgendamentoDTO> create(@Valid @RequestBody AgendamentoDTO obj) {
		obj = new AgendamentoDTO(services.create(obj));
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping
	public ResponseEntity<AgendamentoDTO> update(@Valid @RequestBody AgendamentoDTO obj) {
		obj = new AgendamentoDTO(services.update(obj));
		return ResponseEntity.ok().body(obj);

	}
	
	@GetMapping(value = "/lessthan")
	public ResponseEntity<List<AgendamentoDTO>> getByLessThan() {
		
		return ResponseEntity.ok().body(services.getByLessThan());
	}
	
	@GetMapping("/findByStatusEquals/{status}")
    public List<AgendamentoDTO> findByStatusId(@PathVariable("status")Integer status, @PageableDefault(size = 5, direction = Direction.ASC) Pageable paginacao){
        return services.findByStatus(status, paginacao);
    }
	
	



}
