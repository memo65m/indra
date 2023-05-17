package com.example.indra.controller;

import com.example.indra.dto.PriceDTO;
import com.example.indra.dto.ResponseDTO;
import com.example.indra.mapper.PriceMapper;
import com.example.indra.model.Price;
import com.example.indra.service.interfaces.IPriceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {

    private final IPriceService iPriceService;
    private final PriceMapper priceMapper;

    @Operation(summary = "Get rate.")
    @GetMapping("/rate")
    public ResponseEntity<ResponseDTO> getRate(
            @RequestParam @DateTimeFormat(pattern = "dd HH:mm") String date,
            @RequestParam Long productId,
            @RequestParam Long brandId) {

        Price price = priceMapper.toPrice(productId, brandId);
        PriceDTO priceDTO = priceMapper.priceToPriceDto(iPriceService.getByDateAndProductAndBrand(date, price));

        return new ResponseEntity<>(
                ResponseDTO
                        .builder()
                        .code(HttpStatus.OK.value())
                        .message("Obtener tarifa!")
                        .value(priceDTO)
                        .build(),
                HttpStatus.OK);
    }

}
