package br.com.incomeService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "income")
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name; 
	private float projectedValue; 
	private float realValue; 
	private String dateIncome; 
	private String category;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getProjectedValue() {
		return projectedValue;
	}
	public void setProjectedValue(float projectedValue) {
		this.projectedValue = projectedValue;
	}
	public float getRealValue() {
		return realValue;
	}
	public void setRealValue(float realValue) {
		this.realValue = realValue;
	}
	public String getDateIncome() {
		return dateIncome;
	}
	public void setDateIncome(String dateIncome) {
		this.dateIncome = dateIncome;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
