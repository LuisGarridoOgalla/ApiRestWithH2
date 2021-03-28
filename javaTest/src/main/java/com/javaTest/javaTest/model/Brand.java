package com.javaTest.javaTest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BRANDS")
public class Brand {
	
	@Id
	@Column(name="BRAND_ID")
	int BrandId;
	
	String name;
	
	@OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
    private Set<Price> prices = new HashSet<Price>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Price> getPrices() {
		return prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices =  prices;
	}

	public int getBrandId() {
		return BrandId;
	}

	public void setBrandId(int brandId) {
		BrandId = brandId;
	}
	
	
}
