package net.sahet.springtech.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sahet.springtech.exception.RateNotFoundException;
import net.sahet.springtech.service.VatRateService;
import net.sahet.springtech.web.dto.Rate;
import net.sahet.springtech.web.dto.VatRateResponse;

/**
 * Vat Rate API to get Standard VAT Rates for defined criteria
 * <p>
 * Prints out three EU countries with the lowest and three EU countries with the
 * highest standard VAT rate as of today within the EU.
 *
 * @author azat satklichov
 */
@RestController
public class VatRateResource {

	@Autowired
	private VatRateService vatRateService;

	@ResponseBody
	@RequestMapping(value = "/vatRates", method = RequestMethod.GET)
	public Map<String, List<String>> getVatRates(
			@RequestParam(name = "count", required = false, defaultValue = "0") int count, Map<String, Object> model) {

		VatRateResponse response = vatRateService.process();

		List<Rate> rates = response.getRates();
		if (rates == null || rates.isEmpty()) {
			throw new RateNotFoundException("VAT Rate NOT FOUND");
		}

		List<String> vatHighestStandardRates = vatRateService.getVatStandardRates(rates, true, count);
		List<String> vatLowestStandardRates = vatRateService.getVatStandardRates(rates, false, count);

		Map<String, List<String>> mapVatRates = new HashMap<>();
		String key1 = "CountriesWithHighestStandardVATRates";
		mapVatRates.put(key1, vatHighestStandardRates);
		String key2 = "CountriesWithLowestStandardVATRates";
		mapVatRates.put(key2, vatLowestStandardRates);

		return mapVatRates;

	}

}
