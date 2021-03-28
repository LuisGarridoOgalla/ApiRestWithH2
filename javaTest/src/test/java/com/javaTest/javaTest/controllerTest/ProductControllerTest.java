package com.javaTest.javaTest.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.javaTest.javaTest.JavaTestApplication;
import com.javaTest.javaTest.dto.PriceResponse;

@SpringBootTest(classes = JavaTestApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	
	@Test
	void test1() throws ParseException {
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 00:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59");
		Timestamp startTimeDate = new Timestamp(startDate.getTime());
		Timestamp endTimeDate = new Timestamp(endDate.getTime());
		PriceResponse pricesResponse = new PriceResponse(1, startTimeDate.toString(), endTimeDate.toString(), 1, 35455,
				35.50);

		ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
				"/product/details?dateRange=2020-06-14 10:00&productId=35455&brandId=1", PriceResponse.class);

		assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
		assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
		assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
		assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
		assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

	}

	@Test
	void test2() throws ParseException {
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-06-14 15:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2020-06-14 18:30:00");
		Timestamp startTimeDate = new Timestamp(startDate.getTime());
		Timestamp endTimeDate = new Timestamp(endDate.getTime());
		PriceResponse pricesResponse = new PriceResponse(1, startTimeDate.toString(), endTimeDate.toString(), 2, 35455,
				25.45);

		ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
				"/product/details?dateRange=2020-06-14 16:00 &productId=35455&brandId=1", PriceResponse.class);

		assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
		assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
		assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
		assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
		assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

	}

	@Test
	void test3() throws ParseException {
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-14 00:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59");
		Timestamp startTimeDate = new Timestamp(startDate.getTime());
		Timestamp endTimeDate = new Timestamp(endDate.getTime());
		PriceResponse pricesResponse = new PriceResponse(1, startTimeDate.toString(), endTimeDate.toString(), 1, 35455,
				35.50);

		ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
				"/product/details?dateRange=2020-06-14 21:00 &productId=35455&brandId=1", PriceResponse.class);

		assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
		assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
		assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
		assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
		assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

	}

	@Test
	void test4() throws ParseException {
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 00:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 11:00:00");
		Timestamp startTimeDate = new Timestamp(startDate.getTime());
		Timestamp endTimeDate = new Timestamp(endDate.getTime());
		PriceResponse pricesResponse = new PriceResponse(1, startTimeDate.toString(), endTimeDate.toString(), 3, 35455,
				30.50);

		ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
				"/product/details?dateRange=2020-06-15 10:00 &productId=35455&brandId=1", PriceResponse.class);

		assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
		assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
		assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
		assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
		assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

	}

	@Test
	void test5() throws ParseException {
		Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-06-15 16:00:00");
		Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-12-31 23:59:59");
		Timestamp startTimeDate = new Timestamp(startDate.getTime());
		Timestamp endTimeDate = new Timestamp(endDate.getTime());
		PriceResponse pricesResponse = new PriceResponse(1, startTimeDate.toString(), endTimeDate.toString(), 4, 35455,
				38.95);

		ResponseEntity<PriceResponse> response = testRestTemplate.getForEntity(
				"/product/details?dateRange=2020-06-15 21:00 &productId=35455&brandId=1", PriceResponse.class);

		assertEquals(pricesResponse.getBrandId(), response.getBody().getBrandId());
		assertEquals(pricesResponse.getProductId(), response.getBody().getProductId());
		assertEquals(pricesResponse.getStartDate(), response.getBody().getStartDate());
		assertEquals(pricesResponse.getEndDate(), response.getBody().getEndDate());
		assertEquals(pricesResponse.getFinalPrice(), response.getBody().getFinalPrice());

	}

}
