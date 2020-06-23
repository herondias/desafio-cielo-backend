
package br.com.cielo.desafiocielo.extrato.entity;

import lombok.Data;

@Data
public class LancamentoContaCorrenteCliente {

	private Long numeroRemessaBanco;
	private String nomeSituacaoRemessa;
	private DadosDomicilioBancario dadosDomicilioBancario;
	private String nomeTipoOperacao;
}
