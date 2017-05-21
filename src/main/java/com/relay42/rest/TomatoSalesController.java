package com.relay42.rest;

import com.relay42.model.TomatoSaleRecord;
import com.relay42.services.TomatoSaleService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eldjon Kepucka.
 */
@RestController
@RequestMapping(value = "/sales/tomatoes")
public class TomatoSalesController {

	private TomatoSaleService service;

	public TomatoSalesController(TomatoSaleService ser){
		service = ser;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "data", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TomatoSaleRecord> getRecords(@RequestParam(value = "size", required = false) Integer size){

		return service.getRecords(size);
	}
}
