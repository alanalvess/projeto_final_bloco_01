package product.repository;

import product.model.Products;

public interface ProductRepository {

	void create(Products products);

	void update(Products products);

	void listAllProducts();

	void findByCode(int code);

	void delete(int code);
}
