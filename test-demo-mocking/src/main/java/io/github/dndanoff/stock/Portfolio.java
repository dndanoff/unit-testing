package io.github.dndanoff.stock;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Portfolio {
	
	private Map<String, List<Stock>> stocks = new HashMap<>();

	public BigDecimal getAvgPrice(Stock stock) {
		if(!stocks.containsKey(stock.getSymbol())) {
			return BigDecimal.ZERO;
		}
		
		double avg = stocks.get(stock.getSymbol()).stream().map(s -> s.getPrice()).collect(Collectors.averagingDouble( b -> b.doubleValue()));
		return new BigDecimal(avg, new MathContext(2));
	}

	public void sell(Stock stock, int sellCount) {
		if(!stocks.containsKey(stock.getSymbol())) {
			return;
		}
		
		Iterator<Stock> iterator = stocks.get(stock.getSymbol()).iterator();
		while(iterator.hasNext() && sellCount != 0) {
			iterator.next();
			iterator.remove();
			sellCount--;
		}
		
	}

	public void buy(Stock stock) {
		List<Stock> currentStocks = stocks.getOrDefault(stock.getSymbol(), new ArrayList<>());
		currentStocks.add(stock);
		stocks.put(stock.getSymbol(), currentStocks);
	}

}
