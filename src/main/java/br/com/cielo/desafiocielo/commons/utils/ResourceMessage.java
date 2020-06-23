package br.com.cielo.desafiocielo.commons.utils;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("ResourceMessage")
public class ResourceMessage {
	
	private static MessageSource messageSource;
	
	@Autowired
	public ResourceMessage(MessageSource messageSource) {
		ResourceMessage.messageSource = messageSource;
	}
	
	public static String getMessage(String code) {
		try {
			return messageSource.getMessage(code, null, Locale.getDefault());
		} catch (Exception e) {
			log.error("{}", e.getLocalizedMessage());
		}
		
		return code;
	}
	
	public static String getMessage(String code, Object ...args) {
		return MessageFormat.format(getMessage(code), args);
	}
}
