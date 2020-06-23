
package br.com.cielo.desafiocielo.extrato.entity;

import lombok.Data;

@Data
public class TotalControleLancamento {

	private int quantidadeLancamentos;
	private int quantidadeRemessas;
	private Double valorLancamentos;
}
