package com.example.indra.service.impl;

import com.example.indra.exception.NotFoundException;
import com.example.indra.model.Price;
import com.example.indra.repository.PriceRepository;
import com.example.indra.service.interfaces.IPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("singleton")
@RequiredArgsConstructor
public class PriceServiceImpl implements IPriceService {

    private final PriceRepository priceRepository;

    @Override
    @Transactional(readOnly = true)
    public Price getByDateAndProductAndBrand(String date, Price price) {
        return priceRepository.getByDateAndProductAndBrand(price.getProduct().getId(), price.getBrand().getId(), date)
                .orElseThrow(() -> new NotFoundException("No se encontro la tarifa"));
    }

}
