package com.derivative.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(FutureId.class)
public class Futures {

	@Id
	@Column(length = 100)
	private String companyName;

	@Id
	@Column(length = 100)
	private String underlyingAsset;

	@Id
	@Column(length = 100)
	private String futuresCategory;

	int lotSize;
	double spotPrice;
	
	public Futures() {
		// TODO Auto-generated constructor stub
	}

	public Futures(String companyName, String underlyingAsset, String futuresCategory, int lotSize, double spotPrice) {
		super();
		this.companyName = companyName;
		this.underlyingAsset = underlyingAsset;
		this.futuresCategory = futuresCategory;
		this.lotSize = lotSize;
		this.spotPrice = spotPrice;
	}

	public Futures(int lotSize, double spotPrice) {
		super();
		this.lotSize = lotSize;
		this.spotPrice = spotPrice;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUnderlyingAsset() {
		return underlyingAsset;
	}

	public void setUnderlyingAsset(String underlyingAsset) {
		this.underlyingAsset = underlyingAsset;
	}

	public String getFuturesCategory() {
		return futuresCategory;
	}

	public void setFuturesCategory(String futuresCategory) {
		this.futuresCategory = futuresCategory;
	}

	public int getLotSize() {
		return lotSize;
	}

	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}

	public double getSpotPrice() {
		return spotPrice;
	}

	public void setSpotPrice(double spotPrice) {
		this.spotPrice = spotPrice;
	}

	@Override
	public String toString() {
		return "Futures [companyName=" + companyName + ", underlyingAsset=" + underlyingAsset + ", futuresCategory="
				+ futuresCategory + ", lotSize=" + lotSize + ", spotPrice=" + spotPrice + ", getCompanyName()="
				+ getCompanyName() + ", getUnderlyingAsset()=" + getUnderlyingAsset() + ", getFuturesCategory()="
				+ getFuturesCategory() + ", getLotSize()=" + getLotSize() + ", getSpotPrice()=" + getSpotPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
