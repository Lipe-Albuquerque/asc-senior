package br.com.senior.ASC.main.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.senior.ASC.main.model.Agendamento;

public class AgendamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateOpen;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dateClosed;
	
	@NotEmpty(message = "Field requerid")
	private String description;
	private Integer priority;
	private Integer status;
	private Integer medical;
	private Integer patient;

	public AgendamentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgendamentoDTO(Agendamento obj) {
		super();
		this.id = obj.getId();
		this.dateOpen = obj.getDateOpen();
		this.dateClosed = obj.getDateClosed();
		this.description = obj.getDescription();
		this.priority = obj.getPriority().getCod();
		this.status = obj.getStatus().getCod();
		this.medical = obj.getMedical().getId();
		this.patient = obj.getPatient().getId();
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMedical() {
		return medical;
	}

	public void setMedical(Integer medical) {
		this.medical = medical;
	}

	public Integer getPatient() {
		return patient;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

}
