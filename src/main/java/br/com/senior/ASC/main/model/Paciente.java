package br.com.senior.ASC.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.senior.ASC.main.model.ENUMS.Sexo;

@Entity
public class Paciente extends Usuario {
	private String symptoms;
	@OneToMany(mappedBy = "patient")
	private List<Agendamento> list = new ArrayList<>();

	public Paciente() {
		super();
	}

	public Paciente(Integer id, String name, String username, String password, Sexo sex, String cpf, String email,
			String phone, String street, String numberStreet, String zipCode, String city, String state,
			String nameMother, String nameFather, String symptoms, List<Agendamento> list) {
		super(id, name, username, password, sex, cpf, email, phone, street, numberStreet, zipCode, city, state,
				nameMother, nameFather);
		this.symptoms = symptoms;
		this.list = list;
	}

	public Paciente(String symptoms, List<Agendamento> list) {
		super();
		this.symptoms = symptoms;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public List<Agendamento> getList() {
		return list;
	}

	public void setList(List<Agendamento> list) {
		this.list = list;
	}

}
