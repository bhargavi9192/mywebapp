package com.ty.drools.services;

import java.sql.Date;
import java.util.HashMap;

import org.junit.Assert;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ty.drools.model.EngagementScore;


public class IEngagementScore {
	@Autowired
	KieSession kieSession;

	public EngagementScore test() {
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
		Assert.assertEquals("there´s 1 rule, so there should be 1 fired", 5,
				ruleFiredCount);
		// kieSession.dispose();
		return engagementScore;
	}

}
