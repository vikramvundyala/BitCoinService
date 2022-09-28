package com.ps.service;

import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.ps.model.BitCoinStatsRequest;
import com.ps.model.BitCoinStatsResponse;

@SpringBootTest
public class BitCoinStatsServiceTests {

	@Autowired
	private BitCoinStatsService bitCoinStatsService;
	
	@Test
	public void getStatsOfTimePeriod_test() {
		BitCoinStatsRequest bcsr=new BitCoinStatsRequest();
		bcsr.setCurrencyCode("USD");
		bcsr.setFromDate(Date.from(new Date().toInstant().minus(Duration.ofDays(1))));
		bcsr.setToDate(new Date());
		
		BitCoinStatsResponse response = bitCoinStatsService.getStatsOfTimePeriod(bcsr);
		
		Assert.notNull(response, "BitCoinStatsResponse should not be null ");
	}
}
