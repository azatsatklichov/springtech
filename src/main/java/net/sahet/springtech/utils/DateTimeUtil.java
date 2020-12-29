package net.sahet.springtech.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DateTimeUtil {

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String now() {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

		return localDate.format(formatter);
	}

	public static LocalDate getDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return LocalDate.parse(date, formatter);
	}
}
