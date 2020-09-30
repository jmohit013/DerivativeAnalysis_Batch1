package com.derivative.dto;

import java.util.List;
import java.util.Set;

public class TradeEntityDto {
	
	private Long tradeId;
	
	private long userId;
	
	private String tradeProfit;
	
	private double tradeMargin;
	
	private String tradeLoss;
	
	private List<Double> breakEvenPoints;
	
	private List<PayOffCoordinates> payOffCoordinates;
	
	public TradeEntityDto() {
		// TODO Auto-generated constructor stub
	}

	public TradeEntityDto(Long tradeId, long userId, String tradeProfit, double tradeMargin, String tradeLoss,
			List<Double> breakEvenPoints, List<PayOffCoordinates> payOffCoordinates) {
		super();
		this.tradeId = tradeId;
		this.userId = userId;
		this.tradeProfit = tradeProfit;
		this.tradeMargin = tradeMargin;
		this.tradeLoss = tradeLoss;
		this.breakEvenPoints = breakEvenPoints;
		this.payOffCoordinates = payOffCoordinates;
	}

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTradeProfit() {
		return tradeProfit;
	}

	public void setTradeProfit(String tradeProfit) {
		this.tradeProfit = tradeProfit;
	}

	public double getTradeMargin() {
		return tradeMargin;
	}

	public void setTradeMargin(double tradeMargin) {
		this.tradeMargin = tradeMargin;
	}

	public String getTradeLoss() {
		return tradeLoss;
	}

	public void setTradeLoss(String tradeLoss) {
		this.tradeLoss = tradeLoss;
	}

	public List<Double> getBreakEvenPoints() {
		return breakEvenPoints;
	}

	public void setBreakEvenPoints(List<Double> breakEvenPoints) {
		this.breakEvenPoints = breakEvenPoints;
	}

	public List<PayOffCoordinates> getPayOffCoordinates() {
		return payOffCoordinates;
	}

	public void setPayOffCoordinates(List<PayOffCoordinates> payOffCoordinates) {
		this.payOffCoordinates = payOffCoordinates;
	}

	@Override
	public String toString() {
		return "TradeEntityDto [tradeId=" + tradeId + ", userId=" + userId + ", tradeProfit=" + tradeProfit
				+ ", tradeMargin=" + tradeMargin + ", tradeLoss=" + tradeLoss + ", breakEvenPoints=" + breakEvenPoints
				+ ", payOffCoordinates=" + payOffCoordinates + "]";
	}

	
	
}
