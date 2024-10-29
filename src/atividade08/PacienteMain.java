package atividade08;

import java.util.Scanner;

public class PacienteMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Paciente paciente = new Paciente();
		int menu;
		do {
			System.out.println("\n1 - Cadastrar paciente. ");
			System.out.println("2 - Mostrar dados do paciente. ");
			System.out.println("3 - Inserir despesas do paciente na conta de despesas." );
			System.out.println("4 - Remover despesas pagas à vista do pelo convênio. ");
			System.out.println("5 - Finalizar operações. ");
			System.out.println("Opção: ");
			menu = scan.nextInt();

			switch (menu) {
				case 1:
					cadastrarPaciente(paciente);
					break;
				case 2:
					mostrarSaldo(paciente);
					break;
				case 3:
					adicionarDespesa(paciente);
					break;
				case 4:
					removerDespesa(paciente);
					break;
				case 5:
					System.out.println("\nPrograma encerrado! ");
					break;
				default:
					System.out.println("\nOpção inválida! ");
					break;
			}
		} while (menu != 5);
	}

	static void cadastrarPaciente(Paciente pac) {
		System.out.println("\nInforme o nome do paciente: ");
		String nome = scan.next();
		pac.setNome(nome);
		System.out.println("\nInforme a idade do paciente: ");
		int idade = scan.nextInt();
		pac.setIdade(idade);
		System.out.println("\nInforme a situação do paciente: ");
		String situacao = scan.next();
		pac.setSituacao(situacao);
		System.out.println("\nInforme a valor total de despesas do paciente: ");
		double contaDespesas = scan.nextDouble();
		pac.setContaDespesas(contaDespesas);
	}
	static void mostrarSaldo(Paciente pac) {
		if (pac.getNome().length() > 0) {
			System.out.println("\nAqui estão as informações do paciente: "+pac.toString(pac));
		} else {
			System.out.println("\nTente cadastrar o paciente primeiro. ");
		}
	}
	static void adicionarDespesa(Paciente pac) {
		if (pac.getNome().length() > 0) {
		System.out.println("\nInsira o valor da nova despesa: ");
		double valor = scan.nextDouble();
		pac.InserirDespesa(valor);
		} else {
			System.out.println("\nTente cadastrar o paciente primeiro. ");
		}
	}
	static void removerDespesa(Paciente pac) {
		if (pac.getNome().length() > 0) {
		System.out.println("\nInsira o valor a ser removido da conta de despesas: ");
		double valor = scan.nextDouble();
		pac.removerDespesa(valor);
		} else {
			System.out.println("\nTente cadastrar o paciente primeiro. ");
		}
	}
}