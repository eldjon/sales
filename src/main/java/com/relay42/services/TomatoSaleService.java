package com.relay42.services;

import com.relay42.model.TomatoSaleRecord;
import com.relay42.repository.TomatoSaleRepository;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author Eldjon Kepucka.
 */
@Service
public class TomatoSaleService {

	private TomatoSaleRepository repository;

	public TomatoSaleService(TomatoSaleRepository repo){
		repository = repo;
	}

	public List<TomatoSaleRecord> getRecords(Integer size){

		int numberOfRecords;
		if(size == null){
			numberOfRecords = 3;
		} else {
			numberOfRecords = size;
		}

		return repository.getRecords(numberOfRecords);
	}
}
