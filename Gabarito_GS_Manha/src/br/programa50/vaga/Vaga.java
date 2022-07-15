package br.programa50.vaga;

public class Vaga {
	private String funcao;
	private double salario;
	
	public Vaga(String funcao, double salario) {
		super();
		this.funcao = funcao;
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		String aux = "";
		aux += "Função: " + funcao + "\n";
		aux += "Salário R$ " + String.format("%.2f", salario) + "\n";
		return aux;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}	
}
