package br.com.cielo.desafiocielo.commons.exceptions.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DetailErrorResponse implements Serializable{
	private static final long serialVersionUID = 9168300384822183470L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String status;
	private int statusCode;
	private String message;
	private String debugMessage;
	private List<DetailValidationError> detailValidationError;
}
