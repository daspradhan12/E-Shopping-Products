package com.hackrank.shopping.product.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackrank.shopping.product.model.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product,Long>  {

	public List<Product> findAllByOrderByIdAsc();

    public List<Product> findByCategoryOrderByDiscountedPrice(String category);

    public List<Product> findByCategoryAndAvailability(String category, Boolean availability);
}
