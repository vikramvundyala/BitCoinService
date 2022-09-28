package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ps.model.SupportedCurrencies;
import com.ps.util.PsConstants;

@Service
public class BitCoinSupportedCurrenciesService {
	
	private static List<String> supportedCurrencies;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<String> getSupportedCurrencies(){
		if(supportedCurrencies==null) {
			ResponseEntity<SupportedCurrencies[]> currencies = restTemplate.
					getForEntity(PsConstants.CURR_API_URL, SupportedCurrencies[].class);
			supportedCurrencies = new ArrayList<String>();
			for(SupportedCurrencies sc:currencies.getBody()) {
				supportedCurrencies.add(sc.getCurrency());
			}
		}
		return supportedCurrencies;
	}

}
