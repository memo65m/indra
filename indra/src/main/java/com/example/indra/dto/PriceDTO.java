package com.example.indra.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PriceDTO {
    private Long productId;
    private Long brandId;
    private Long priceList;
    private String startDate;
    private String endDate;
    private BigDecimal price;
}
