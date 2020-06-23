package br.com.cielo.desafiocielo.extrato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.desafiocielo.commons.exceptions.NotFoundBusinessExeption;
import br.com.cielo.desafiocielo.extrato.dto.ExtratoDto;
import br.com.cielo.desafiocielo.extrato.dto.LancamentoDto;
import br.com.cielo.desafiocielo.extrato.service.ExtratoService;

@RestController
@RequestMapping("v1/extrato")
public class ExtratoController {
	@Autowired
	private ExtratoService extratoService;
	
	@GetMapping
	public ResponseEntity<ExtratoDto> getAll() {
		return ResponseEntity.ok(this.extratoService.findAll()) ;
	}
	
	@GetMapping("lancamento/{numeroEvento}")
	public ResponseEntity<LancamentoDto> getByNumeroEvento(@PathVariable(name = "numeroEvento", required = true) Integer numeroEvento) throws NotFoundBusinessExeption {
		LancamentoDto lancamentoDto = this.extratoService.getByNumeroEvento(numeroEvento);
		return ResponseEntity.ok(lancamentoDto);
	}
}
