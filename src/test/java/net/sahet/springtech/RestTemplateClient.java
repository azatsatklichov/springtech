package net.sahet.springtech;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sahet.springtech.web.dto.RateRequest;
import net.sahet.springtech.web.dto.RateResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestTemplateClient {

    public static final String VATINFO_URI = "http://localhost:9999/api/rate";

    @Test
    public void testRates() throws JsonProcessingException {
		/*RateResponse rateResponse = (new RestTemplate()).getForObject(VATINFO_URI, RateResponse.class);
		// two sets of criterias
		Assert.assertEquals(2, rateResponse.getProducts().size());*/

        RestTemplate restTemplate = new RestTemplate();
        RateRequest request = new RateRequest();
        request.setAmount(4);
        request.setProduct("Adidas");
        HttpHeaders headers = getHeaders();

        HttpEntity<RateRequest> requestEntity = new HttpEntity<RateRequest>(request, headers);

		/*restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());*/

        ResponseEntity<RateResponse> rateResponse = restTemplate.exchange(VATINFO_URI, HttpMethod.POST,
                requestEntity, RateResponse.class);

        RateResponse rates = rateResponse.getBody();
        System.out.println(rateResponse.getStatusCode());

        Assert.assertEquals(200, rateResponse.getStatusCode().value());


        rates.getProducts().forEach(item -> System.out.println(item));
        System.out.println();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rates);
        System.out.println(json);

        System.out.println();
        json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rates.getProducts().get(0));
        System.out.println(json);

    }

    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
