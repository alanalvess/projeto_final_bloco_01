package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.produto.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao, codigo;
		String nome, linkImagem;
		float valor, tamanho;

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

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");

				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar Produto por Código\n\n");

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados do Produto\n\n");

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_WHITE + "Excluir um Produto\n\n");

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
