package com.javaTest.javaTest.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.javaTest.javaTest.dto.PriceResponse;
import com.javaTest.javaTest.model.Brand;
import com.javaTest.javaTest.model.Price;
import com.javaTest.javaTest.repository.PricesRepository;
import com.javaTest.javaTest.serviceImpl.PriceServiceImpl;

@SpringBootTest
class PriceServiceTest {

	@Autowired
	private PriceServiceImpl service;

	@MockBean
	private PricesRepository repository;

	@BeforeEach
	void setMockOutput() throws ParseException {
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 00:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59");
		Timestamp startTimeDate = new Timestamp(startDate.getTime());
		Timestamp endTimeDate = new Timestamp(endDate.getTime());
		Brand brand = new Brand();
		brand.setBrandId(1);
		brand.setName("ZARA");
		Price prices = new Price(brand, startTimeDate, endTimeDate, 1, 35455, 1, 35.5, "€");
		List<Price> priceList = new ArrayList<>();
		priceList.add(prices);
		when(repository.findAll()).thenReturn(priceList);
	}

	@Test
	void testGetdProduct() throws ParseException {

		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 00:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59");
		Date requestDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 10:00:00");

		Timestamp startTimeDate = new Timestamp(startDate.getTime());
		Timestamp endTimeDate = new Timestamp(endDate.getTime());
		Timestamp requestTimeDate = new Timestamp(requestDate.getTime());

		PriceResponse priceResponse = new PriceResponse(1, startTimeDate.toString(), endTimeDate.toString(), 1, 35455,35.50);

		PriceResponse response = service.getProduct(requestTimeDate, 35455, 1);

		assertEquals(priceResponse.getBrandId(), response.getBrandId());
		assertEquals(priceResponse.getStartDate(), response.getStartDate());
		assertEquals(priceResponse.getEndDate(), response.getEndDate());
		assertEquals(priceResponse.getProductId(), response.getProductId());
		assertEquals(priceResponse.getPriceList(), response.getPriceList());
		assertEquals(priceResponse.getFinalPrice(), response.getFinalPrice());

	}


}
