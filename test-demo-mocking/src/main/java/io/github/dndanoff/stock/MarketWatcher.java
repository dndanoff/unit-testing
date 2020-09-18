package io.github.dndanoff.stock;

import java.math.BigDecimal;
import java.math.MathContext;

public class MarketWatcher {

	public Stock getQuote(String symbol) {
		return new Stock(symbol, new BigDecimal(Math.random()*100).round(new MathContext(2)));
	}

}
