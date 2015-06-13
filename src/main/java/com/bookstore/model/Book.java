package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="book")
public class Book extends AbstractBaseEntity{
	
	private static final long serialVersionUID = 2622508152191407050L;
	
	@Pattern(regexp = "^(?=\\s*\\S).*$")
	@Column(nullable = false, length = 255)
	private String name;
	
	@Pattern(regexp = "^(?=\\s*\\S).*$")
	@Column(nullable = false, length = 255)
	private String author;
	
	@NotNull
	@DecimalMin(value="2.0")
	@DecimalMax(value="200.0")
	private Double price;
	
	@Pattern(regexp = "^(?=\\s*\\S).*$")
	@Column(nullable = false, length = 255)
	private String publisher;
	
	@NotNull
	@Column(nullable = false)
	private int amount; 
	
	
	/**
	 * Category of book
	 */
	@NotNull
	@ManyToOne(optional = true)
	@JoinColumn(name = "category_id", nullable = true)
	private Category category;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
