package com.javaTest.javaTest.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaTest.javaTest.dto.PriceResponse;
import com.javaTest.javaTest.model.Price;
import com.javaTest.javaTest.repository.PricesRepository;
import com.javaTest.javaTest.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PricesRepository repository;

	public PriceResponse getProduct(Timestamp date, int productIdentity, int stringIdentity) {
		
		List<Price> prices = new ArrayList<>();
		prices = repository.findAll();
		Price pricesEntity = prices.stream()
				.filter(p -> stringIdentity == p.getBrands().getBrandId())
				.filter(p -> productIdentity == p.getProductId())
				.filter(p -> !date.before(p.getStartDate()))
				.filter(p -> !date.after(p.getEndDate()))
				.max((Comparator.comparingInt(Price::getPriority)))
				 .orElse(null);
		
		return  mapperPriceResponse(pricesEntity);
	}
	
	private PriceResponse mapperPriceResponse(Price entityPrices){
		
		PriceResponse response = null;
		if(entityPrices!= null) {
			response = new PriceResponse();
			response.setBrandId(entityPrices.getBrands().getBrandId());
			response.setStartDate(entityPrices.getStartDate().toString());
			response.setEndDate(entityPrices.getEndDate().toString());
			response.setPriceList(entityPrices.getPriceList());
			response.setProductId(entityPrices.getProductId());
			response.setFinalPrice(entityPrices.getPrice());
		}
		return response;
	}
	

}
