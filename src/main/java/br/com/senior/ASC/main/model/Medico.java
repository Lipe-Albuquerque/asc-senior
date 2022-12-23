package br.com.senior.ASC.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senior.ASC.main.model.ENUMS.Sexo;

@Entity
public class Medico extends Usuario {
	private String specialty;
	private String crm;
	@JsonIgnore
	@OneToMany(mappedBy = "medical") // um para muitos
	private List<Agendamento> list = new ArrayList<>();
	


	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addList(Agendamento obj) {
		list.add(obj);
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Medico(String specialty, List<Agendamento> list, String crm) {
		super();
		this.specialty = specialty;
		this.crm = crm;
	}

	public Medico(Integer id, String name, String username, String password, Sexo sex, String cpf, String email,
			String phone, String street, String numberStreet, String zipCode, String city, String state,
			String nameMother, String nameFather, String crm, String specialty) {
		super(id, name, username, password, sex, cpf, email, phone, street, numberStreet, zipCode, city, state, nameMother,
				nameFather);
		// TODO Auto-generated constructor stub
		this.specialty = specialty;
		this.crm = crm;	
	}
	
	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	public List<Agendamento> getList() {
		return list;
	}

	public void setList(List<Agendamento> list) {
		this.list = list;
	}
	
	
}
