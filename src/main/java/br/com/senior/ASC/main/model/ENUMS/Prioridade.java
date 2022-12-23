package br.com.senior.ASC.main.model.ENUMS;

public enum Prioridade {

	LOW(0, "BAIXA"), MEDIUM(1, "MEDIA"), HIGH(2, "ALTA");

	private Integer cod;
	private String description;

	private Prioridade(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static Prioridade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("PRIORIDADE INVALIDA! "+ cod);
	}

}
