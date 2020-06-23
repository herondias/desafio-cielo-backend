package br.com.cielo.desafiocielo.commons.handlers;

import java.time.LocalDateTime;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.cielo.desafiocielo.commons.exceptions.BusinessExeption;
import br.com.cielo.desafiocielo.commons.exceptions.NotFoundBusinessExeption;
import br.com.cielo.desafiocielo.commons.exceptions.response.DetailErrorResponse;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinessExeption.class)
	public final ResponseEntity<Object> handlerException(final BusinessExeption ex, final WebRequest request) {
		val body = DetailErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.status(HttpStatus.UNPROCESSABLE_ENTITY.name())
				.statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.build();
		
		log.error("{}", body);
		log.error("{}", ex);
		
		return this.handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
	
	@ExceptionHandler(NotFoundBusinessExeption.class)
	public final ResponseEntity<Object> handlerException(final NotFoundBusinessExeption ex, final WebRequest request) {
		val body = DetailErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.status(HttpStatus.NOT_FOUND.name())
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build();
		
		log.error("{}", body);
		log.error("{}", ex);
		
		return this.handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({ IllegalArgumentException.class, IllegalStateException.class, JsonParseException.class, JsonMappingException.class })
	public final ResponseEntity<Object> handlerException(final RuntimeException ex, final WebRequest request) {
		val body = DetailErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.name())
				.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.build();
		
		log.error("{}", body);
		log.error("{}", ex);
		
		return this.handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public final ResponseEntity<Object> handlerException(final MethodArgumentTypeMismatchException ex, final WebRequest request) {
		val body = DetailErrorResponse.builder()
				.timestamp(LocalDateTime.now())
				.message(ex.getMessage())
				.debugMessage(ExceptionUtils.getStackTrace(ex))
				.status(HttpStatus.BAD_REQUEST.name())
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.build();
		
		log.error("{}", body);
		log.error("{}", ex);
		
		return this.handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	
}
