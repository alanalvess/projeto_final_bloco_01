package produto.model;

public class Jogo extends Produto {

	private int categoriaJogo;

	public Jogo(int codigo, String nome, float valor, int tipo, int categoriaJogo) {
		super(codigo, nome, valor, tipo);
		this.setCategoriaJogo(categoriaJogo);
	}

	public int getCategoriaJogo() {
		return categoriaJogo;
	}

	public void setCategoriaJogo(int categoriaJogo) {
		this.categoriaJogo = categoriaJogo;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Categoria do Jogo: " + this.categoriaJogo);
	}
}
