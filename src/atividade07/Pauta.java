package atividade07;

public class Pauta {
	//atributos
	private int matricula;
	private String nomeAluno;
	private int numFaltas;
	private double nota1;
	private double nota2;
	
	//construtores
	public Pauta() {
		this.matricula = 0;
		this.nomeAluno = "";
		this.numFaltas = 0;
		this.nota1 = 0;
		this.nota2 = 0;
	}
	public Pauta(int matricula, String nomeAluno, int numFaltas,
			double nota1, double nota2) {
		this.matricula = matricula;
		this.nomeAluno = nomeAluno;
		this.numFaltas = numFaltas;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	//gets e sets
	public int getMatricula() {
		return this.matricula;
	}
	public String getNomeAluno() {
		return this.nomeAluno;
	}
	public int getNumFaltas() {
		return this.numFaltas;
	}
	public double getNota1() {
		return this.nota1;
	}
	public double getNota2() {
		return this.nota2;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public void setNumFaltas(int numFaltas) {
		this.numFaltas = numFaltas;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	//toString
	public String toString() {
		return this.matricula+", "+this.nomeAluno+", "+this.numFaltas+", "+
	this.nota1+", "+this.nota2;
	}
	//outros métodos	
	
	public double calcularMedia() {
		return (this.nota1+this.nota2)/2;
	}
	public String verificarSituacaoAluno() {
		if ((this.calcularMedia() >= 7) && (this.numFaltas <=25)){
			return "aluno aprovado.";
		}else {
			return "aluno reprovado.";
		}
	}
}
