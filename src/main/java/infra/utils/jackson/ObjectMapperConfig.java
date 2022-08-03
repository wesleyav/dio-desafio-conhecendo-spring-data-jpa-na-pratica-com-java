package infra.utils.jackson;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.SerializationFeature;

import infra.utils.jackson.deser.LocalDateDeserializer;
import infra.utils.jackson.deser.LocalDateTimeDeserializer;
import infra.utils.jackson.ser.LocalDateSerializer;
import infra.utils.jackson.ser.LocalDateTimeSerializer;

public class ObjectMapperConfig implements Jackson2ObjectMapperBuilderCustomizer {

	@Override
	public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
		jacksonObjectMapperBuilder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.serializerByType(LocalDate.class, new LocalDateSerializer())
				.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer())
				.deserializerByType(LocalDate.class, new LocalDateDeserializer())
				.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer());
	}

}
