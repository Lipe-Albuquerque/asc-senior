package br.com.senior.ASC.main.dtos;


import java.util.ArrayList;
import java.util.List;

import br.com.senior.ASC.main.model.Agendamento;
import br.com.senior.ASC.main.model.Medico;
import br.com.senior.ASC.main.model.ENUMS.Sexo;

public class MedicoDTO{

	private Integer id;
	
	private String name;

	private Sexo sex;
	
	private String email;

	private String phone;

	private String city;

	private String state;
	
	private String crm;
	
	private String specialty;
	
	private List<Agendamento> list = new ArrayList<>();

	public MedicoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicoDTO(Medico obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.sex = obj.getSex();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.city = obj.getCity();
		this.state = obj.getState();
		this.crm = obj.getCrm();	
		this.specialty = obj.getSpecialty();
		this.list = obj.getList();
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Integer getId() {
		return id;
	}

	public List<Agendamento> getList() {
		return list;
	}

	public void setList(List<Agendamento> list) {
		this.list = list;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getName() {
		return name;
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

	
	
	
}
