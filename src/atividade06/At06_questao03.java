package atividade06;

import java.util.Scanner;

public class At06_questao03 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		final int TAM=3;
		double [] produtoEnlatado = new double[TAM];
		double [] produtoEnsacolado = new double[TAM];
		char opcao;
		do {
			System.out.println("\n1. cadastar pre�os\n"
					+ "2. mostrar menor pre�o\n"
					+ "3. mostrar quantidade de produtos maiores que 1000\n"
					+ "4. sair");
			opcao = scan.next().charAt(0);
			switch(opcao) {
			case '1':
				System.out.println("cadastrar os pre�os dos produtos enlatados\n");
				preencherDados(produtoEnlatado);
				System.out.println("cadastrar os pre�os dos produtos ensacolados\n");
				preencherDados(produtoEnsacolado);
				break;
			case '2':
				System.out.println("o menor pre�o do produto enlatado � "+
						procurarMenor(produtoEnlatado));
				System.out.println("o menor pre�o do produto ensacolado � "+
						procurarMenor(produtoEnsacolado));

				break;
			case '3':
				System.out.println("\na quantidade de produtos enlatados com pre�o "
						+ "maior que 1000 � "+somarMaior1000(produtoEnlatado));
				System.out.println("\na quantidade de produtos ensacolados com pre�o "
						+ "maior que 1000 � "+somarMaior1000(produtoEnsacolado));
				break;
			case '4':
				break;
			default:
				System.out.println("op��o inv�lida.");
			}
		} while (opcao != '4');
	}
	static int somarMaior1000(double [] v) {
		int soma = 0;
		for (int i=0; i< v.length;i++) {
			if (v[i]> 1000) {
				soma++;
			}
		}
		return soma;
	}

	static void preencherDados(double [] v) {
		for (int i=0; i< v.length;i++) {
			System.out.println("Digite o pre�o do produto:");
			v[i] = scan.nextDouble();
		}
	}
	static double procurarMenor(double [] v) {
		int menor = 0;
		for (int i=1; i< v.length;i++) {
			if (v[i] < v[menor]) {
				menor = i;
			}
		}
		return v[menor];
	}
}
