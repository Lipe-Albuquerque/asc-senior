package br.com.senior.ASC.main.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.senior.ASC.main.dtos.AgendamentoDTO;
import br.com.senior.ASC.main.model.Medico;
import br.com.senior.ASC.main.model.Paciente;
import br.com.senior.ASC.main.model.Agendamento;
import br.com.senior.ASC.main.model.ENUMS.Prioridade;
import br.com.senior.ASC.main.model.ENUMS.Status;
import br.com.senior.ASC.main.repositories.AgendamentoRepository;
import br.com.senior.ASC.main.services.exception.ObjectNotFoundException;

@Service
public class AgendamentoServices {

	@Autowired
	private AgendamentoRepository repositori;

	@Autowired
	private MedicoService serviceMedical;

	@Autowired
	private PacienteService servicePatient;

	public Agendamento findById(Integer id) {
		Optional<Agendamento> obj = repositori.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName()));
	}

	public List<Agendamento> findAll() {
		return repositori.findAll();
	}

	public Agendamento create(@Valid AgendamentoDTO obj) {

		return fromDTO(obj);
	}

	public Agendamento update(@Valid AgendamentoDTO obj) {

		findById(obj.getId());
		return fromDTO(obj);
	}

	public List<AgendamentoDTO> getByLessThan() {
		LocalDateTime agora = LocalDateTime.now();
		agora.with(LocalTime.MIN);
		return repositori.findByDateOpenBefore(LocalDateTime.now());
	}
	
	

	private Agendamento fromDTO(AgendamentoDTO obj) {

		Agendamento newObj = new Agendamento();
		newObj.setId(obj.getId());
		newObj.setDescription(obj.getDescription());
		newObj.setDateOpen(obj.getDateOpen());
		if(newObj.getDateOpen() == null) {
			newObj.setDateOpen(LocalDateTime.now());
		}
		newObj.setPriority(Prioridade.toEnum(obj.getPriority()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));

		
		Medico med = serviceMedical.findById(obj.getMedical());
		Paciente pat = servicePatient.findById(obj.getPatient());
		
		newObj.setMedical(med);
		newObj.setPatient(pat);
		
		if(newObj.getStatus().getCod().equals(2)) {
			newObj.setDateClosed(LocalDateTime.now());
		}
		
		return repositori.save(newObj);
		
	}
	
    public List<AgendamentoDTO> findByStatus(Integer status, Pageable paginacao){
        return repositori.findByStatusEquals(status, paginacao);
    }
    
  
	
}
