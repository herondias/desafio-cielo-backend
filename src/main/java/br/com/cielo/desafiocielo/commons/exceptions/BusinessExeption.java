package br.com.cielo.desafiocielo.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class BusinessExeption extends AbstractException {
	private static final long serialVersionUID = 7985709762004469374L;
	
	public BusinessExeption(String message) {
		super(message);
	}
}
