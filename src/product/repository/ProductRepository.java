package product.repository;

import product.model.Product;

public interface ProductRepository {

	void create(Product product);

	void update(Product product);

	void listAllProducts();

	void findByCode(int code);

	void delete(int code);
}
