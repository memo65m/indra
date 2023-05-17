package com.example.indra.mapper;

import com.example.indra.dto.PriceDTO;
import com.example.indra.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "brandId", target = "brand.id")
    Price toPrice(Long productId, Long brandId);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "priceList.id", target = "priceList")
    PriceDTO priceToPriceDto(Price price);

}
