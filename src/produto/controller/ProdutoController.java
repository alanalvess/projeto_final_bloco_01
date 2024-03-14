package produto.controller;

import produto.model.Produto;
import produto.repository.ProdutoRepository;

import java.util.ArrayList;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	int codigo = 0;

	@Override
	public void procurarPorCodigo(int codigo) {

		var produto = buscarNaCollection(codigo);

		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println("\nO Codigo de Produto: " + codigo + " não foi encontrado!");
		}

	}

	@Override
	public void listarTodosProdutos() {
		for (var produto : produtos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		produtos.add(produto);
		System.out.printf("\nO produto " + produto.getNome() + " foi cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {

		var buscaCodigo = buscarNaCollection(produto.getCodigo());

		if (buscaCodigo != null) {
			produtos.set(produtos.indexOf(buscaCodigo), produto);
			System.out.println("\nA Conta numero: " + produto.getCodigo() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA Conta numero: " + produto.getCodigo() + " não foi encontrada!");
		}

	}

	@Override
	public void deletar(int codigo) {
		var produto = buscarNaCollection(codigo);

		if (produto != null) {
			if (produtos.remove(produto) == true) {
				System.out.println("\nO Produto de Código: " + codigo + " foi deletado com sucesso!");
			}
		} else {
			System.out.println("\nO Código de Produto: " + codigo + " não foi encontrado!");
		}

	}

	public int gerarCodigo() {
		return ++codigo;
	}

	public Produto buscarNaCollection(int codigo) {
		for (var produto : produtos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}

		return null;
	}

}
