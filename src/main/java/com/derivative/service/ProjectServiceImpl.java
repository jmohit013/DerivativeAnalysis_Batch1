package com.derivative.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derivative.dto.PayOffCoordinates;
import com.derivative.dto.TradeEntityDto;
import com.derivative.entity.FutureId;
import com.derivative.entity.Futures;
import com.derivative.entity.FuturesEntity;
import com.derivative.entity.OptionId;
import com.derivative.entity.Options;
import com.derivative.entity.OptionsEntity;
import com.derivative.entity.TradeEntity;
import com.derivative.entity.User;
import com.derivative.repo.FuturesRepository;
import com.derivative.repo.OptionsRepository;
import com.derivative.repo.TradeRepo;
import com.derivative.repo.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	TradeRepo tradeRepo;
	
	@Autowired
	FuturesRepository futuresrepo;
	
	@Autowired
	OptionsRepository optionsrepo;
	
	@Autowired
	UserRepository userrepo;
	
	
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return (user.getPassword().equals(userrepo.findByName(user.getName()).get().getPassword()));
	}
	
	@Override
	public double futuresProfitorLoss(FuturesEntity futuresEntity,double spotPrice) {
		String compname = futuresEntity.getCompanyName();
		String underasset = futuresEntity.getUnderlyingAsset();
		String category = futuresEntity.getFuturesCat();
		
		FutureId ft = new FutureId(compname, underasset, category);
		Optional<Futures> fut = futuresrepo.findById(ft);
		
		double spotPriceTemp = spotPrice; 
		int lotSizeTemp = fut.get().getLotSize();
		int lotQuantityTemp = futuresEntity.getLotQuantity();

		double futuresPriceTemp = futuresEntity.getFuturesPrice();
		
		if(category.equals("Long")) {
			return lotQuantityTemp*lotSizeTemp*(spotPriceTemp-futuresPriceTemp);
		}else if(category.equals("Short")){
			return (lotQuantityTemp*lotSizeTemp*(futuresPriceTemp-spotPriceTemp));
		}else {
			return 0;
		}
	}
	
	@Override
	public double calculateMarginFutures(FuturesEntity futuresEntity) {
		// TODO Auto-generated method stub
		String compname = futuresEntity.getCompanyName();
		String underasset = futuresEntity.getUnderlyingAsset();
		String category = futuresEntity.getFuturesCat();
		FutureId ft = new FutureId(compname, underasset, category);
		Optional<Futures> fut = futuresrepo.findById(ft);
		
		int lotSizeTemp = fut.get().getLotSize();
		int lotQuantityTemp = futuresEntity.getLotQuantity();
		double futuresPriceTemp = futuresEntity.getFuturesPrice();
		
		
		if(category.equals("Long")) {
			return lotSizeTemp*lotQuantityTemp*futuresPriceTemp*0.2;
			
		}else if(category.equals("Short")){
			return lotSizeTemp*lotQuantityTemp*futuresPriceTemp*0.2;
			
		}else {
			return 0.0;
		}
		
	}
	
	@Override
	public double optionsProfitAndLoss(OptionsEntity optionsEntity,double spotPrice) {
		// TODO Auto-generated method stub
		
		String compname = optionsEntity.getCompanyName();
		String underasset = optionsEntity.getUnderlyingAsset();
		String category = optionsEntity.getOptionsCat();
		String optionstype = optionsEntity.getOptionsType();
		
		OptionId optid = new OptionId(compname,category,optionstype,underasset);
		Optional<Options> opt = optionsrepo.findById(optid);

		double spotPriceTemp = spotPrice;
		int lotSizeTemp = opt.get().getLotSize();
		
		double strikePriceTemp = optionsEntity.getStrikePrice();
		int lotQuantityTemp = optionsEntity.getLotQuantity();
		double premium = optionsEntity.getPremium();
		double breakEvenCall = strikePriceTemp+premium; 
		double breakEvenPut = strikePriceTemp-premium; 
		int x =-1;
		
		if(category.equals("Long")&&optionstype.equals("Call")&&(spotPriceTemp>strikePriceTemp)) {
			
			return lotSizeTemp*lotQuantityTemp*(spotPriceTemp-breakEvenCall);
			
		}else if(category.equals("Long")&&optionstype.equals("Call")&&(spotPriceTemp<=strikePriceTemp)) {
			return x*lotSizeTemp*lotQuantityTemp*(premium);
			
		}else if(category.equals("Short")&&optionstype.equals("Call")&&(spotPriceTemp>strikePriceTemp)) {
			return x*lotSizeTemp*lotQuantityTemp*(spotPriceTemp-breakEvenCall);
			
		}else if(category.equals("Short")&&optionstype.equals("Call")&&(spotPriceTemp<=strikePriceTemp)) {
			return lotSizeTemp*lotQuantityTemp*(premium);
			
		}else if(category.equals("Long")&&optionstype.equals("Put")&&(spotPriceTemp<=strikePriceTemp)) {
			return lotSizeTemp*lotQuantityTemp*(breakEvenPut-spotPriceTemp);
			
		}else if(category.equals("Long")&&optionstype.equals("Put")&&(spotPriceTemp>strikePriceTemp)) {
			return x*lotSizeTemp*lotQuantityTemp*premium;
			
		}else if(category.equals("Short")&&optionstype.equals("Put")&&(spotPriceTemp<=strikePriceTemp)) {
			return x*lotSizeTemp*lotQuantityTemp*(breakEvenPut-spotPriceTemp);
			
		}else if(category.equals("Short")&&optionstype.equals("Put")&&(spotPriceTemp>strikePriceTemp)) {
			return lotSizeTemp*lotQuantityTemp*premium;
		}
		
		return 0;
	}

	public double calculateMarginOptions(OptionsEntity optionsEntity) {
		// TODO Auto-generated method stub
		String compname = optionsEntity.getCompanyName();
		String underasset = optionsEntity.getUnderlyingAsset();
		String category = optionsEntity.getOptionsCat();
		String optionstype = optionsEntity.getOptionsType();
		
		OptionId optid = new OptionId(compname,category,optionstype, underasset);
		Optional<Options> opt = optionsrepo.findById(optid);
		
		double strikePriceTemp = optionsEntity.getStrikePrice();
		int lotQuantityTemp = optionsEntity.getLotQuantity();
		double spotPriceTemp = opt.get().getSpotPrice();
		int lotSizeTemp = opt.get().getLotSize();
		
		if(category.equals("Long")&&optionstype.equals("Call")) {
			return 0;
			
		}else if(category.equals("Short")&&optionstype.equals("Call")) {
			
			double margin =lotSizeTemp*lotQuantityTemp*strikePriceTemp*0.2;
			return margin;
			
		}else if(category.equals("Long")&&optionstype.equals("Put")) {
			
			double margin =0.0;
			return margin;
			
		}else if(category.equals("Short")&&optionstype.equals("Put")) {
			
			double margin = lotSizeTemp*lotQuantityTemp*strikePriceTemp*0.2;
			return margin;
		} else {
			return 0;
		}
}
	
	@Override
	public TradeEntity createTrade(TradeEntity tradeEntity) {
		
		// TODO Auto-generated method stub
		// creating tradeId and updation in server //
		
		TradeEntity tradeEntityTemp = tradeEntity;
		Set<FuturesEntity> futuresEntitiestemp = tradeEntityTemp.getFuturesTrade();
		Set<OptionsEntity> optionsEntitiestemp = tradeEntityTemp.getOptionsTrade();
		Long tradeId = tradeEntityTemp.getTradeId();
		for (FuturesEntity f : futuresEntitiestemp) {
			f.setTradeEntity(tradeEntityTemp);
		}
		for (OptionsEntity o : optionsEntitiestemp) {
			o.setTradeEntity(tradeEntityTemp);
		}
		tradeEntityTemp.setFuturesTrade(futuresEntitiestemp);
		tradeEntityTemp.setOptionsTrade(optionsEntitiestemp);
		TradeEntity tradeEntityfinal = tradeRepo.save(tradeEntityTemp);
		
		// setting of tradeId in futuresTrade and OptionsTrade done // 
		
		// calcultion of Profit And Margin // 
		Set<FuturesEntity> futuresEntities = tradeEntityfinal.getFuturesTrade();
		Set<OptionsEntity> optionsEntities = tradeEntityfinal.getOptionsTrade();
		double profit = 0;
		double margin = 0;
		for (FuturesEntity f : futuresEntities) {
			//double tempProfit = futuresProfitorLoss(f);
			double tempMargin = calculateMarginFutures(f);
			margin+=tempMargin;
			//profit+=tempProfit;
			//f.setFuturesProfit(tempProfit);
			f.setFuturesMargin(tempMargin);
		}
		for (OptionsEntity o : optionsEntities) {
			//double tempProfit = optionsProfitAndLoss(o);
			double tempMargin = calculateMarginOptions(o);
			//profit+=tempProfit;
			margin+=tempMargin;
			//o.setOptionsProfit(tempProfit);
			o.setOptionsMargin(margin);
			
		}
		
		// Completion of trade margin calculation //
		
		
		// saving of calculated value in Database // 
		//tradeEntityfinal.setTradeProfit(profit);
		tradeEntityfinal.setTradeMargin(margin);
		TradeEntity tradeEntityReturn = tradeRepo.save(tradeEntityfinal);
		// saving Done // 
		
		return tradeEntityReturn;
	}

	public PayOffCoordinates tradeNetProfit(TradeEntity tradeEntity,double spotPrice) {
		
		PayOffCoordinates p = new PayOffCoordinates();
		TradeEntity tradeEntityTemp = tradeEntity;
		Set<FuturesEntity> futuresEntities = tradeEntityTemp.getFuturesTrade();
		Set<OptionsEntity> optionsEntities = tradeEntityTemp.getOptionsTrade();
		double spotPriceTemp = spotPrice;
		double profit = 0;
		
		for (FuturesEntity f : futuresEntities) {
			double tempProfit = futuresProfitorLoss(f,spotPriceTemp);
			profit+=tempProfit;
			f.setFuturesProfit(tempProfit);
		}
		
		for (OptionsEntity o : optionsEntities) {
			double tempProfit = optionsProfitAndLoss(o,spotPriceTemp);
			profit+=tempProfit;
			o.setOptionsProfit(tempProfit);
		}
		
		p.setSpotPrice(spotPriceTemp);
		p.setProfitOrLoss(profit);
		return p;
		
	}
	
	@Override
	public List<PayOffCoordinates> payOffChart(TradeEntity tradeEntity) {
		// TODO Auto-generated method stub
		
		// creating tradeId and updation in server //
		TradeEntity tradeEntityTemp = tradeEntity;
		
		List<PayOffCoordinates> p = new ArrayList<PayOffCoordinates>();
		
		double spotPriceTemp = 0;
		
		Set<FuturesEntity> futuresEntitiestemp = tradeEntityTemp.getFuturesTrade();
		Set<OptionsEntity> optionsEntitiestemp = tradeEntityTemp.getOptionsTrade();
		
		if(!futuresEntitiestemp.isEmpty()) {
			List<FuturesEntity> l = new ArrayList<FuturesEntity>();
			l.addAll(futuresEntitiestemp);
			FutureId ft = new FutureId(l.get(0).getCompanyName(), l.get(0).getUnderlyingAsset(), l.get(0).getFuturesCat());
			Optional<Futures> fut = futuresrepo.findById(ft);
			spotPriceTemp = fut.get().getSpotPrice();
		} else {
			List<OptionsEntity> l = new ArrayList<OptionsEntity>(optionsEntitiestemp);
			OptionId op = new OptionId(l.get(0).getCompanyName(),l.get(0).getOptionsCat(),
					l.get(0).getOptionsType(),l.get(0).getUnderlyingAsset());
			Optional<Options> opt = optionsrepo.findById(op);
			spotPriceTemp = opt.get().getSpotPrice();
		}
		
		
		
		for (FuturesEntity f : futuresEntitiestemp) {
			f.setTradeEntity(tradeEntityTemp);
		}
		for (OptionsEntity o : optionsEntitiestemp) {
			o.setTradeEntity(tradeEntityTemp);
		}
		tradeEntityTemp.setFuturesTrade(futuresEntitiestemp);
		tradeEntityTemp.setOptionsTrade(optionsEntitiestemp);
		TradeEntity tradeEntityfinal = tradeRepo.save(tradeEntityTemp);
		// setting of tradeId in futuresTrade and OptionsTrade done // 
		
		
		
		for (double j = 0.8*spotPriceTemp;j<=1.2*spotPriceTemp;j+=0.0001*spotPriceTemp) {
			p.add(tradeNetProfit(tradeEntityfinal, j));
		}
		
		return p;
	}

	@Override
	public TradeEntityDto levelOne(TradeEntity tradeEntity) {
		
		//return entity
		TradeEntityDto t = new TradeEntityDto();
		
		// pass to TradeDTO
		List<PayOffCoordinates> l = payOffChart(tradeEntity);
		
		List<Double> profitTemp = new ArrayList<Double>();
		List<Double> spotPriceBreakEven = new ArrayList<Double>();
		
		t.setPayOffCoordinates(l);
		
		double maxProfit = 0;
		double maxLoss = 0;
		
		for (PayOffCoordinates p: l) {
			if (maxProfit < p.getProfitOrLoss()) {
				maxProfit = p.getProfitOrLoss();
			} 
			if (maxLoss > p.getProfitOrLoss()) {
				maxLoss = p.getProfitOrLoss();
			}
			profitTemp.add(p.getProfitOrLoss());
		}
		
		List<Integer> breakEven = new ArrayList<Integer>();
		
		
		// BreakEven Point //
		
		
		for (int i=1;i<profitTemp.size();i++) {
			if ((profitTemp.get(i)<0 && profitTemp.get(i-1)>0)||(profitTemp.get(i)>0 && profitTemp.get(i-1)<0)) {
				breakEven.add(i);
			}
		}
		
		for(int i :breakEven) {
			spotPriceBreakEven.add(l.get(i).getSpotPrice());
		}
		t.setBreakEvenPoints(spotPriceBreakEven);
		
		
		// Break Even Point //
		
		// Margin Calculation //
		
		Set<FuturesEntity> futuresEntitiestemp = tradeEntity.getFuturesTrade();
		Set<OptionsEntity> optionsEntitiestemp = tradeEntity.getOptionsTrade();
		double margin = 0;
		for (FuturesEntity f : futuresEntitiestemp) {
			double marginTemp = calculateMarginFutures(f);
			margin += marginTemp;
		}
		for (OptionsEntity o : optionsEntitiestemp) {
			double marginTemp = calculateMarginOptions(o);
			margin += marginTemp;
		}
		
		t.setTradeMargin(margin);
		
		// Margin Calculation //
		
		// Maximum Profit or Loss //
		
		List<Double> initial = new ArrayList<Double>(profitTemp.subList(0, 10));
		Set<Double> initialSet = initial.stream().collect(Collectors.toSet());
		List<Double> initialSortedAsc = new ArrayList<Double>(profitTemp.subList(0, 10));
		Collections.sort(initialSortedAsc);
		
		List<Double> initialSortedDesc = new ArrayList<Double>(initialSortedAsc);
		Collections.reverse(initialSortedDesc);
		
		List<Double> ending = new ArrayList<Double>(profitTemp.subList(l.size()-10, l.size()));
		Set<Double> endingSet = ending.stream().collect(Collectors.toSet());
		List<Double> endingSortedAsc = new ArrayList<Double>(profitTemp.subList(l.size()-10, l.size()));
		Collections.sort(endingSortedAsc);
		
		List<Double> endingSortedDesc = new ArrayList<Double>(endingSortedAsc);
		Collections.reverse(endingSortedDesc);
		

 		String bullish = null;
		String bearish = null;
		
		// Denoting bearish and bullish string by checking at early points and end points //
		
		if (initialSet.size() == 1 && endingSet.size() != 1) {
			
			bearish = "constant";
			if (ending.equals(endingSortedAsc)) {
				bullish = "Unlimited Profit";
			}
			if (ending.equals(endingSortedDesc)) {
				bullish = "Unlimited Loss";
			}
		} else if (initialSet.size() != 1 && endingSet.size() == 1) {
			bullish = "constant";
			if (initial.equals(initialSortedAsc)) {
				bearish = "Unlimited Loss";
			}
			if (initial.equals(initialSortedDesc)) {
				bearish = "Unlimited Profit";
			}
		} else {
			if (initial.equals(initialSortedAsc)) {
				bearish = "Unlimited Loss";
			}
			if (ending.equals(endingSortedAsc)) {
				bullish = "Unlimited Profit";
			}
			if (initial.equals(initialSortedDesc)) {
				bearish = "Unlimited Profit";
			}
			if (ending.equals(endingSortedDesc)) {
				bullish = "Unlimited Loss";
			}
		}
		
		// Denoting bearish and bullish string by checking at early points and end points //
		
		// Finding maximum and minimum profit/loss //
		if (bearish.equals("Unlimited Profit") && bullish.equals("Unlimited Loss")) {
			
			t.setTradeProfit(bearish);
			t.setTradeLoss(bullish);
			
		} else if (bearish.equals("Unlimited Loss") && bullish.equals("Unlimited Profit")) {
			
			t.setTradeProfit(bullish);
			t.setTradeLoss(bearish);
			
		} else if (bearish.equals("Unlimited Loss") && bullish.equals("Unlimited Loss")) {
			
			t.setTradeProfit(Double.toString(maxProfit));
			t.setTradeLoss("Unlimited Loss");
			
		} else if (bearish.equals("Unlimited Profit") && bullish.equals("Unlimited Profit")) {
			
			t.setTradeProfit("Unlimited Profit");
			t.setTradeLoss(Double.toString(maxLoss));
			
		} else if (bearish.equals("Unlimited Profit") && bullish.equals("constant")) {
			
			t.setTradeProfit("Unlimited Profit");
			t.setTradeLoss(Double.toString(maxLoss));
			
		} else if (bearish.equals("Unlimited Loss") && bullish.equals("constant")) {
			
			t.setTradeLoss("Unlimited Loss");
			t.setTradeProfit(Double.toString(maxProfit));
			
		} else if (bearish.equals("constant") && bullish.equals("Unlimited Profit")) {
			
			t.setTradeProfit("Unlimited Profit");
			t.setTradeLoss(Double.toString(maxLoss));
			
		} else if (bearish.equals("constant") && bullish.equals("Unlimited Loss")) {
			
			t.setTradeLoss("Unlimited Loss");
			t.setTradeProfit(Double.toString(maxProfit));
			
		}
		// Finding maximum and minimum profit/loss //	
		
		return t;
		
	}

	
}

	
