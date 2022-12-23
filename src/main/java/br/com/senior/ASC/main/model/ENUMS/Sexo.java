package br.com.senior.ASC.main.model.ENUMS;

public enum Sexo {
	
	M(0, "MASCULINO"), F(1, "FEMININO"), O(2, "OUTROS");
	private Integer cod;
	private String description;

	private Sexo(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Sexo toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Sexo x : Sexo.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("SEXO INVALIDO! "+ cod);
	}

}
