package com.example.FirstStep.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstStep.Response.ResponseHandler;
import com.example.FirstStep.model.CloudVendor;
import com.example.FirstStep.service.CloudVendorService;

import io.swagger.annotations.ApiOperation;

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cloudvendordb")
public class cloudVendorController {
	
	CloudVendorService cloudVendorService;
	
	public cloudVendorController(CloudVendorService cloudVendorService) {
		super();
		this.cloudVendorService = cloudVendorService;
	}

	 	@GetMapping("/{vendorId}")
	 	@ApiOperation(value="Cloud Vendor Id", notes="Provide cloud vendor details",response=ResponseEntity.class)
	    public ResponseEntity<Object> getCloudVendor(@PathVariable("vendorId") String vendorId)
	    {
	       return ResponseHandler.responseBuilder("Requested Vendor Details are given here",HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
	    }

	    // Read All Cloud Vendor Details from DB
	    @GetMapping("/")
	    public ResponseEntity<Object> getAllCloudVendorDetails()
	    {
		       return ResponseHandler.responseBuilder("Requested All Vendor Details are given here",HttpStatus.OK, cloudVendorService.getAllCloudVendors());
	    }

	    @PostMapping("/")
	    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	    {
	        cloudVendorService.createCloudVendor(cloudVendor);
	        return "Cloud Vendor Created Successfully";
	    }

	    @PutMapping("/")
	    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	    {
	        cloudVendorService.updateCloudVendor(cloudVendor);
	        return "Cloud Vendor Updated Successfully";
	    }

	    @DeleteMapping("/{vendorId}")
	    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
	    {
	        cloudVendorService.deleteCloudVendor(vendorId);
	        return "Cloud Vendor Deleted Successfully";
	    }
	
	

}
