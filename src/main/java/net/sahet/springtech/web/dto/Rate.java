package net.sahet.springtech.web.dto;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import net.sahet.springtech.common.RateType;

@Getter
@Setter
public class Rate {

	private String name;

	private String code;

	@JsonProperty("country_code")
	private String countryCode;

	private List<Period> periods;

	public Double getStandardRate() {

		Period latest = getPeriods().stream().sorted(Comparator.comparing(Period::getEffectiveFrom))
				.skip(periods.size() - 1).findFirst().get();
		return latest.getRates().get(RateType.STANDARD.getValue());
	}

	public Double getReducedRate() {
		Period latest = getPeriods().stream().sorted(Comparator.comparing(Period::getEffectiveFrom))
				.skip(periods.size() - 1).findFirst().get();
		return latest.getRates().get(RateType.REDUCED.getValue());
	}
}