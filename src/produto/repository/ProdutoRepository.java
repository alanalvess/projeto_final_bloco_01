package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {

	public void cadastrar(Produto produto);

	public void atualizar(Produto produto);

	public void listarTodosProdutos();

	public void procurarPorCodigo(int codigo);

	public void deletar(int codigo);
}
