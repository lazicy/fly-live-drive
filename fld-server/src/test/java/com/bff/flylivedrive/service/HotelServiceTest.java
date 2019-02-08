package com.bff.flylivedrive.service;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bff.flylivedrive.constants.HotelConstants;
import com.bff.flylivedrive.model.Hotel;
import com.bff.flylivedrive.repository.HotelRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {
	
	@Mock
	private HotelRepository hotelRepositoryMock;
	
	@Mock
	private Hotel hotelMock;
	
	@InjectMocks
	private HotelService hotelService;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindAll() {
		
	}

}
