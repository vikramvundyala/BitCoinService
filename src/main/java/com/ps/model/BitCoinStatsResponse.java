package com.ps.model;

import java.math.BigDecimal;

public class BitCoinStatsResponse {
	
	private BigDecimal high;
	private BigDecimal low;
	private String currency;
	
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
