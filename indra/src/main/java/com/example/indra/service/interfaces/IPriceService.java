package com.example.indra.service.interfaces;

import com.example.indra.model.Price;

public interface IPriceService {

    Price getByDateAndProductAndBrand(String date, Price price);

}
