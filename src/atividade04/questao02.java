package atividade04;

import java.util.Scanner;

public class questao02 {

	public static void main(String[] args) {
		final int TAM = 8;
		Scanner scan = new Scanner(System.in);
		int [] numeros = new int[TAM];
		int aux, pos;
		for (int i = 0; i < TAM; i++) {
			System.out.println("Digite um n�mero inteiro:");
			numeros[i] = scan.nextInt();
		}
		for (int i=0;i< TAM-1; i++) {
			for (int j=0; j< TAM-1-i;j++) {
				if (numeros[j]>numeros[j+1]) {
					aux = numeros[j];
					numeros[j]=numeros[j+1];
					numeros[j+1]= aux;
				}
			}
		}
		System.out.println("\nvetor ordenado:\n");
		for (int i = 0;i < TAM;i++) {
			System.out.print(numeros[i]+" ");
		}
		System.out.println("Digite um valor a ser procurado: ");
		aux = scan.nextInt();
		pos = 0;
		while ((pos < TAM) && (numeros[pos]!=aux)){
			pos++; //caminha no vetor
		}
		if (pos == TAM) {
			System.out.println("O valor n�o foi encontrado no vetor.");
		}else {
			System.out.println("O valor est� na posi��o "+pos);
		}
		scan.close();
	}

}
