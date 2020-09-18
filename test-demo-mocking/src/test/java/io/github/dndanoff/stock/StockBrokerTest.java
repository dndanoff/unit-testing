package io.github.dndanoff.stock;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class StockBrokerTest {
	@Mock(answer = Answers.RETURNS_SMART_NULLS)
	private MarketWatcher marketWatcher;
	@Mock
	private Portfolio portfolio;
	
	@Captor
	ArgumentCaptor<String> stringArgCapture;

	private StockBroker objUnderTest;

	@Before
	public void setUp() {
		objUnderTest = new StockBroker(marketWatcher);
	}
	
	
	@Test
	public void changeMockSetting() {
		assertEquals("FB",marketWatcher.getQuote("FB").getSymbol());
	}

	@Test
	public void marketWatcher_Returns_current_stock_status() {
		Stock facebook = new Stock("FB", new BigDecimal("100.00"));
		when(marketWatcher.getQuote(anyString())).thenReturn(facebook);
		assertNotNull(marketWatcher.getQuote("FB"));
	}
	
	@Test
	public void marketWatcherArgumentCaptor() {
		marketWatcher.getQuote("FB");
		marketWatcher.getQuote("A");
		marketWatcher.getQuote("B");
		marketWatcher.getQuote("C");
//		ArgumentCaptor<String> stringArgCapture = ArgumentCaptor.forClass(String.class);
		verify(marketWatcher, times(4)).getQuote(stringArgCapture.capture());
		assertEquals("C", stringArgCapture.getValue());
		assertThat(stringArgCapture.getAllValues(),hasItem("FB"));
	}
	
	@Test
	public void marketWatcher_answer_current_stock_status() {
		when(marketWatcher.getQuote(anyString())).thenAnswer(new Answer<Stock>() {

			@Override
			public Stock answer(InvocationOnMock invocation) throws Throwable {
				String stockSymbol = (String)invocation.getArguments()[0];
				return new Stock(stockSymbol, new BigDecimal("100.00") );
			}
			
		});
		assertNotNull(marketWatcher.getQuote("FB"));
	}


	@Test
	public void when_ten_percent_gain_then_the_stock_is_sold() {
		// Portfolio's getAvgPrice is stubbed to return $10.00
		when(portfolio.getAvgPrice(any(Stock.class))).thenReturn(new BigDecimal("10.00"));
		// A stock object is created with current price $11.20
		Stock aCorp = new Stock("A", new BigDecimal("11.20"));
		// getQuote method is stubbed to return the stock
		when(marketWatcher.getQuote(anyString())).thenReturn(aCorp);
		// perform method is called, as the stock price increases
		// by 12% the broker should sell the stocks
		objUnderTest.perform(portfolio, aCorp);
		// verifying that the broker sold the stocks
		verify(portfolio).sell(aCorp, 10);
	}
}
