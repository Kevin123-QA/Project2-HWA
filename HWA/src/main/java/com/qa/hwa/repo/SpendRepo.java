package com.qa.hwa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.domain.SpendingTracker;

@Repository
public interface SpendRepo extends JpaRepository<SpendingTracker, Long>{
	SpendingTracker findByType(String type);

}
