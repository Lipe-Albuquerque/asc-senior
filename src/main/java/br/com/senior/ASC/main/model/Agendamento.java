package br.com.senior.ASC.main.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senior.ASC.main.model.ENUMS.Prioridade;
import br.com.senior.ASC.main.model.ENUMS.Status;

@Entity
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateOpen;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateClosed;
	
	@NotEmpty(message = "Field requerid")
	private String description;
	private Integer priority;
	private Integer status;
	@ManyToOne // muitos pra um
	@JoinColumn(name = "medical_id")
	private Medico medical;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Paciente patient;

	public Agendamento() {
		super();
		this.setDateOpen(LocalDateTime.now()); // sempre que um agendamento for iniciado, ira receber a data e hora da
												// criação
		this.setPriority(Prioridade.LOW); // por padrão será criada como prioridade baixa
		this.setStatus(Status.OPEN); // e se ela foi criada por padrão ela esta iniciada
	}

	public Agendamento(Integer id, LocalDateTime dataOpen, String description, Prioridade priority, Status status, Medico medical,
			Paciente patient) {
		super();
		this.id = id;
		if (dataOpen == null) {
			this.setDateOpen(LocalDateTime.now()); 
		}else {
			this.dateOpen = dataOpen;
		}
		this.description = description;
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.status = (status == null) ? 0 : status.getCod();
		this.medical = medical;
		this.patient = patient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(LocalDateTime dateOpen) {
		this.dateOpen = dateOpen;
	}

	public LocalDateTime getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(LocalDateTime dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Prioridade getPriority() {
		return Prioridade.toEnum(this.priority);
	}

	public void setPriority(Prioridade priority) {
		this.priority = priority.getCod();
	}

	public Status getStatus() {
		return Status.toEnum(status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Medico getMedical() {
		return medical;
	}

	public void setMedical(Medico medical) {
		this.medical = medical;
	}

	public Paciente getPatient() {
		return patient;
	}

	public void setPatient(Paciente patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}

}
