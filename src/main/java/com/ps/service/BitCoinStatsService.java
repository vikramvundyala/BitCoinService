package com.ps.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.ps.model.BitCoinStatsRequest;
import com.ps.model.BitCoinStatsResponse;
import com.ps.model.BitCoinsStats;
import com.ps.util.PsConstants;
import com.ps.util.PsUtil;

@Service
public class BitCoinStatsService {

	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(BitCoinStatsService.class);
	
	public BitCoinStatsResponse getStatsOfTimePeriod(BitCoinStatsRequest bcsr) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(PsConstants.CHART_API_URL).queryParam("query", bitCoinParams.apply(bcsr));
		BitCoinsStats bs = restTemplate.getForObject(builder.build().toUri(), BitCoinsStats.class);
		
		List<BigDecimal> list = bs.getEntries().stream().map(x->x[1]).collect(Collectors.toList());
		
		BitCoinStatsResponse response = new BitCoinStatsResponse();
		response.setHigh(Collections.max(list));
		response.setLow(Collections.min(list));
		response.setCurrency(bcsr.getCurrencyCode());
		return response;
	}
	
	private Function<BitCoinStatsRequest, String> bitCoinParams = bcsr -> {
		Map<String, Object> uriParams = new HashMap<String, Object>();
		uriParams.put("end_date", PsUtil.dateFormat.apply(bcsr.getToDate()));
		uriParams.put("start_date", PsUtil.dateFormat.apply(bcsr.getFromDate()));
		uriParams.put("iso", "BTC");
		uriParams.put("ohlc", Boolean.FALSE);
		uriParams.put("code", bcsr.getCurrencyCode());
		
		String query=null;
		try {
			query = new ObjectMapper().writeValueAsString(uriParams);
		} catch (JsonProcessingException e) {
			logger.error(" bitCoinParams parse exception ", e);
		}
	    return query;	
	};
			
}
