package com.ty.drools.model;


import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.commons.lang.time.DateUtils;

public class EngagementScore {
	private float percentage;
	private Date date;
	private Integer portfolioScore;
	private HashMap<String, String> lastContactDates;
	private float value;

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPortfolioScore() {
		return portfolioScore;
	}

	public void setPortfolioScore(Integer portfolioScore) {
		this.portfolioScore = portfolioScore;
	}

	public HashMap<String, String> getLastContactDates() {
		return lastContactDates;
	}

	public void setLastContactDates(HashMap<String, String> lastContactDates) {
		this.lastContactDates = lastContactDates;
	}

	public static void main(String[] args) throws ParseException {
		java.util.Date date = new java.util.Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		String[] strings = { "yyyy-MM-dd" };
		date = DateUtils.parseDate("2016-11-11", strings);
		System.err.println(date);
		cal.setTime(date);
		System.err.println(cal.get(Calendar.MONTH));
		Integer inte = new Integer(0);
		System.err.println(inte + 1);
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
