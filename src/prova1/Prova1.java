package prova1;

import java.util.Scanner;

public class Prova1 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		final int TAM = 2;
		String [] nome = new String [TAM];
		String [] estado = new String[TAM];
		double [] faturamento = new double[TAM];
		char opcao;
		do {
			System.out.println("1.cadastrar dados\n"
					+ "2. mostrar fornecedores de Sergipe\n"
					+ "3. mostrar faturamento de todos fornecedores\n"
					+ "4. mostrar media faturamento\n"
					+ "5. sair");
			opcao = scan.next().charAt(0);
			switch (opcao) {
			case '1':
				preencherDados(nome,estado,faturamento);
				break;
			case '2':
				System.out.println("fornecedor de Sergipe:"+procurarFornecedor(nome, estado));
				break;
			case '3':
				System.out.println("Faturamento de todos os fornecedores:"+somarFaturamento(faturamento));
				break;
			case '4':
				System.out.println("Media de Faturamento = "+calcularMediaFaturamento(faturamento));
				break;
			case '5':
				System.out.println("fim do programa");
				break;
			default:
				System.out.println("opção inválida.");
					
			}
		}while (opcao!= '5');

	}
	static void preencherDados(String [] nom,String [] est,double [] fat) {
		for (int i=0; i< nom.length; i++) {
			System.out.println("Digite o nome do fornecedor:");
			nom[i]=scan.next();
			System.out.println("Digite o estado do fornecedor:");
			est[i] = scan.next();
			System.out.println("Digite o faturamento:");
			fat[i] = scan.nextDouble(); 
		}
	}
	static String procurarFornecedor(String [] nom,String [] est) {
		for (int i=0; i< nom.length; i++) {
			if (est[i].equalsIgnoreCase("SE")) {
				return nom[i]+ "\n";
			}
		}
		return "não foi encontrado o fornecedor de Sergipe";
	}
	static double somarFaturamento(double [] fat) {
		double soma = 0;
		for (int i=0; i< fat.length; i++) {
			soma += fat[i];
		}
		return soma;
	}
	static double calcularMediaFaturamento(double [] fat) {
		return somarFaturamento(fat)/fat.length;
	}
}
