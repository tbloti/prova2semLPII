package atividade06;

import java.util.Scanner;

public class At06_questao01 {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int [] vetor = new int[10];
		preencherVetor(vetor);
		System.out.println("a soma dos valores é "+somarValores(vetor));
	}
	static void preencherVetor(int [] v) {
		for (int i=0; i<v.length; i++) {
			System.out.println("Digite um valor:");
			v[i] = scan.nextInt();
		}
	}
	static int somarValores(int [] v) {
		int soma =0;
		for (int i=0; i<v.length; i++) {
			soma += v[i];
		}
		return soma;
	}
	
	
	
}
