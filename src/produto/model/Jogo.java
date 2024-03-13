package produto.model;

public class Jogo extends Produto {

	private String categoriaJogo;

	public Jogo(int codigo, String nome, String tipo, float valor, String linkImagem, String categoriaJogo) {
		super(codigo, nome, tipo, valor, linkImagem);
		this.categoriaJogo = categoriaJogo;
	}

	public String getCategoriaJogo() {
		return categoriaJogo;
	}

	public void setCategoriaJogo(String categoriaJogo) {
		this.categoriaJogo = categoriaJogo;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Categoria do Jogo: " + this.categoriaJogo);
	}
}
