package br.com.incomeService.infrastructure;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.incomeService.domain.Income;

public interface IncomeRepository extends CrudRepository<Income, Long>{
	
	List<Income> findAll();

}
