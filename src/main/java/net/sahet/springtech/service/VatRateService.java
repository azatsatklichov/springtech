package net.sahet.springtech.service;

import java.util.List;

import net.sahet.springtech.web.dto.Rate;
import net.sahet.springtech.web.dto.VatRateResponse;

public interface VatRateService {

	// old VAT rate
	VatRateResponse process();

	/**
	 * 
	 * @param rates
	 * @param highestVat - true to choose highest standard rates, false for lowest
	 *                   rates
	 * @param count      - how many item to list out
	 * @return
	 */
	List<String> getVatStandardRates(List<Rate> rates, boolean highestVat, int count);

}
