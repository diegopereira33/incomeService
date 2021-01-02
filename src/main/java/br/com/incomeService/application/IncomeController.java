package br.com.incomeService.application;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.incomeService.domain.Income;
import br.com.incomeService.domain.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {

	private IncomeService service;

	public IncomeController(IncomeService service) {
		this.service = service;
	}

	@CrossOrigin
	@GetMapping
	public List<Income> findAll() {
		return service.findAll();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Income findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found"));
	}

	@CrossOrigin
	@PostMapping
	public Income create(@RequestBody Income data) {
		return service.create(data);
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Income> update(@PathVariable("id") long id, @RequestBody Income data) {
		return service.update(id, data);
	}

	@CrossOrigin
	@DeleteMapping(path = { "/{id}" })
	public Optional<?> delete(@PathVariable long id) {
		service.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Debt not found"));

		return service.delete(id);
	}

}
