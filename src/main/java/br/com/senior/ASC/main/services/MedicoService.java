package br.com.senior.ASC.main.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.senior.ASC.main.model.Medico;
import br.com.senior.ASC.main.model.Usuario;
import br.com.senior.ASC.main.repositories.MedicoRepository;
import br.com.senior.ASC.main.repositories.UsuarioRepository;
import br.com.senior.ASC.main.services.exception.DataIntregatyViolationException;
import br.com.senior.ASC.main.services.exception.ObjectNotFoundException;

@Service
public class MedicoService {
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private MedicoRepository repository;
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("OBJETO NÃO ENCONTRADO! ID: " + id + ", tipo: " + Medico.class.getName()));
	}
	
	public List<Medico> findAll() {
		return repository.findAll();
	}
	
	public Medico create(Medico Obj) {
		if(findByCpf(Obj) != null) {
			throw new DataIntregatyViolationException("CPF já cadastrado na base de dados!");
		}
		Medico newObj = new Medico(null, Obj.getName(), Obj.getUsername(), Obj.getPassword(), Obj.getSex(), Obj.getCpf(),Obj.getEmail(),Obj.getPhone(),Obj.getStreet(),Obj.getNumberStreet(),
				Obj.getZipCode(),Obj.getCity(),Obj.getState(),  Obj.getNameMother(),  Obj.getNameFather() , Obj.getCrm(),Obj.getSpecialty());
		return repository.save(newObj);
	}
	
	
	public Medico update(Integer id, @Valid Medico obj) {
		Medico oldObj = findById(id);
		
		if(findByCpf(obj)!= null && findByCpf(obj).getId() != id) {
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
		oldObj.setSpecialty(obj.getSpecialty());
		oldObj.setState(obj.getState());
		oldObj.setStreet(obj.getStreet());
		oldObj.setZipCode(obj.getZipCode());
		oldObj.setCrm(obj.getCrm());
		return repository.save(oldObj);
	}
	

	
	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		Medico obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new DataIntregatyViolationException("Medico possui Agendamentos, não pode ser DELETADO!!");

		}
		repository.deleteById(id);
		return !repository.existsById(id);
	}
	
    public List<Medico> findByEspecialidade(String especialidade){
        return repository.findBySpecialtyEquals(especialidade);
    }

	
	
	private Usuario findByCpf(Medico obj) {
		Usuario objNew = userRepository.findByCPF(obj.getCpf());
		
		if(objNew != null) {
			return objNew;
		}
		return null;
	}
	
	
}
