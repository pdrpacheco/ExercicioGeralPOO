package br.programa50.pessoa;

public class PessoaFisica extends Pessoa {
	private String cpf;

	public PessoaFisica(String nome, double pretensaoSalarial, String especializacao, String cpf) {
		super(nome, pretensaoSalarial, especializacao);
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		String aux = super.toString();
		aux += "CPF: " + cpf + "\n";
		return aux;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
}
