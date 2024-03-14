package produto;

import produto.controller.ProdutoController;
import produto.model.Console;
import produto.model.Jogo;
import produto.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ProdutoController produtos = new ProdutoController();

		int opcao, tipo, codigo, categoriaConsole, categoriaJogo;
		String nome;
		float valor;

		Console console1 = new Console(produtos.gerarCodigo(), "Xbox Series S", 4500.0f, 1, 1);
		produtos.cadastrar(console1);

		Console console2 = new Console(produtos.gerarCodigo(), "Playstation 5", 4000.0f, 1, 2);
		produtos.cadastrar(console2);

		Jogo jogo1 = new Jogo(produtos.gerarCodigo(), "Call Of Duty", 4500.0f, 1, 1);
		produtos.cadastrar(jogo1);

		Jogo jogo2 = new Jogo(produtos.gerarCodigo(), "Good of War", 4500.0f, 1, 2);
		produtos.cadastrar(jogo2);

		produtos.listarTodosProdutos();

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                        Game Z                       ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Adicionar um Produto                 ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por Código            ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Excluir um Produto                   ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nGame Z - O site de games mais barato da internet!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Adicionar um Produto\n\n");

				System.out.println("Digite o Nome do Produto: ");
				leia.skip("\\R?");
				nome = leia.nextLine();

				System.out.println("Digite o Valor do Produto: ");
				valor = leia.nextInt();

				do {
					System.out.println("Digite a Categoria do Produto (1-Console ou 2-Jogo): ");
					tipo = leia.nextInt();

				} while (tipo < 1 && tipo > 2);

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite a Categoria do Console: ");
					categoriaConsole = leia.nextInt();
					produtos.cadastrar(new Console(produtos.gerarCodigo(), nome, valor, tipo, categoriaConsole));
				}

				case 2 -> {
					System.out.println("Digite a Categoria do Jogo: ");
					categoriaJogo = leia.nextInt();
					produtos.cadastrar(new Jogo(produtos.gerarCodigo(), nome, valor, tipo, categoriaJogo));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");

				produtos.listarTodosProdutos();

				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar Produto por Código\n\n");

				System.out.println("Digite o Código do Produto: ");
				codigo = leia.nextInt();

				produtos.procurarPorCodigo(codigo);

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados do Produto\n\n");

				System.out.println("Digite o Código do Produto: ");
				codigo = leia.nextInt();

				var buscaProduto = produtos.buscarNaCollection(codigo);

				if (buscaProduto != null) {

					System.out.println("Digite o Nome do Produto: ");
					leia.skip("\\R?");
					nome = leia.nextLine();

					System.out.println("Digite o Valor do Produto: ");
					valor = leia.nextInt();

					tipo = buscaProduto.getTipo();

					switch (tipo) {
						case 1 -> {
							System.out.println("Digite a Categoria do Console: ");
							categoriaConsole = leia.nextInt();
							produtos.atualizar(new Console(codigo, nome, valor, tipo, categoriaConsole));
						}
						case 2 -> {
							System.out.println("Digite a Categoria do Jogo: ");
							categoriaJogo = leia.nextInt();
							produtos.atualizar(new Jogo(codigo, nome, valor, tipo, categoriaJogo));
						}

						default -> {
							System.out.println("Tipo de Produto Inválido!");
						}
					}

				} else {
					System.out.println("\nProduto não encontrado!");
				}

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE + "Excluir um Produto\n\n");

				System.out.println("Digite o Código do Produto: ");
				codigo = leia.nextInt();

				produtos.deletar(codigo);

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);

				keyPress();
				break;
			}
		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por:                                ");
		System.out.println("Alan Alves - alan.alvess@outlook.com                     ");
		System.out.println("https://github.com/alanalvess                            ");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
