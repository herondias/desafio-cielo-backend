package br.com.cielo.desafiocielo.extrato.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cielo.desafiocielo.commons.exceptions.NotFoundBusinessExeption;
import br.com.cielo.desafiocielo.commons.utils.ResourceMessage;
import br.com.cielo.desafiocielo.constants.MessageCode;
import br.com.cielo.desafiocielo.extrato.dto.DadosBancariosDto;
import br.com.cielo.desafiocielo.extrato.dto.ExtratoDto;
import br.com.cielo.desafiocielo.extrato.dto.LancamentoDto;
import br.com.cielo.desafiocielo.extrato.entity.ControleLancamento;
import br.com.cielo.desafiocielo.extrato.repository.ExtratoRepository;

@Service
public class ExtratoServiceImpl implements ExtratoService {
	private static final long serialVersionUID = -543750780837390001L;
	
	@Autowired
	private ExtratoRepository extratoRepository;

	@Override
	public ExtratoDto findAll() {
		List<LancamentoDto> lancamentos = new ArrayList<>();
		extratoRepository.getAll().getListaControleLancamento().stream()
			.forEach(controleLancamento -> lancamentos.add(parseLancamentoDto(controleLancamento)));
		
		return new ExtratoDto(lancamentos);
	}
	
	@Override
	public LancamentoDto getByNumeroEvento(Integer numeroEvento) throws NotFoundBusinessExeption {
		Optional<ControleLancamento> controleLancamento = 
				extratoRepository.getAll().getListaControleLancamento().stream()
				.filter(ctrlLancamento -> numeroEvento.equals(ctrlLancamento.getNumeroEvento()))
				.findFirst();
		
		if(!controleLancamento.isPresent()) {
			throw new NotFoundBusinessExeption(ResourceMessage.getMessage(MessageCode.LANCAMENTO_NAO_ENCONTRADO, String.valueOf(numeroEvento)));
		} 

		return parseLancamentoDto(controleLancamento.get());			
	}

	private LancamentoDto parseLancamentoDto(ControleLancamento controleLancamento) {
		LancamentoDto lancametoDto = LancamentoDto.builder()
			.dataLancamento(controleLancamento.getDataLancamentoContaCorrenteCliente())
			.descricao(controleLancamento.getLancamentoContaCorrenteCliente().getNomeTipoOperacao())
			.situacao(controleLancamento.getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa())
			.dataConfirmacao(controleLancamento.getDataEfetivaLancamento())
			.numero(controleLancamento.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco())
			.dadosBancarios(DadosBancariosDto.builder()
				.nomeBanco(controleLancamento.getNomeBanco())
				.codigoBanco(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getCodigoBanco())
				.numeroAgencia(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia())
				.numeroContaCorrente(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente())
				.build())
			.valorFinal(controleLancamento.getValorLancamentoRemessa())
			.build();
		
		return lancametoDto;
	}
}
