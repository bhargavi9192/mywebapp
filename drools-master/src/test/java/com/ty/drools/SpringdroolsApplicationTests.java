package com.ty.drools;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ty.drools.model.EngagementScore;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DroolsSpringApplication.class)
public class SpringdroolsApplicationTests {

	private static final Logger LOG = LoggerFactory
			.getLogger(SpringdroolsApplicationTests.class);

	@Autowired
	private KieSession kieSession;
	static int SCORE = 0;

	@Test
	public void test() {
		EngagementScore engagementScore = new EngagementScore();
		engagementScore.setDate(new Date(0));
		HashMap<String, String> lastContactDates = new HashMap<>();
		lastContactDates.put("1", "2016-12-12");
		lastContactDates.put("12", "2016-12-12");
		lastContactDates.put("17", "2016-12-12");
		lastContactDates.put("19", "2016-12-12");
		engagementScore.setLastContactDates(lastContactDates);
		kieSession.insert(engagementScore);
		int ruleFiredCount = kieSession.fireAllRules();
		System.out.println(engagementScore.getPortfolioScore() + " "
				+ engagementScore.getPercentage());
		assertEquals("there´s 1 rule, so there should be 1 fired", 5,
				ruleFiredCount);
		LOG.debug("Rules checked: {}" + ruleFiredCount);

	}
/*	 @Test
	 public void test1(){
	 EngagementScore engagementScore = new EngagementScore();
	 engagementScore.setDate(new Date(0));
	 engagementScore.setPercentage(90);
	 engagementScore.setLastContactDates(new HashMap<String, String>());
	 kieSession.insert(engagementScore);
	 int ruleFiredCount = kieSession.fireAllRules();
	 System.out.println(engagementScore.getPortfolioScore()+" "+engagementScore.getPercentage());
	 assertEquals("there´s 1 rule, so there should be 1 fired", 2,
	 ruleFiredCount);
	 LOG.debug("Rules checked: {}" + ruleFiredCount);
	 }
*/}
