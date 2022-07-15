package br.programa50.pessoa;

public class Pessoa {
	protected String nome;
	protected double pretensaoSalarial;
	protected String especializacao;
	
	public Pessoa(String nome, double pretensaoSalarial, String especializacao) {
		super();
		this.nome = nome;
		this.pretensaoSalarial = pretensaoSalarial;
		this.especializacao = especializacao;
	}
	
	@Override
	public String toString() {
		String aux = "";
		aux += "Nome: " + nome + "\n";
		aux += "Pretensão Salarial R$ " + String.format("%.2f", pretensaoSalarial) + "\n";
		aux += "Especialização: " + especializacao + "\n";
		return aux;
 	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	public void setPretensaoSalarial(double pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}	
}
