package produto.model;

public abstract class Produto {
	private int codigo;
	private String nome;
	private String tipo;
	private float valor;
	private String linkImagem;

	public Produto(int codigo, String nome, String tipo, float valor, String linkImagem) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.linkImagem = linkImagem;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case "Console":
			tipo = "Console";
			break;

		case "Jogos":
			tipo = "Jogos";
			break;
		}

		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Produto:");
		System.out.println("***********************************************************");
		System.out.println("Nome: " + this.nome);
		System.out.println("Valor: " + this.valor);
		System.out.println("Categoria do Produto: " + tipo);
		System.out.println("Link da Imagem: " + this.linkImagem);

	}
}
