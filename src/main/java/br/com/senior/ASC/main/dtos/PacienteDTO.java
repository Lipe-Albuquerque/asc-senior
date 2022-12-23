package br.com.senior.ASC.main.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.senior.ASC.main.model.Agendamento;
import br.com.senior.ASC.main.model.Paciente;
import br.com.senior.ASC.main.model.ENUMS.Sexo;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1l;
	
	private Integer id;
	private String name;
	private Sexo sex;
	private String email;
	private String phone;
	private String city;
	private String state;
	private String symptoms;
	private List<Agendamento> list = new ArrayList<>();
	public PacienteDTO(){
		super();
	}
	
	public PacienteDTO(Paciente obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.sex = obj.getSex();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.city = obj.getCity();
		this.state = obj.getState();
		this.symptoms = obj.getSymptoms();
		this.list = obj.getList();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public List<Agendamento> getList() {
		return list;
	}

	public void setList(List<Agendamento> list) {
		this.list = list;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sexo getSex() {
		return sex;
	}

	public void setSex(Sexo sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
