package com.relay42.repository;

import com.relay42.exceptions.ParameterOutOfBoundException;
import com.relay42.model.TomatoSaleRecord;
import com.relay42.model.TomatoSaleRecord.TomatoProvider;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @author Eldjon Kepucka.
 */
@Repository
public class TomatoSaleRepository {


	private int max;

	public TomatoSaleRepository(@Value("${data.records.max}") int maxRecords){
		max = maxRecords;
	}

	public List<TomatoSaleRecord> getRecords(int numberOfRecords){

		if(numberOfRecords < 0 || numberOfRecords > max){
			throw new ParameterOutOfBoundException("numberOfRecords has to be a positive number <= " + max);
		}
		List<TomatoSaleRecord> result = new ArrayList<TomatoSaleRecord>(numberOfRecords);
		for(int i = 0; i< numberOfRecords; i++){
			result.add(generateRecord());
		}

		return result;
	}

	private TomatoSaleRecord generateRecord(){

		TomatoProvider provider = TomatoProvider.values()[ThreadLocalRandom.current().nextInt(0, 2)];
		TomatoSaleRecord record = TomatoSaleRecord.builder()
									  .tomatoes(ThreadLocalRandom.current().nextInt(0, 2001))
									  .provider(provider.provider())
									  .timestamp(generateDate())
									  .id(UUID.randomUUID().toString())
									  .build();
		return record;
	}

	private long generateDate(){

		LocalDateTime current = LocalDateTime.now();
		LocalDateTime yearStart = current.withYear(current.getYear()).withMonth(Month.JANUARY.ordinal()+1).withDayOfYear(1);
		long yearStartLn = yearStart.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		long currentLn = current.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		return ThreadLocalRandom.current().nextLong(yearStartLn, currentLn + 1);
	}
}
