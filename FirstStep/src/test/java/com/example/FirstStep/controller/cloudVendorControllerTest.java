package com.example.FirstStep.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.FirstStep.model.CloudVendor;
import com.example.FirstStep.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(cloudVendorController.class)
class cloudVendorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CloudVendorService cloudVendorService;
	CloudVendor cloudVendorOne;
	CloudVendor cloudVendorTwo;
	
	List<CloudVendor> cloudVendorList=new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		cloudVendorOne= new CloudVendor("1","Shri","pune","4566");
		cloudVendorTwo= new CloudVendor("1","Shri","pune","4566");
		cloudVendorList.add(cloudVendorOne);
		cloudVendorList.add(cloudVendorTwo);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetCloudVendor() throws Exception {
		
		when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
		this.mockMvc.perform(get("/cloudvendordb/1")).andDo(print()).andExpect(status().isOk());
		//fail("Not yet implemented");
	}

	@Test
	void testGetAllCloudVendorDetails() throws Exception {
		 when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
	        this.mockMvc.perform(get("/cloudvendordb/"))
	                .andDo(print()).andExpect(status().isOk());
		//fail("Not yet implemented");
	}

	@Test
	void testCreateCloudVendorDetails() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

		when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Created Cloud Vendor Successfully");
		this.mockMvc.perform(post("/cloudvendordb/").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testUpdateCloudVendorDetails() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

		when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("Cloud Vendor Updated Successfully");
		this.mockMvc.perform(put("/cloudvendordb/").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testDeleteCloudVendorDetails() throws Exception {
		when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Deleted Cloud Vendor Successfully");
		this.mockMvc.perform(delete("/cloudvendordb/1")).andDo(print()).andExpect(status().isOk());
		//fail("Not yet implemented");
	}

}
