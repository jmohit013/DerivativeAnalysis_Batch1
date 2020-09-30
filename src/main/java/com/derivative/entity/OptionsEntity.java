package com.derivative.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="options_trade")
public class OptionsEntity implements Serializable {
	
	@Id
	@GeneratedValue
	private int optionsId;	//auto generated
	
	private String companyName;	//user input//
	
	private String optionsCat;  //user input//
	
	private String optionsType; //user input//
	
	private String underlyingAsset; //user input//
	
	private int lotQuantity;	//user input//
	
	private double strikePrice;	//user input//
	
	private double premium;	//user input//
	
	private double optionsProfit; //calculate
	
	private double optionsMargin; //calculate
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tradeId")
	private TradeEntity tradeEntity;
	
	// Default Constructor starts //
	public OptionsEntity() {
		// TODO Auto-generated constructor stub
	}
	// Default Constructor ends //
	
	
	public OptionsEntity(String companyName, String optionsCat, String optionsType, String underlyingAsset,
			int lotQuantity, double strikePrice, double premium, double optionsProfit, double optionsMargin,
			TradeEntity tradeId) {
		super();
		this.companyName = companyName;
		this.optionsCat = optionsCat;
		this.optionsType = optionsType;
		this.underlyingAsset = underlyingAsset;
		this.lotQuantity = lotQuantity;
		this.strikePrice = strikePrice;
		this.premium = premium;
		this.optionsProfit = optionsProfit;
		this.optionsMargin = optionsMargin;
		this.tradeEntity = tradeId;
	}
	
	// Getters And Setters start //
	public int getOptionsId() {
		return optionsId;
	}

	public void setOptionsId(int optionsId) {
		this.optionsId = optionsId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOptionsCat() {
		return optionsCat;
	}

	public void setOptionsCat(String optionsCat) {
		this.optionsCat = optionsCat;
	}

	public String getOptionsType() {
		return optionsType;
	}

	public void setOptionsType(String optionsType) {
		this.optionsType = optionsType;
	}

	public String getUnderlyingAsset() {
		return underlyingAsset;
	}

	public void setUnderlyingAsset(String underlyingAsset) {
		this.underlyingAsset = underlyingAsset;
	}

	public int getLotQuantity() {
		return lotQuantity;
	}

	public void setLotQuantity(int lotQuantity) {
		this.lotQuantity = lotQuantity;
	}

	public double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getOptionsProfit() {
		return optionsProfit;
	}

	public void setOptionsProfit(double optionsProfit) {
		this.optionsProfit = optionsProfit;
	}

	public double getOptionsMargin() {
		return optionsMargin;
	}

	public void setOptionsMargin(double optionsMargin) {
		this.optionsMargin = optionsMargin;
	}

	public TradeEntity getTradeEntity() {
		return tradeEntity;
	}

	public void setTradeEntity(TradeEntity tradeId) {
		this.tradeEntity = tradeId;
	}
	// Getters And Setters End // 


	@Override
	public String toString() {
		return "OptionsEntity [optionsId=" + optionsId + ", companyName=" + companyName + ", optionsCat=" + optionsCat
				+ ", optionsType=" + optionsType + ", underlyingAsset=" + underlyingAsset + ", lotQuantity="
				+ lotQuantity + ", strikePrice=" + strikePrice + ", premium=" + premium + ", optionsProfit="
				+ optionsProfit + ", optionsMargin=" + optionsMargin + ", tradeId=" + tradeEntity + "]";
	}
	
	
	

}
