package br.com.cielo.desafiocielo.extrato.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class DadosBancariosDto {
	private String nomeBanco;
	private int codigoBanco;
	private int numeroAgencia;
    private String numeroContaCorrente;
}
