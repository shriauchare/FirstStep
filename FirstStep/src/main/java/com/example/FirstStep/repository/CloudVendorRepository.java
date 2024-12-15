package com.example.FirstStep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FirstStep.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,Object> {
	List<CloudVendor> findByVendorName(String vendorName);
	
}
