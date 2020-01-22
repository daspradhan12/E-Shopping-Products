package com.hackrank.shopping.product.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id","name","category","retail_price","discounted_price","availability"})
@Entity
@Table(name="VProduct")

public class Product {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="product_id")
    private Long id;
	@Column(name="product_name")
    private String name;
	@Column(name="product_category")
    private String category;
    @JsonProperty("retail_price")
    @Column(name = "retailprice")
    private Double retailPrice;
    @JsonProperty("discounted_price")
    @Column(name = "discountedprice")
    private Double discountedPrice = 0.0;
    private Boolean availability;

    public Product() {
    }

    public Product(Long id, String name, String category, Double retailPrice, Double discountedPrice, Boolean availability) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.availability = availability;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id=" ).append(id).append(", name=").append(name)
               .append(", category=").append(category).append(", retail_price=").append(retailPrice)
        .append(", discounted_price=").append(discountedPrice).append(", availability").append(availability);
        return builder.toString();
    }
}

