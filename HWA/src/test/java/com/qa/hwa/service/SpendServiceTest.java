package com.qa.hwa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.hwa.domain.SpendingTracker;
import com.qa.hwa.repo.SpendRepo;

@SpringBootTest
public class SpendServiceTest {
	@Autowired
	private SpendService service;
	@MockBean
	private SpendRepo repo;

	@Test
	void testCreate() {
		SpendingTracker s = new SpendingTracker(12.99, "Eating Out", "KFC");
		SpendingTracker SavedExpenditure = new SpendingTracker(1L, 12.99, "Eating Out", "KFC");

		Mockito.when(this.repo.save(s)).thenReturn(SavedExpenditure);

		assertThat(this.service.create(s)).isEqualTo(SavedExpenditure);

		Mockito.verify(this.repo, Mockito.times(1)).save(s);

	}

	@Test
	void testgetAll() {
		List<SpendingTracker> expected = new ArrayList<>();

		expected.add(new SpendingTracker(1L, 12.99, "Eating Out", "KFC"));

		Mockito.when(this.repo.findAll()).thenReturn(expected);

		assertThat(this.service.getAll()).isEqualTo(expected);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	void testgetByID() {
		Long id = 1L;

		Optional<SpendingTracker> optionalID = Optional.ofNullable(new SpendingTracker(1L, 12.99, "Eating Out", "KFC"));
		SpendingTracker exp = new SpendingTracker(1L, 12.99, "Eating Out", "KFC");
		Mockito.when(this.repo.findById(id)).thenReturn(optionalID);
		assertThat(this.service.getByID(id)).isEqualTo(exp);
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);

	}

	@Test
	void testRemove() {
	Long id = 1L;
	Mockito.when(this.repo.existsById(id)).thenReturn(false);
	assertThat(this.service.remove(id)).isTrue();
	Mockito.verify(this.repo,Mockito.times(1)).existsById(id);		

	}
	
	@Test
	void testUpdate() {
		Long id =1L;
		SpendingTracker amend = new SpendingTracker(12.99, "Eating Out", "KFC");
		Optional<SpendingTracker> current = Optional.ofNullable(new SpendingTracker(id,19.99, "Shopping", "Jeans"));
		
		SpendingTracker update = new SpendingTracker(id,amend.getAmount(),amend.getType(),amend.getInfo());
		
		Mockito.when(this.repo.findById(id)).thenReturn(current);
		Mockito.when(this.repo.saveAndFlush(update)).thenReturn(update);
		assertThat(this.service.update(id, amend)).isEqualTo(update);
		
		Mockito.verify(this.repo,Mockito.times(1)).findById(id);
		Mockito.verify(this.repo,Mockito.times(1)).saveAndFlush(update);
	}
}
