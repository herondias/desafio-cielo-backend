package br.com.cielo.desafiocielo.commons.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor()
public class DetailValidationError {
	private String object;
    private String field;
    private Object rejectedValue;
    private String message;
    
    DetailValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
