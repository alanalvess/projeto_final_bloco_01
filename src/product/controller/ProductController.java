package product.controller;

import product.model.Product;
import product.repository.ProductRepository;

import java.util.ArrayList;

public class ProductController implements ProductRepository {

	private final ArrayList<Product> products = new ArrayList<>();

	int code = 0;

	@Override
	public void findByCode(int code) {

		var product = findInCollection(code);

		if (product != null) {
			product.view();
		} else {
			System.out.printf("\nProduct code %d was not found", code);
		}

	}

	@Override
	public void listAllProducts() {
		for (var product : products) {
			product.view();
		}
	}

	@Override
	public void create(Product product) {
		this.products.add(product);
		System.out.printf("\nproduct %s was successfully registered", product.getName());
	}

	@Override
	public void update(Product product) {

		var findCode = findInCollection(product.getCode());

		if (findCode != null) {
			this.products.set(this.products.indexOf(findCode), product);
			System.out.printf("\nAccount number %d has been updated successfully!", product.getCode());
		} else {
			System.out.printf("\nAccount number %d was not found!", product.getCode());
		}

	}

	@Override
	public void delete(int code) {
		var product = findInCollection(code);

		if (product != null) {
			if (products.remove(product)) {
				System.out.printf("\nProduct Code %d has been successfully deleted!", code);
			}
		} else {
			System.out.printf("\nProduct Code %d was not found!", code);
		}

	}

	public int generateCode() {
		return ++code;
	}

	public Product findInCollection(int code) {
		for (var product : products) {
			if (product.getCode() == code) {
				return product;
			}
		}

		return null;
	}

}
