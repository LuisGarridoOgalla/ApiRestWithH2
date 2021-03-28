package com.javaTest.javaTest.service;

import java.sql.Timestamp;

import com.javaTest.javaTest.dto.PriceResponse;

public interface PriceService {

	public PriceResponse getProduct(Timestamp date, int productIdentity, int stringIdentity);
}
