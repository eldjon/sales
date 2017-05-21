package com.relay42.services;

import com.relay42.model.TomatoSaleRecord;
import com.relay42.repository.TomatoSaleRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eldjon Kepucka.
 */

@RunWith(MockitoJUnitRunner.class)
public class TomatoSaleServiceTest {

	private TomatoSaleService service;
	@Mock
	private TomatoSaleRepository repository;

	@Before
	public void init(){
		service = new TomatoSaleService(repository);
	}

	@Test
	public void test_getRecordsNoSize(){

		when(repository.getRecords(anyInt())).thenReturn(generateRecords(3));
		List<TomatoSaleRecord> result = service.getRecords(null);

		Assert.assertEquals(3, result.size());
	}

	@Test
	public void test_getRecordsWithSize(){

		int size = 10;
		when(repository.getRecords(anyInt())).thenReturn(generateRecords(size));
		List<TomatoSaleRecord> result = service.getRecords(size);

		Assert.assertEquals(size, result.size());
	}

	private List<TomatoSaleRecord> generateRecords(int size){

		List<TomatoSaleRecord> result = new ArrayList<TomatoSaleRecord>(size);
		for(int i = 0; i < size; i++){
			result.add(new TomatoSaleRecord());
		}
		return result;
	}
}
