package atividade08;

public class Paciente {
    private String nome;
    private int idade;
    private String situacao;
    private double contaDespesas;


    public Paciente(String nome,int idade,String situacao,double contaDespesas) {
        this.nome = nome;
        this.idade = idade;
        this.situacao = situacao;
        this.contaDespesas = contaDespesas;
    }
    public Paciente() {
        this.nome = "";
        this.idade = 0;
        this.situacao = "";
        this.contaDespesas = 0;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getSituacao() {
        return situacao;
	}
	public void setSituacao(String situacao) {
        this.situacao = situacao;
	}
    public double getContaDespesas() {
        return contaDespesas;
	}
	public void setContaDespesas(double contaDespesas) {
        this.contaDespesas = contaDespesas;
	}

    public void InserirDespesa(double novaDespesa) {
        this.contaDespesas += novaDespesa;
    }

    public void removerDespesa(double valor) {
        this.contaDespesas -= valor;
    }

    public String toString(Paciente paciente) {
        return nome+", "+idade+" anos, situação "+situacao+", R$"+contaDespesas+" em despesas. ";
    }
}