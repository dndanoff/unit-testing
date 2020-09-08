package io.github.dndanoff.solved;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class SurveyCalculatorTest {
	
	SurveyCalculator surveyCalculator;
	
	@Before
	public void setup() {
		surveyCalculator = new SurveyCalculator();
	}
	
	@Test
	public void when_one_opinion_then_result_forecasts_the_opinion() {
		String opinion = "Party A";
		surveyCalculator.willVoteFor(opinion);
		Map<String, BigDecimal> result = surveyCalculator.forecastResult();
		assertEquals(new BigDecimal("100"), result.get(opinion));
	}

	@Test
	public void when_different_opinions_then_forecasts_50_percent_chance_for_each_party() {
		String opinionA = "Party A";
		surveyCalculator.willVoteFor(opinionA);
		String opinionB = "Party B";
		surveyCalculator.willVoteFor(opinionB);
		Map<String, BigDecimal> result = surveyCalculator.forecastResult();
		assertEquals(new BigDecimal("50"), result.get(opinionA));
		assertEquals(new BigDecimal("50"), result.get(opinionB));
	}

	@Test
	public void when_three_different_opinions_then_forecasts_33_percent_chance_for_each_party() {
		String opinionA = "Party A";
		surveyCalculator.willVoteFor(opinionA);
		String opinionB = "Party B";
		surveyCalculator.willVoteFor(opinionB);
		String opinionC = "Party C";
		surveyCalculator.willVoteFor(opinionC);
		Map<String, BigDecimal> result = surveyCalculator.forecastResult();
		assertEquals(new BigDecimal("33"), result.get(opinionA));
		assertEquals(new BigDecimal("33"), result.get(opinionB));
		assertEquals(new BigDecimal("33"), result.get(opinionC));
	}
}
