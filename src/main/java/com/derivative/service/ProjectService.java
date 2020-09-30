package com.derivative.service;

import java.util.List;
import java.util.Optional;

import com.derivative.dto.PayOffCoordinates;
import com.derivative.dto.TradeEntityDto;
import com.derivative.entity.FuturesEntity;
import com.derivative.entity.OptionsEntity;
import com.derivative.entity.TradeEntity;
import com.derivative.entity.User;

public interface ProjectService {
	public double futuresProfitorLoss(FuturesEntity futuresTrades,double spotPrice);
	public TradeEntity createTrade(TradeEntity tradeSummary);
	public double optionsProfitAndLoss(OptionsEntity optionsEntity,double spotPrice);
	public double calculateMarginFutures(FuturesEntity futuresEntity);
	public boolean login(User user);
	public List<PayOffCoordinates> payOffChart(TradeEntity tradeEntity);
	public TradeEntityDto levelOne(TradeEntity tradeEntity);
	

}
