package com.example.FirstStep.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FirstStep.exception.CloudVendorException;
import com.example.FirstStep.exception.CloudVendorNotFoundException;
import com.example.FirstStep.model.CloudVendor;
import com.example.FirstStep.repository.CloudVendorRepository;
import com.example.FirstStep.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
	
	CloudVendorRepository cloudVendorRepository;

	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		super();
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public CloudVendor getCloudVendor(String vendorId) {
		// TODO Auto-generated method stub
		
		if(cloudVendorRepository.findById(vendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested Cloud Vendor does not exist");
		
		return cloudVendorRepository.findById(vendorId).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendors() {
		// TODO Auto-generated method stub
		return cloudVendorRepository.findAll();
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		// TODO Auto-generated method stub
		cloudVendorRepository.save(cloudVendor);
		return "Created Cloud Vendor Successfully";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		// TODO Auto-generated method stub
		cloudVendorRepository.save(cloudVendor);
		return "Updated Cloud Vendor Successfully";
	}

	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
		cloudVendorRepository.deleteById(cloudVendorId);
		return "Deleted Cloud Vendor Successfully";
	}

	@Override
	public List<CloudVendor> findByVendorName(String vendorName) {
		// TODO Auto-generated method stub
		return cloudVendorRepository.findByVendorName(vendorName);
	}
	
	

}
