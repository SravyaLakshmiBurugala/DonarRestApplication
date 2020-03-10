package com.pack.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.dto.DonarDto;
import com.pack.rest.entiry.Donar;
import com.pack.rest.repository.DonarRepository;
import com.pack.rest.service.IDonarService;


@Service
public class DonarServiceImpl implements IDonarService
{
	
	@Autowired
	DonarRepository donarRepository;

	@Override
	public List<DonarDto> getAllDonars() {

		List<Donar> donarList = donarRepository.findAll();
		
		List<DonarDto> donarDtoList = new ArrayList<>();
		
		for(Donar donar:donarList)
		{
			DonarDto dto=new DonarDto();
			
			BeanUtils.copyProperties(donar, dto);
			
			donarDtoList.add(dto);			
		}
		
		return donarDtoList;
	}

	@Override
	public DonarDto getDonarById(String email) {

		Optional<Donar> opt=donarRepository.findById(email);		
		
		Donar donar=opt.get();
		
		DonarDto dto=new DonarDto();
		
		BeanUtils.copyProperties(donar, dto);
		
		
		return dto;
		
	}

	@Override
	public boolean updateDonarById(DonarDto dto) {

		boolean flag=donarRepository.existsById(dto.getEmail());
		
		if(flag==true) 
		{
			Donar donar=new Donar();
			BeanUtils.copyProperties(dto, donar);
			
			donarRepository.saveAndFlush(donar);
			
			return true;
		}
		else
			return false;
				
	}

	@Override
	public boolean saveDonar(DonarDto dto) {

		boolean flag=donarRepository.existsById(dto.getEmail());
		
		if(flag==false)
		{
			Donar donar=new Donar();
			
			BeanUtils.copyProperties(dto, donar);
			
			donarRepository.saveAndFlush(donar);
			
			return true;
			
			
		}else
			return false;
		
	}

	@Override
	public boolean deleteDonarById(String email) {
		
		System.out.println("Entered into donar service impl delete");
		
		boolean flag=donarRepository.existsById(email);
		
		if(flag==true)
		{
			donarRepository.deleteById(email);
			
			return true;
		}
		else
		return false;
	}

}
