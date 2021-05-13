package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.SpendingTracker;
import com.qa.hwa.repo.SpendRepo;

@Service
public class SpendService {
	
	private SpendRepo repo;
	
	public SpendService(SpendRepo repo) {
		this.repo = repo;
	}
	
	public SpendingTracker create(SpendingTracker s) {
		return this.repo.save(s);
	}
	
	public List<SpendingTracker> getAll(){
		return this.repo.findAll();		
	}
	
	public boolean remove(Long id) {
		this.repo.deleteById(id);
				
		return !this.repo.existsById(id);	
		}
	
	public SpendingTracker update(Long id, SpendingTracker newspendingTracker) {
		SpendingTracker expend = this.repo.findById(id).orElseThrow();
		expend.setAmount(newspendingTracker.getAmount());
		expend.setInfo(newspendingTracker.getInfo());
		expend.setType(newspendingTracker.getType());
		
		
		return this.repo.saveAndFlush(expend);
		
	}
	public SpendingTracker getByID(long id) {
		Optional<SpendingTracker> optionalID = this.repo.findById(id);
		if(optionalID.isPresent()) {
			return optionalID.get();
		}
		return null;
		
	}
}
