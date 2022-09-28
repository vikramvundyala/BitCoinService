package com.ps.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BitCoinSupportedCurrenciestTest {

	@Autowired
	private BitCoinSupportedCurrenciesService currenciesService;
	
	@Test
	public void getSupportedCurrencies_test() {
		List<String> supportedCurrencies = currenciesService.getSupportedCurrencies();
		assertNotNull(supportedCurrencies, "supportedCurrencies should not be null");
	}
	
}
