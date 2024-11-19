package trabalhoFinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class CasaDeRepousoMain {
    static Scanner scan = new Scanner(System.in);
    static StringBuffer memoriaPessoas = new StringBuffer();
    static StringBuffer memoriaAcomodacoes = new StringBuffer();
    static final String ARQUIVO_PESSOAS = "Pessoas.txt";
    static final String ARQUIVO_ACOMODACAO = "Acomodacao.txt";
    public static void main(String[] args) {
        System.out.println("PROGRAMA DESENVOLVIDO POR BERNARDO AUGUSTO LODI E JOÃO VICTOR OLIVEIRA.");
        char menu = 0;
        do {
            System.out.println("\n1 - Adicionar nova acomodação. "+
            "\n2 - Adicionar nova pessoa. "+
            "\n3 - Alterar dados de alguma pessoa. "+
            "\n4 - Exlcuir dados de alguma pessoa. "+
            "\n5 - Consultar todos os dados. "+
            "\n6 - Consultar um dado expecífico. "+
            "\n7 - Sair. "+
            "\n>>> Opção:");
            menu = scan.next().charAt(0);
            switch (menu) {
                case '1':
                    adicionarAcomodacao();
                    break;
                case '2':
                    adicionarPessoa();
                    break;
                case '3':
                    
                    break;
                case '7':
                    System.out.println();
                    break;
                default:
                    break;
            }
        } while (menu != '7');
    }

    static void adicionarAcomodacao() {
        String tipo;
        boolean estaDisponivel = true;
        double preco;
        int numAcomodacao;
        try {
            while (true) {
                System.out.println("\nInforme o tipo do quarto: (individual, duplo ou triplo)");
                tipo = scan.next().toLowerCase();
                if (tipo.equals("individual")||tipo.equals("duplo")||tipo.equals("triplo")) {
                    break;
                } else {
                    System.out.println("\nTipo de quarto inválido, tente novamente.");
                }
            }
            System.out.println("\nInforme o número do quarto: ");
            numAcomodacao = scan.nextInt();
            System.out.println("\nInforme o preço mensal do quarto: ");
            preco = scan.nextDouble();

            Acomodacao acomodacao = new Acomodacao(estaDisponivel, preco, tipo, numAcomodacao);
            memoriaAcomodacoes.append(acomodacao.toString());
            gravarDados(ARQUIVO_ACOMODACAO, memoriaAcomodacoes);
        } catch (Exception e) {
            System.out.println("\nErro de gravação");
        }
    }
    
    static void adicionarPessoa() {
        String nome, dataNascimento, dataEntrada;
        int numAcomodacao;
        try {
            if (existemAcomodacoesDisponiveis()) {
                while (true) {
                    System.out.println("\nQuartos disponíveis: ");
                    mostrarAcomodacoesDisponiveis();
                    System.out.println("\nInforme o número do quarto dessa pessoa: ");
                    numAcomodacao = scan.nextInt();
                    if (validarQuarto(numAcomodacao)) {
                        break;
                    } else {
                        System.out.println("\nNúmero inválido, tente novamente.");
                    }
                }
                System.out.println("\nInforme o nome da nova pessoa: ");
                nome = scan.next();
                System.out.println("\nInforme a data de nascimento: ");
                dataNascimento = scan.next();
                System.out.println("\nInforme a data de entrada da pessoa: ");
                dataEntrada = scan.next();
                
                Pessoa pessoa = new Pessoa(nome, dataNascimento, dataEntrada, numAcomodacao);
                memoriaPessoas.append(pessoa.toString());
                gravarDados(ARQUIVO_PESSOAS, memoriaPessoas);
            } else {
                System.out.println("\nNão há quartos disponíveis. ");
            }
        } catch (Exception e) {
            System.out.println("\nErro de gravação");
        }
    }

    public static void mostrarAcomodacoesDisponiveis() {
        int inicio, fim, ultimo, primeiro;
        String numQuarto, valor, disponivel, tipo, pessoasNoQuarto;
        iniciarArquivo(ARQUIVO_ACOMODACAO, memoriaAcomodacoes);
        if (memoriaAcomodacoes.length() > 0) {
            inicio = 0;
            while ((inicio != memoriaAcomodacoes.length())) {
				ultimo = memoriaAcomodacoes.indexOf ("\t", inicio);
				numQuarto = memoriaAcomodacoes.substring(inicio, ultimo);

				primeiro = ultimo + 1;
				ultimo = memoriaAcomodacoes.indexOf ("\t", primeiro); 
				disponivel = memoriaAcomodacoes.substring(primeiro, ultimo);	

				primeiro = ultimo + 1;
                ultimo = memoriaAcomodacoes.indexOf ("\t", primeiro); 
				valor = memoriaAcomodacoes.substring(primeiro, ultimo);	
                
                primeiro = ultimo + 1;
                ultimo = memoriaAcomodacoes.indexOf ("\t", primeiro);
				tipo = memoriaAcomodacoes.substring(primeiro, ultimo);

                primeiro = ultimo + 1;
                fim = memoriaAcomodacoes.indexOf ("\n", primeiro);
				pessoasNoQuarto = memoriaAcomodacoes.substring(primeiro, fim);

				inicio = fim + 1;

                if(disponivel.equals("true")){
                    System.out.println("\n *** Quarto "+ numQuarto + " ***" +
                    "\nValor: " + valor +
                    "\nTipo: "+ tipo +
                    "\nPessoas no quarto: "+ pessoasNoQuarto);
                }
			}
        } else {
            System.out.println("Nenhuma acomodaçao cadastrada!");
        }
    }

    public static boolean existemAcomodacoesDisponiveis() {
        int inicio, fim, ultimo, primeiro;
        iniciarArquivo(ARQUIVO_ACOMODACAO, memoriaAcomodacoes);
        String disponivel;
        boolean estaDisponivel = false;
        if (memoriaAcomodacoes.length() > 0) {
            inicio = 0;
            while ((inicio != memoriaAcomodacoes.length())) {
				ultimo = memoriaAcomodacoes.indexOf ("\t", inicio);

				primeiro = ultimo + 1;
				ultimo = memoriaAcomodacoes.indexOf ("\t", primeiro);
				disponivel = memoriaAcomodacoes.substring(primeiro, ultimo);

                primeiro = ultimo + 1;
                fim = memoriaAcomodacoes.indexOf ("\n", primeiro);
				inicio = fim + 1;
                if (disponivel.equals("true")) {
                    estaDisponivel = true;
                    break;
                }
			}
        } else {
            System.out.println("Nenhuma acomodaçao cadastrada!");
        }
        return estaDisponivel;
    }

    public static boolean validarQuarto (int numAcomodacao) {
        int inicio, fim, ultimo, primeiro;
        iniciarArquivo(ARQUIVO_ACOMODACAO, memoriaAcomodacoes);
        String numAcomodacaoTemp, estaDisponivel;
        boolean numeroDeQuartoDisponivel = false;
        if (memoriaAcomodacoes.length() > 0) {
            inicio = 0;
            while ((inicio != memoriaAcomodacoes.length())) {
				ultimo = memoriaAcomodacoes.indexOf ("\t", inicio);
                numAcomodacaoTemp = memoriaAcomodacoes.substring(inicio, ultimo);

				primeiro = ultimo + 1;
				ultimo = memoriaAcomodacoes.indexOf ("\t", primeiro);
				estaDisponivel = memoriaAcomodacoes.substring(primeiro, ultimo);

                primeiro = ultimo + 1;
                fim = memoriaAcomodacoes.indexOf ("\n", primeiro);
				inicio = fim + 1;
                if (numAcomodacaoTemp.equals(Integer.toString(numAcomodacao)) && estaDisponivel.equals("true")) {
                    numeroDeQuartoDisponivel = true;
                    break;
                }
			}
        } else {
            System.out.println("Nenhuma acomodaçao cadastrada!");
        }
        return numeroDeQuartoDisponivel;
    }

    static void iniciarArquivo(String filename, StringBuffer memoria){
        try{
            BufferedReader arquivoEntrada = new BufferedReader(new FileReader(filename));
            String linha = "";
            memoria.delete(0,memoria.length());
            do {
                linha = arquivoEntrada.readLine();
                if (linha != null) {
                    memoria.append (linha + "\n");
                }
            } while (linha != null);
            arquivoEntrada.close();
        } catch (FileNotFoundException erro){
            System.out.println("\nArquivo não encontrado");
        } catch (Exception e){
            System.out.println("\nErro de Leitura!");
        }
    }

    public static void gravarDados(String filename, StringBuffer memoria) {
        try {
            BufferedWriter arquivoSaida;
            arquivoSaida = new BufferedWriter(new FileWriter(filename));
            arquivoSaida.write(memoria.toString());
            arquivoSaida.flush();
            arquivoSaida.close();
        } catch (Exception e) {
            System.out.println("\nErro de gravacao!");
        }
    }

    public static void consultarDados(String filename) {
        
    }       
}