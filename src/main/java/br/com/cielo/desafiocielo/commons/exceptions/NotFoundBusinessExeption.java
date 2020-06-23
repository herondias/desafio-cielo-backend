package br.com.cielo.desafiocielo.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundBusinessExeption extends AbstractException {
	private static final long serialVersionUID = 294224661215850821L;
	
	public NotFoundBusinessExeption(String message) {
		super(message);
	}
}
