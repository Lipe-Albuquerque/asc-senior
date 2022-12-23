package br.com.senior.ASC.main.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import br.com.senior.ASC.main.model.ENUMS.Sexo;

//tabela vai ser criada na base de dados
@Entity(name = "user_")
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "_from")
//	@NotEmpty(message = "Field required")
	private String name;

//	@NotEmpty(message = "Field requerid")
//	private Integer age;
//	@NotEmpty(message = "Field requerid")
	private String username;

//	@NotEmpty(message = "Field requerid")
	private String password;
	
	private Sexo sex;

	@CPF
//	@NotEmpty(message = "Field requerid")
	private String cpf;

//	@NotEmpty(message = "Field requerid")
	private String email;
	
//	@NotEmpty(message = "Field requerid")
	private String phone;

//	@NotEmpty(message = "Field requerid")
	private String street;

//	@NotEmpty(message = "Field requerid")
	private String numberStreet;
	
//	@NotEmpty(message = "Field requerid")
	private String zipCode;

//	@NotEmpty(message = "Field requerid")
	private String city;

//	@NotEmpty(message = "Field requerid")
	private String state;

//	@NotEmpty(message = "Field requerid")
	private String nameMother;

//	@NotEmpty(message = "Field requerid")
	private String nameFather;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String name, String username, String password, Sexo sex, String cpf, String email,
			String phone, String street, String numberStreet, String zipCode, String city, String state,
			String nameMother, String nameFather) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.cpf = cpf;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.numberStreet = numberStreet;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.nameMother = nameMother;
		this.nameFather = nameFather;
	}

	public String getNameMother() {
		return nameMother;
	}

	public void setNameMother(String nameMother) {
		this.nameMother = nameMother;
	}

	public String getNameFather() {
		return nameFather;
	}

	public void setNameFather(String nameFather) {
		this.nameFather = nameFather;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sexo getSex() {
		return sex;
	}

	public void setSex(Sexo sex) {
		this.sex = sex;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberStreet() {
		return numberStreet;
	}

	public void setNumberStreet(String numberStreet) {
		this.numberStreet = numberStreet;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

}
