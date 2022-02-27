package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.models.dto.ProductDTO;
import com.example.demo.models.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductService {

    @Value("${api.url}")
    public String API_URL;

    public Product getByBarcode(String barcode) {
        if (barcode == null || barcode.trim().equals("")) throw new ApiException("Barcode is invalid");
        log.trace("Calling getByBarcode with {}", barcode);

        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject("%s/%s.json".formatted(API_URL, barcode), Product.class);
        } catch (Exception ex) {
            log.error("Unable to execute rest template");
            throw new ApiException("Unable to find product", ex);
        }

    }

}
