package com.derivative.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(OptionId.class)
public class Options {

	@Id
	@Column(length = 100)
	private String companyName;
	
	@Id
	@Column(length = 100)
	private String optionsCategory;

	@Id
	@Column(length = 100)
	private String optionsType; 
	
	@Id
	@Column(length = 100)
	private String underlyingAsset;

	int lotSize;
	double spotPrice;
	
	public Options() {
		// TODO Auto-generated constructor stub
	}
	
	public Options(String companyName, String optionsCategory, String optionsType,String underlyingAsset, int lotSize,
			double spotPrice) {
		super();
		this.companyName = companyName;
		this.underlyingAsset = underlyingAsset;
		this.optionsCategory = optionsCategory;
		this.optionsType = optionsType;
		this.lotSize = lotSize;
		this.spotPrice = spotPrice;
	}

	public Options(int lotSize, double spotPrice) {
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

	public String getOptionsCategory() {
		return optionsCategory;
	}

	public void setOptionsCategory(String optionsCategory) {
		this.optionsCategory = optionsCategory;
	}

	public String getOptionsType() {
		return optionsType;
	}

	public void setOptionsType(String optionsType) {
		this.optionsType = optionsType;
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
		return "Options [companyName=" + companyName + ", underlyingAsset=" + underlyingAsset + ", optionsCategory="
				+ optionsCategory + ", optionsType=" + optionsType + ", lotSize=" + lotSize + ", spotPrice=" + spotPrice
				+ "]";
	}
	
	
	
	
	
	
}
