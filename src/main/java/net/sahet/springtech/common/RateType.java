package net.sahet.springtech.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum RateType {
	STANDARD("standard"), 
	REDUCED("reduced"), 
	REDUCED1("reduced1"),
	REDUCED2("reduced2"), 
	SUPER_REDUCED("super_reduced");

	private String value;

	RateType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	public static List<String> stringValues() {
		return Arrays.stream(values()).map(RateType::getValue).collect(Collectors.toList());
	}
}