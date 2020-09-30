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
@Table(name="futures_trades")
public class FuturesEntity implements Serializable {
	
	@Id
	@GeneratedValue
	private int futuresId;
	
	private String companyName;
	
	private String futuresCat;
	
	private String underlyingAsset;
	
	private int lotQuantity;
	
	private double futuresPrice;
	
	private double futuresProfit;
	
	private double futuresMargin;
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tradeId")
	private TradeEntity tradeEntity;
	
	// Default Constructor //
	
	public FuturesEntity() {
		// TODO Auto-generated constructor stub
	}
	
	// Default Constructor Ends //
	
	public FuturesEntity(String companyName, String futuresCat, String underlyingAsset, int lotQuantity,
			double futuresPrice, double futuresProfit, double futuresMargin, TradeEntity tradeId) {
		super();
		this.companyName = companyName;
		this.futuresCat = futuresCat;
		this.underlyingAsset = underlyingAsset;
		this.lotQuantity = lotQuantity;
		this.futuresPrice = futuresPrice;
		this.futuresProfit = futuresProfit;
		this.futuresMargin = futuresMargin;
		this.tradeEntity = tradeId;
	}
	
	// Getters And Setters Start //

	public int getFuturesId() {
		return futuresId;
	}

	public void setFuturesId(int futuresId) {
		this.futuresId = futuresId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFuturesCat() {
		return futuresCat;
	}

	public void setFuturesCat(String futuresCat) {
		this.futuresCat = futuresCat;
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

	public double getFuturesPrice() {
		return futuresPrice;
	}

	public void setFuturesPrice(double futuresPrice) {
		this.futuresPrice = futuresPrice;
	}

	public double getFuturesProfit() {
		return futuresProfit;
	}

	public void setFuturesProfit(double futuresProfit) {
		this.futuresProfit = futuresProfit;
	}

	public double getFuturesMargin() {
		return futuresMargin;
	}

	public void setFuturesMargin(double futuresMargin) {
		this.futuresMargin = futuresMargin;
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
		return "FuturesEntity [futuresId=" + futuresId + ", companyName=" + companyName + ", futuresCat=" + futuresCat
				+ ", underlyingAsset=" + underlyingAsset + ", lotQuantity=" + lotQuantity + ", futuresPrice="
				+ futuresPrice + ", futuresProfit=" + futuresProfit + ", futuresMargin=" + futuresMargin + ", tradeId="
				+ tradeEntity + "]";
	}
	 
	
	
	

}
