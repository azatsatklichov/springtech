package net.sahet.springtech.common;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import net.sahet.springtech.utils.DateTimeUtil;

public class CustomDateSerializer extends JsonSerializer<LocalDate> {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimeUtil.DATE_FORMAT);

	@Override
	public void serialize(LocalDate value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		jsonGenerator.writeString(value.format(formatter));
	}
}