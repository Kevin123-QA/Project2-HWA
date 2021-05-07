package com.qa.hwa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.domain.spendingTracker;

@Repository
public interface SpendRepo extends JpaRepository<spendingTracker, Long>{
	spendingTracker findByType(String type);

}
