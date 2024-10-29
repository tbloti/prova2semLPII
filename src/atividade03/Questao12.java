package atividade03;

import java.util.Scanner;

public class Questao12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int TAM = 3; //constante
		String [] produto = new String [TAM];
		int [] quantidade = new int[TAM];
		double [] preco = new double[TAM];
		double faturamento=0, totalFaturamento=0;
		
		for (int i=0; i< produto.length; i++) {
			System.out.println("Digite o nome do produto: ");
			produto[i] = scan.next();
			System.out.println("Digite a quantidade do produto: ");
			quantidade[i] = scan.nextInt();
			System.out.println("Digite o pre�o do produto: ");
			preco[i] = scan.nextDouble();
		}
		for (int i=0; i< produto.length; i++) {
			faturamento = quantidade[i] * preco[i];
			System.out.println("o faturamento do produto "+produto[i]+
					" � "+faturamento);
			totalFaturamento += faturamento;
		}
		System.out.println("o faturamento total � "+totalFaturamento);
		scan.close();
	}
}
