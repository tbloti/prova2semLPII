package atividade07;

import java.util.Scanner;

public class PautaMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Pauta aluno = new Pauta();
		char opcao;
		do {
			System.out.println("\n1. Cadastrar um aluno"+
					"\n2.  Mostrar todos os dados do aluno"+
					"\n3.  Verificar se o aluno está reprovado por falta"+
					"\n4.  Mostrar a média do aluno"+
					"\n5.  Mostrar situação de aprovação ou reprovação"+
					"\n6.  Finalizar operações");
			opcao = scan.next().charAt(0);
			switch(opcao) {
			case '1':
				cadastrarAluno(aluno);
				break;
			case '2':
				System.out.println("Dados do aluno: "+aluno.toString());
				break;
			case '3':
				verificarFaltas(aluno);
				break;
			case '4':
				System.out.println("a média do aluno é "+aluno.calcularMedia());
				break;
			case '5':
				System.out.println(aluno.verificarSituacaoAluno());
				break;
			case '6':
				System.out.println("fim");
				break;
			default:
				System.out.println("opção inválida");
			}
		}while (opcao != '6');
	}
	static void cadastrarAluno(Pauta aluno) {
		System.out.println("Digite a matricula: ");
		aluno.setMatricula(scan.nextInt());
		System.out.println("Digite o nome do aluno: ");
		aluno.setNomeAluno(scan.next());
		System.out.println("Digite número de faltas: ");
		aluno.setNumFaltas(scan.nextInt());
		System.out.println("Digite a nota1: ");
		aluno.setNota1(scan.nextDouble());
		System.out.println("Digite a nota2: ");
		aluno.setNota2(scan.nextDouble());
	}
	static void verificarFaltas(Pauta a) {
		if (a.getNumFaltas() > 25) {
			System.out.println("Aluno reprovado por faltas.");
		}else {
			System.out.println("Aluno não está reprovado por faltas.");
		}
	}

}
