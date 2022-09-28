package com.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.model.BitCoinStatsRequest;
import com.ps.model.BitCoinStatsResponse;
import com.ps.service.BitCoinStatsService;
import com.ps.service.BitCoinSupportedCurrenciesService;

@RestController
@RequestMapping("/api/bitcoin")
public class BitCoinController {
	
	@Autowired
	BitCoinSupportedCurrenciesService currencyService;
	
	@Autowired
	BitCoinStatsService statsService;
	
	@PostMapping(value = "/stats")
	public ResponseEntity<BitCoinStatsResponse> getDaysStatistics(@RequestBody BitCoinStatsRequest bitCoinStatsRequest) {
		return new ResponseEntity<>(statsService.getStatsOfTimePeriod(bitCoinStatsRequest), HttpStatus.OK);
	}
	
	@GetMapping(value = "/supportedCurrencies")
	public ResponseEntity<List<String>> supportedCurrencies(){
		return new ResponseEntity<>(currencyService.getSupportedCurrencies(),HttpStatus.OK);
	}

}
