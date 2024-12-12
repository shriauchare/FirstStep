package com.example.FirstStep.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FirstStep.model.CloudVendor;

@Service
public interface CloudVendorService {
	
	public CloudVendor getCloudVendor(String vendorId);
	public List<CloudVendor> getAllCloudVendors();
	public String createCloudVendor(CloudVendor cloudVendor);
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(String vendorId);
	
}
