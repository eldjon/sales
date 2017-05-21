package com.relay42.repository;

import com.relay42.exceptions.ParameterOutOfBoundException;
import com.relay42.model.TomatoSaleRecord;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Eldjon Kepucka.
 */
public class TomatoSaleRepositoryTest {

	private TomatoSaleRepository repository;

	@Before
	public void init(){
		repository = new TomatoSaleRepository(1000);
	}

	@Test(expected = ParameterOutOfBoundException.class)
	public void test_getRecordsNegativeSize(){

		repository.getRecords(-1);
	}

	@Test(expected = ParameterOutOfBoundException.class)
	public void test_getRecordsBadSize(){

		repository.getRecords(1001);
	}

	@Test
	public void test_getRecordsSuccess(){

		int numberOfRecords = 5;
		List<TomatoSaleRecord> records = repository.getRecords(numberOfRecords);
		Assert.assertEquals(numberOfRecords, records.size());
	}
}
