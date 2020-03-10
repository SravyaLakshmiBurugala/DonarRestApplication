package com.pack.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.dto.DonarDto;
import com.pack.rest.service.impl.DonarServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class DonarController
{
	@Autowired
	DonarServiceImpl donarServiceImpl;
	
	@ApiOperation("Fetches List of Donars from Database")
	@ApiResponses({
		@ApiResponse(code=200, message = ""),
		@ApiResponse(code=401, message =""),
		@ApiResponse(code=404, message ="")
	})
	@GetMapping(value="/findAll")	
	public List<DonarDto> getAllDonars()
	{		
		return	donarServiceImpl.getAllDonars();
	}
	
	@ApiOperation("Fetch a secific donar from Database")
	@GetMapping(value="/find/{email}",produces="application/json")
	public DonarDto getDonarById(@PathVariable("email") String emailId)
	{
		return donarServiceImpl.getDonarById(emailId);
	}
	
	@ApiOperation("Add a new Donar from Implementation")
	@PostMapping(value="/createDonar", consumes="application/json", produces="text/plain" )
	public String saveDonar(@RequestBody DonarDto dto)
	{
		boolean flag=donarServiceImpl.saveDonar(dto);
		
		if(flag==true)
			return "Donar Details saved successfully";
		else
			return "Donar alreday exist";
			
	}
	
	@ApiOperation("Update donar from Implementation")
	@PutMapping(value="/updateDonarByEmailId", consumes="application/json", produces="text/plain" )
	public String updateDonar(@RequestBody DonarDto dto)
	{	
		boolean flag=donarServiceImpl.updateDonarById(dto);	
		
		if(flag==true)
			return "Doanar Details Updated Successfully";
		else
			return "Donar doesn't exist";
	}
	
	@ApiOperation("Delete Donar from Implementation")
	@DeleteMapping(value="/deleteDonarById/{emailId}", produces="text/plain")
	public String deleteDonarById(@PathVariable("emailId") String email)
	{
		System.out.println("Entered into donar delete controller");
		
		boolean flag=donarServiceImpl.deleteDonarById(email);
		if(flag==true)
			return "Donar Deleted Successfully";
		else
			return "Donar doesn't exist";
	}
	
	
}
