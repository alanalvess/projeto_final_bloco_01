package product;

import product.controller.ProductController;
import product.model.Console;
import product.model.Game;
import product.util.Colors;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		ProductController products = new ProductController();

		int option, type, code;
		String name, imageLink, consoleCategory, gameCategory;
		float price;

		Console console1 = new Console(products.generateCode(), "Xbox Series S", 4500.0f, 1, "Https", "Xbox");
		products.create(console1);

		Console console2 = new Console(products.generateCode(), "Playstation 5", 4000.0f, 1, "Https", "Playstation");
		products.create(console2);

		Game game1 = new Game(products.generateCode(), "Call of Duty", 190.0f, 2, "Https", "Shoot");
		products.create(game1);

		Game game2 = new Game(products.generateCode(), "God of War", 200.0f, 2, "Https", "Adventure");
		products.create(game2);

		products.listAllProducts();

		while (true) {

			System.out.printf("\n\n" +
					Colors.TEXT_YELLOW + Colors.ANSI_BLACK_BACKGROUND +
					"\n*****************************************************" +
					"\n                                                     " +
					"\n\tGame Z - The best gaming e-commerce!               " +
					"\n                                                     " +
					"\n*****************************************************" +
					"\n                                                     " +
					"\n\t\t1 - Create a Product                            " +
					"\n\t\t2 - List all Product                            " +
					"\n\t\t3 - Find Product by Code                        " +
					"\n\t\t4 - Update Product Details                       " +
					"\n\t\t5 - Delete a Product                             " +
					"\n\t\t6 - Exit                                         " +
					"\n                                                     " +
					"\n*****************************************************" +
					"\n\tEnter your choice:                                 " +
					"\n                                                     \n" + Colors.TEXT_RESET);

			try {
				option = read.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nEnter Integer Values!");
				read.nextLine();
				option = 0;
			}

			if (option == 6) {
				System.out.println(Colors.TEXT_WHITE_BOLD + "\nGame Z - The best gaming e-commerce!");
				about();
				read.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.printf(Colors.TEXT_WHITE + "Create a Product\n\n");

				System.out.println("Enter the Product Name: ");
				read.skip("\\R?");
				name = read.nextLine();

				System.out.println("Enter the Product Price: ");
				price = read.nextInt();

				System.out.println("Paste the Product Image URL: ");
				read.skip("\\R?");
				imageLink = read.nextLine();

				do {
					System.out.println("Enter the Product Category (1-Console ou 2-Game): ");
					type = read.nextInt();

				} while (type < 1 && type > 2);

				switch (type) {
				case 1 -> {
					System.out.println("Enter the Console Category: ");
					read.skip("\\R?");
					consoleCategory = read.nextLine();
					products.create(new Console(products.generateCode(), name, price, type, imageLink, consoleCategory));
				}

				case 2 -> {
					System.out.println("Enter the Game Category: ");
					read.skip("\\R?");
					gameCategory = read.nextLine();
					products.create(new Game(products.generateCode(), name, price, type, imageLink, gameCategory));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println(Colors.TEXT_WHITE + "List All Product\n\n");

				products.listAllProducts();

				keyPress();
				break;

			case 3:
				System.out.println(Colors.TEXT_WHITE + "Find Product by Code\n\n");

				System.out.println("Enter Product Code: ");
				code = read.nextInt();

				products.findByCode(code);

				keyPress();
				break;

			case 4:
				System.out.println(Colors.TEXT_WHITE + "Update Product Details\n\n");

				System.out.println("Enter the Product Code: ");
				code = read.nextInt();

				var findProduct = products.findInCollection(code);

				if (findProduct != null) {

					System.out.println("Enter the Product Name: ");
					read.skip("\\R?");
					name = read.nextLine();

					System.out.println("Enter the Product Price: ");
					price = read.nextInt();

					System.out.println("Paste the Product Image URL: ");
					read.skip("\\R?");
					imageLink = read.nextLine();

					type = findProduct.getType();

					switch (type) {
						case 1 -> {
							System.out.println("Enter the Console Category: ");
							read.skip("\\R?");
							consoleCategory = read.nextLine();
							products.update(new Console(code, name, price, type, imageLink, consoleCategory));
						}
						case 2 -> {
							System.out.println("Enter the Game Category: ");
							read.skip("\\R?");
							gameCategory = read.nextLine();
							products.update(new Game(code, name, price, type, imageLink, gameCategory));
						}

						default -> System.out.println("Invalid Product Type!");
					}

				} else {
					System.out.println("\nProduct not Found!");
				}

				keyPress();
				break;

			case 5:
				System.out.println(Colors.TEXT_WHITE + "Delete a Product\n\n");

				System.out.println("Enter the Product Code: ");
				code = read.nextInt();

				products.delete(code);

				keyPress();
				break;

			default:
				System.out.println(Colors.TEXT_RED_BOLD + "\nInvalid Option!\n" + Colors.TEXT_RESET);

				keyPress();
				break;
			}
		}

	}

	public static void about() {
		System.out.print("\n*********************************************************" +
				"\nProject Developed by:                                    " +
				"\nAlan Alves - alan.alvess@outlook.com                     " +
				"\nhttps://github.com/alanalvess                            " +
				"\n*********************************************************");
	}

	public static void keyPress() {

		try {
			System.out.println(Colors.TEXT_RESET + "\n\nPress Enter to Continue...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("You pressed a key other than enter!");
		}
	}
}
