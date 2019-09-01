package br.com.pla.backend.entity;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Entry {
	private final int DATA_POS = 0;
	private final int DESCRICAO_POS = 1;
	private final int VALOR_POS = 2;
	private final int CATEGORIA_POS = 3;

	private LocalDate data;
	private String descricao;
	private Double valor;
	private String categoria;
	private DecimalFormat real = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"));
	private DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().parseCaseSensitive()
			.appendPattern("d-MMM-yyyy").toFormatter(Locale.ENGLISH);

	public Entry(LocalDate data, String descricao, Double valor, String categoria) {
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
	}

	public Entry(String[] line) {
		this.data = LocalDate.parse(line[DATA_POS] + "-2019", dateFormat);
		this.descricao = line[DESCRICAO_POS];
		this.valor = 0.0;
		try {
			this.valor = real.parse(line[VALOR_POS]).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.categoria = line.length == 4 ? this.categoria = line[CATEGORIA_POS] : "";
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
