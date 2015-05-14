package com.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marcus
 *TOOODOOO
 */
@Entity
@Table(name="order_details")
public class OrderDetail extends AbstractBaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8115603554339681758L;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "book_id")
	private Book book;
	
	/**
	 * 
	 */
	@ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
	
	@Column(name = "quantity")
	private Integer quantity = 1;
	
	@Column(name = "price_each")
    private Double priceEach;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
