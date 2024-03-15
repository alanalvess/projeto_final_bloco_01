package product.model;

public class Console extends Products {

	private String consoleCategory;

	public Console(int code, String name, float price, int type, String linkImage, String consoleCategory) {
		super(code, name, price, type, linkImage);
		this.consoleCategory = consoleCategory;
	}

	public String getConsoleCategory() {
		return consoleCategory;
	}

	public void setConsoleCategory(String consoleCategory) {
		this.consoleCategory = consoleCategory;
	}

	@Override
	public void view() {
		super.view();
		System.out.printf("\nConsole Category: %s", this.consoleCategory);
	}

}
