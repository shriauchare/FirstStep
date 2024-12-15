package com.example.FirstStep.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.FirstStep.model.CloudVendor;
import com.example.FirstStep.repository.CloudVendorRepository;
import com.example.FirstStep.service.CloudVendorService;

class CloudVendorServiceImplTest {

	@Mock
	private CloudVendorRepository cloudVendorRepository;
	private CloudVendorService cloudVendorService;
	AutoCloseable autoCloseable;
	CloudVendor cloudVendor;
	
	@BeforeEach
	void setUp() throws Exception {
		autoCloseable= MockitoAnnotations.openMocks(this);
		cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
		cloudVendor=new CloudVendor("1","Addresss","Pune","9874563210");
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}


	@Test
	void testCreateCloudVendor() {
		
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
			assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Created Cloud Vendor Successfully");
		//fail("Not yet implemented");
	}	

	@Test
	void testGetCloudVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findById("1")).thenReturn(Optional.ofNullable(cloudVendor));
		assertThat(cloudVendorService.getCloudVendor("1").getVendorName()).isEqualTo(cloudVendor.getVendorName());
		
		//fail("Not yet implemented");
	}

	@Test
	void testGetAllCloudVendors() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(
                Collections.singleton(cloudVendor)
        ));

        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).
                isEqualTo(cloudVendor.getVendorPhoneNumber());

		//fail("Not yet implemented");
	}


	@Test
	void testUpdateCloudVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Updated Cloud Vendor Successfully");
		//fail("Not yet implemented");
	}

	
	@Test
	void testFindByVendorName() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		 when(cloudVendorRepository.findByVendorName("Amazon")).
         thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));

		 assertThat(cloudVendorService.findByVendorName("Amazon").get(0).getVendorId()).
         isEqualTo(cloudVendor.getVendorId());
		//fail("Not yet implemented");
	}

	@Test
	void testDeleteCloudVendor() {
		mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository)
                .deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Deleted Cloud Vendor Successfully");
		//fail("Not yet implemented");
	}
}
