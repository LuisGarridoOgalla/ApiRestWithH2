package com.javaTest.javaTest.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.javaTest.javaTest.dto.PriceResponse;
import com.javaTest.javaTest.service.PriceService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	static private String FORMAT_DATE = "yyyy-MM-dd HH:mm";

	@Autowired
	PriceService priceService;
	
	@RequestMapping(value="/details",method = RequestMethod.GET)
    private ResponseEntity<PriceResponse> getProductByDateAndId(@RequestParam String dateRange,
    		@RequestParam int productId,
    		@RequestParam int brandId) throws Exception {
		Date date= new SimpleDateFormat(FORMAT_DATE).parse(dateRange);
		Timestamp timeDate = new Timestamp(date.getTime());
		PriceResponse pricesResponse =priceService.getProduct(timeDate, productId, brandId);
		if(pricesResponse==null) {
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Some data not found",null);
		}
		return new ResponseEntity<>(pricesResponse, HttpStatus.OK);
    }
	
}
