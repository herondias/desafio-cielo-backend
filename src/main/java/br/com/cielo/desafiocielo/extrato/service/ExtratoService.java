package br.com.cielo.desafiocielo.extrato.service;

import java.io.Serializable;

import br.com.cielo.desafiocielo.commons.exceptions.NotFoundBusinessExeption;
import br.com.cielo.desafiocielo.extrato.dto.ExtratoDto;
import br.com.cielo.desafiocielo.extrato.dto.LancamentoDto;

public interface ExtratoService extends Serializable {
	public ExtratoDto findAll();
	public LancamentoDto getByNumeroEvento(Integer numeroEvento) throws NotFoundBusinessExeption;
}
