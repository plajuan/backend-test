package br.com.pla.backend.entity;

import java.time.LocalDate;

public class Entry {
	private LocalDate data;
	private String descricao;
	private Double valor;
	private String categoria;

	public Entry(LocalDate data, String descricao, Double valor, String categoria) {
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
	}

	public LocalDate getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValor() {
		return valor;
	}

	public String getCategoria() {
		return categoria;
	}

}
