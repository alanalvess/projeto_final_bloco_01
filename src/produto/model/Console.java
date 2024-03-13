package produto.model;

public class Console extends Produto {

	private String categoriaConsole;

	public Console(int codigo, String nome, String tipo, float valor, String linkImagem, String categoriaConsole) {
		super(codigo, nome, tipo, valor, linkImagem);
		this.setCategoriaConsole(categoriaConsole);
	}

	public String getCategoriaConsole() {
		return categoriaConsole;
	}

	public void setCategoriaConsole(String categoriaConsole) {
		this.categoriaConsole = categoriaConsole;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Categoria do Console: " + this.categoriaConsole);
	}

}
