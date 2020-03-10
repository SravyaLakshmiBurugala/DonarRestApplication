package com.pack.rest.service;

import java.util.List;

import com.pack.entity.dto.DonarDto;
import com.pack.rest.entiry.Donar;

public interface IDonarService {
	
	public List<DonarDto> getAllDonars();
	
	public DonarDto getDonarById(String email);
	
	public boolean updateDonarById(DonarDto dto);
	
	public boolean saveDonar(DonarDto dto);
	
	public boolean deleteDonarById(String email);
	

}
