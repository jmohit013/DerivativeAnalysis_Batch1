package com.derivative.dto;

public class PayOffCoordinates {
	
	private double spotPrice;
	private double profitOrLoss;
	
	public PayOffCoordinates() {
		// TODO Auto-generated constructor stub
	}

	public PayOffCoordinates(double spotPrice, double profitOrLoss) {
		super();
		this.spotPrice = spotPrice;
		this.profitOrLoss = profitOrLoss;
	}

	public double getSpotPrice() {
		return spotPrice;
	}

	public void setSpotPrice(double spotPrice) {
		this.spotPrice = spotPrice;
	}

	public double getProfitOrLoss() {
		return profitOrLoss;
	}

	public void setProfitOrLoss(double profitOrLoss) {
		this.profitOrLoss = profitOrLoss;
	}

	@Override
	public String toString() {
		return "PayOffCoordinates [spotPrice=" + spotPrice + ", profitOrLoss=" + profitOrLoss + "]";
	}
	
	
	

}
