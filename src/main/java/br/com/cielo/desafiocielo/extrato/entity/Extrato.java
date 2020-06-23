package br.com.cielo.desafiocielo.extrato.entity;

import java.util.List;

import lombok.Data;

@Data
public class Extrato {

	private TotalControleLancamento totalControleLancamento;
	private List<ControleLancamento> listaControleLancamento;
	private Integer indice;
	private Integer tamanhoPagina;
	private Integer totalElements;
}
