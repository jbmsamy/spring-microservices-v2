package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange", url="localhost:8000")
//@FeignClient(name="currency-exchange")

//CHANGE-KUBERNETES
//@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://" + "a05753b551dfd412e97eb5fe928c0add-1430171549.ap-south-1.elb.amazonaws.com" +"}:8000")
@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
public interface CurrencyExchangeProxy {
	
	//String EXCHANGE_SERVICE = 
		//	"a0fec88d44c04468fa5972a042054f79-1109946590.ap-south-1.elb.amazonaws.com"
			//"a05753b551dfd412e97eb5fe928c0add-1430171549.ap-south-1.elb.amazonaws.com"
			//"a3b219480c4f14d93bf221f72ee5e488-600237034.ap-south-1.elb.amazonaws.com";
			//"a5231e13b8e114c118b74ed329d5129e-884682863.ap-south-1.elb.amazonaws.com"
			//;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);

}
