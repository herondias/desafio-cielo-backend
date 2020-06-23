
package br.com.cielo.desafiocielo.extrato.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import lombok.Data;

@Data
public class ControleLancamento implements Serializable {
	private static final long serialVersionUID = -3143075316502146325L;

	private LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;
    private LocalDate dataEfetivaLancamento;
    private LocalDate dataLancamentoContaCorrenteCliente;
    private Integer numeroEvento;
    private String descricaoGrupoPagamento;
    private String codigoIdentificadorUnico;
    private String nomeBanco;
    private int quantidadeLancamentoRemessa;
    private String numeroRaizCNPJ;
    private String numeroSufixoCNPJ;
    private Double valorLancamentoRemessa;
    @JsonSerialize(using = DateSerializer.class)
    private Date dateLancamentoContaCorrenteCliente;
    @JsonSerialize(using = DateSerializer.class)
    private Date dateEfetivaLancamento;
}