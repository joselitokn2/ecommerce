package com.wirtz.ecommerce.model.product;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


import com.wirtz.ecommerce.model.util.CalendarUtil;

@Entity
public class Product {
	
	@Column(name = "productId")
	private Long productId;
	private String name;
	private double price;
	private long stock;
	private Calendar creationDate;
    private long version;

	
	public Product(){
	}
	
	public Product( String name, double price, long stock,
			Calendar creationDate) {
		/**
		 * NOTE: "productId" *must* be left as "null" since 
		 * its value is automatically generated.
		 */ 
	//	this.category = category;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.creationDate = creationDate;
	}

	@Column(name="prodId")
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY
                   )
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	@Column(name="crtDate")
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	@Override
	public int hashCode() {
		return creationDate == null ? 0 : creationDate.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		final Product other = (Product) obj;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (productId == null) {
			if (other.getProductId() != null)
				return false;
		} else if (!productId.equals(other.getProductId()))
			return false;
		if (stock != other.getStock())
			return false;
		if (!(CalendarUtil.compare (creationDate,other.getCreationDate())))
			return false;
		if (version != other.getVersion())
			return false;
		return true;
	}

	public String toString(){
		return "Product ID = " + this.getProductId()+" name = " + this.getName() + " price = " + this.getPrice() + "\n"
		+ " stock = " + this.getStock() + " creationDate = " + this.getCreationDate().toString() + " version = " + this.getVersion();
	}



}