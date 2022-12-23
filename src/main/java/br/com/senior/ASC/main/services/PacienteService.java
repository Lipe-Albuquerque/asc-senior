package br.com.senior.ASC.main.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.senior.ASC.main.model.Paciente;
import br.com.senior.ASC.main.model.Usuario;
import br.com.senior.ASC.main.repositories.PacienteRepository;
import br.com.senior.ASC.main.repositories.UsuarioRepository;
import br.com.senior.ASC.main.services.exception.DataIntregatyViolationException;
import br.com.senior.ASC.main.services.exception.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private PacienteRepository repository;

	public Paciente findById(Integer id) {
		Optional<Paciente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"OBJETO NÃO ENCONTRADO! ID: " + id + ", tipo: " + Paciente.class.getName()));
	}

	public Page<Paciente> findAll(Pageable paginacao) {
		return repository.findAll(paginacao);
	}

	public Page<Paciente> findSintoma(String sintoma, Pageable paginacao) {
		return repository.findBySymptoms(sintoma, paginacao);
	}

	public Paciente create(Paciente Obj) {
		if (findByCpf(Obj) != null) {
			throw new DataIntregatyViolationException("CPF já cadastrado na base de dados!");
		}
		Paciente newObj = new Paciente(null, Obj.getName(), Obj.getUsername(), Obj.getPassword(), Obj.getSex(),
				Obj.getCpf(), Obj.getEmail(), Obj.getPhone(), Obj.getStreet(), Obj.getNumberStreet(), Obj.getZipCode(),
				Obj.getCity(), Obj.getState(),Obj.getNameFather(), Obj.getNameMother(), Obj.getSymptoms(), Obj.getList());
		return repository.save(newObj);
	}

	public Paciente update(Integer id, @Valid Paciente obj) {
		Paciente oldObj = findById(id);

		if (findByCpf(obj) != null && findByCpf(obj).getId() != id) {
			throw new DataIntregatyViolationException("CPF já cadastrado na base de dados!");
		}

		oldObj.setName(obj.getName());
		oldObj.setUsername(obj.getUsername());
		oldObj.setCpf(obj.getCpf());
		oldObj.setEmail(obj.getEmail());
		oldObj.setPassword(obj.getPassword());
		oldObj.setCity(obj.getCity());
		oldObj.setList(obj.getList());
		oldObj.setNumberStreet(obj.getNumberStreet());
		oldObj.setPhone(obj.getPhone());
		oldObj.setSex(obj.getSex());
		oldObj.setSymptoms(obj.getSymptoms());
		oldObj.setState(obj.getState());
		oldObj.setStreet(obj.getStreet());
		oldObj.setZipCode(obj.getZipCode());
		return repository.save(oldObj);
	}

	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		Paciente obj = findById(id);
		if (obj.getList().size() > 0) {
			throw new DataIntregatyViolationException("O paciente possui Agendamentos, não pode ser DELETADO!!");

		}
		repository.deleteById(id);
		return !repository.existsById(id);
	}

	private Usuario findByCpf(Paciente obj) {
		Usuario objNew = userRepository.findByCPF(obj.getCpf());

		if (objNew != null) {
			return objNew;
		}
		return null;
	}

}
