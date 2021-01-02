package br.com.incomeService.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.incomeService.infrastructure.IncomeRepository;

@Service
public class IncomeService {

	private IncomeRepository repository;

	public IncomeService(IncomeRepository repository) {
		this.repository = repository;
	}

	public List<Income> findAll() {
		return repository.findAll();
	}

	public Optional<Income> findById(Long id) {
		return repository.findById(id);
	}

	public Income create(Income data) {
		return repository.save(data);
	}

	public ResponseEntity<Income> update(Long id, Income data) {
		return repository.findById(id).map(record -> {
			record.setCategory(data.getCategory());
			record.setProjectedValue(data.getProjectedValue());
			record.setRealValue(data.getRealValue());
			record.setDateIncome(data.getDateIncome());
			record.setName(data.getName());
			record.setDescription(data.getDescription());
			Income newIncome = repository.save(record);
			return ResponseEntity.ok().body(newIncome);
		}).orElse(ResponseEntity.notFound().build());
	}

	public Optional<?> delete(Long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		});
	}

}
