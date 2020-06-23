package br.com.cielo.desafiocielo.extrato.entity;

import lombok.Data;

@Data
public class DadosDomicilioBancario {

	private Integer codigoBanco;
	private Integer numeroAgencia;
	private String numeroContaCorrente;
}