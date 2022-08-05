package com.HDAO.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Bookprod")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	
	@Column
	@DecimalMin("100")
	@DecimalMax("10000")
	private float prodPrice;
	
	@NotEmpty(message ="product name must not be empty")
	@Size(min = 4,max = 16)
	private String prodName;
	
	@NotEmpty(message ="link must be provided")
	private String link;
	
	@NotEmpty(message ="product description must not be empty")
	@Column(length = 2000000000)
	private String prodDesc;


	
	public Product() {
		super();
	}

	public Product(float prodPrice, String prodName, String prodDesc) {
		super();
		this.prodPrice = prodPrice;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
	}
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public Float getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	
	

}
