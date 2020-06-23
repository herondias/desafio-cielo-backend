package br.com.cielo.desafiocielo.commons.helpers;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class JsonMapperHelper {
	private final ObjectMapper mapper;

	public <T> T toObject(final String pathJson, final Class<T> clazz) {
		try {
			return mapper.readValue(loadJsonFile(pathJson), clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String objectToJson(final Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public <T> List<T> toListObect(final String pathJson, final Class<T> clazz) {
		try {
			return mapper.readValue(loadJsonFile(pathJson),
					mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private URL loadJsonFile(final String pathJson) {
		return this.getClass().getClassLoader().getResource(pathJson);
	}
}
