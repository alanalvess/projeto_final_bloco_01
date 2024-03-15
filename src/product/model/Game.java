package product.model;

public class Game extends Products {

	private String gameCategory;

	public Game(int code, String name, float price, int type, String linkImage, String gameCategory) {
		super(code, name, price, type, linkImage);
		this.gameCategory = gameCategory;
	}

	public String getGameCategory() {
		return gameCategory;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}

	@Override
	public void view() {
		super.view();
		System.out.printf("\nGame category: %s", this.gameCategory);
	}
}
