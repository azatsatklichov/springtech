package net.sahet.springtech.web.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents incoming request via like json file(request)
 * https://euvatrates.com/rates.json
 *
 */
@Getter
@Setter
public class VatRateResponse {

	private String details;

	private String version;

	private List<Rate> rates;

}
