package br.com.cielo.desafiocielo.extrato.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExtratoDto {
	private List<LancamentoDto> lancamentos;
}
