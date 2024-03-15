package product.model;

public abstract class Products {

	private int code;
	private String name;
	private float price;
	private int type;
	private String linkImage;

	public Products(int code, String name, float price, int type, String linkImage) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.type = type;
		this.linkImage = linkImage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public void view() {

		String type = "";

		switch (this.type) {
			case 1:
				type = "Console";
				break;

			case 2:
				type = "Game";
				break;
		}

		System.out.printf("\n\n***********************************************************" +
				"\nProduct Details:" +
				"\n***********************************************************" +
				"\nProduct Code: %d" +
				"\nProduct Name: %s" +
				"\nProduct Price: %.2f" +
				"\nProduct Type: %s",
				this.code, this.name, this.price, type);

	}
}
