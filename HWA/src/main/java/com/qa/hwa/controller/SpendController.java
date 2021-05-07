package com.qa.hwa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.spendingTracker;
import com.qa.hwa.service.SpendService;

@RestController
@CrossOrigin
public class SpendController {
	
	private SpendService service;
	
	public SpendController(SpendService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<spendingTracker> create(@RequestBody spendingTracker spent){
		return new ResponseEntity<spendingTracker>(this.service.create(spent),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<spendingTracker>> getspendingTracker(){
		return ResponseEntity.ok(this.service.getAll());
	}
	@DeleteMapping("/delete/{id}")
	public boolean remove(@PathVariable Long id) {
		return  this.service.remove(id);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<spendingTracker> update(@RequestBody spendingTracker s,@PathVariable Long id){
		return new ResponseEntity<spendingTracker>(this.service.update(id, s),HttpStatus.ACCEPTED);
		
		
	}
}
