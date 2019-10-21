package net.sahet.springtech.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RateResponse {

    private List<Product> products;

}
