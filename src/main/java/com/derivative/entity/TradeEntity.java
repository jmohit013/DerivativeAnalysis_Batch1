package com.derivative.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="trade_summary")
public class TradeEntity {
	
	@Id
	@GeneratedValue
	private Long tradeId;
	
	private long userId;
	
	private double tradeProfit;
	
	private double tradeMargin;
	
	private double tradePremium;
	
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY, mappedBy = "tradeEntity")
	private Set<FuturesEntity> futuresTrade;
	
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY, mappedBy = "tradeEntity")
	private Set<OptionsEntity> optionsTrade;
	
	// Default Constructor //
	public TradeEntity() {
		// TODO Auto-generated constructor stub
	}
	// Default Constructor Ends //
	
	public TradeEntity(long userId, double tradeProfit, double tradeMargin, double tradePremium) {
		super();
		this.userId = userId;
		this.tradeProfit = tradeProfit;
		this.tradeMargin = tradeMargin;
		this.tradePremium = tradePremium;
	}
	public TradeEntity(long userId, double tradeProfit, double tradeMargin, double tradePremium,
			Set<FuturesEntity> futuresTrade, Set<OptionsEntity> optionsTrade) {
		super();
		this.userId = userId;
		this.tradeProfit = tradeProfit;
		this.tradeMargin = tradeMargin;
		this.tradePremium = tradePremium;
		this.futuresTrade = futuresTrade;
		this.optionsTrade = optionsTrade;
	}
	
	
	// Getters And Setters Start //
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

	public double getTradeProfit() {
		return tradeProfit;
	}

	public void setTradeProfit(double tradeProfit) {
		this.tradeProfit = tradeProfit;
	}

	public double getTradeMargin() {
		return tradeMargin;
	}

	public void setTradeMargin(double tradeMargin) {
		this.tradeMargin = tradeMargin;
	}

	public double getTradePremium() {
		return tradePremium;
	}

	public void setTradePremium(double tradePremium) {
		this.tradePremium = tradePremium;
	}

	public Set<FuturesEntity> getFuturesTrade() {
		return futuresTrade;
	}

	public void setFuturesTrade(Set<FuturesEntity> futuresTrade) {
		this.futuresTrade = futuresTrade;
	}

	public Set<OptionsEntity> getOptionsTrade() {
		return optionsTrade;
	}

	public void setOptionsTrade(Set<OptionsEntity> optionsTrade) {
		this.optionsTrade = optionsTrade;
	}
	// Getters And Setters End //

	@Override
	public String toString() {
		return "TradeEntity [tradeId=" + tradeId + ", userId=" + userId + ", tradeProfit=" + tradeProfit
				+ ", tradeMargin=" + tradeMargin + ", tradePremium=" + tradePremium + ", futuresTrade=" + futuresTrade
				+ ", optionsTrade=" + optionsTrade + "]";
	}
	
	
}
