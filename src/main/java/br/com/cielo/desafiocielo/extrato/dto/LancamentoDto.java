package br.com.cielo.desafiocielo.extrato.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LancamentoDto {
	private LocalDate dataLancamento;
	private String descricao;
	private Long numero;
	private String situacao;
	private LocalDate dataConfirmacao;
	private DadosBancariosDto dadosBancarios;
	private Double valorFinal;
}
