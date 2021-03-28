package com.javaTest.javaTest.dto;



import java.io.Serializable;


public class PriceResponse implements Serializable {

	private static final long serialVersionUID = 4157045675571950543L;

	private int brandId;
	
	private String startDate;
	
	private String endDate;  
	
	private int priceList;
	
	private int productId;  
	
	private double finalPrice;
	
	public PriceResponse() {
		
	}
	
	public PriceResponse(int brandId, String startDate, String endDate, int priceList, int productId, double finalPrice) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.finalPrice = finalPrice;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brand) {
		this.brandId = brand;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPriceList() {
		return priceList;
	}

	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

}
