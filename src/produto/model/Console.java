package produto.model;

public class Console extends Produto {

	private int categoriaConsole;

	public Console(int codigo, String nome, float valor, int tipo, int categoriaConsole) {
		super(codigo, nome, valor, tipo);
		this.setCategoriaConsole(categoriaConsole);
	}

	public int getCategoriaConsole() {
		return categoriaConsole;
	}

	public void setCategoriaConsole(int categoriaConsole) {
		this.categoriaConsole = categoriaConsole;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Categoria do Console: " + this.categoriaConsole);
	}

}
