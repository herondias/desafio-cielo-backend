package br.com.cielo.desafiocielo.extrato.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cielo.desafiocielo.commons.helpers.JsonMapperHelper;
import br.com.cielo.desafiocielo.extrato.entity.Extrato;

@Repository
public class ExtratoRepositoryImpl implements ExtratoRepository {
	@Autowired
	private JsonMapperHelper jsonMapperHelper;
	
	@Override
	public Extrato getAll() {
		return this.jsonMapperHelper.toObject("data/lancamento-conta-legado.json", Extrato.class);
	}

}
