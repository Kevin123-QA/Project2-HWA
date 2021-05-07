package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.spendingTracker;
import com.qa.hwa.repo.SpendRepo;

@Service
public class SpendService {
	
	private SpendRepo repo;
	
	public SpendService(SpendRepo repo) {
		this.repo = repo;
	}
	
	public spendingTracker create(spendingTracker s) {
		return this.repo.save(s);
	}
	
	public List<spendingTracker> getAll(){
		return this.repo.findAll();		
	}
	
	public boolean remove(Long id) {
		this.repo.deleteById(id);
				
		return !this.repo.existsById(id);	
		}
	
	public spendingTracker update(Long id, spendingTracker newspendingTracker) {
		spendingTracker expend = this.repo.findById(id).orElseThrow();
		expend.setAmount(newspendingTracker.getAmount());
		expend.setInfo(newspendingTracker.getInfo());
		expend.setType(newspendingTracker.getType());
		
		
		return this.repo.saveAndFlush(expend);
		
	}
	public spendingTracker getByID(long id) {
		Optional<spendingTracker> optionalID = this.repo.findById(id);
		return optionalID.get();
		
	}
}
