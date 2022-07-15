package br.programa50.pessoa;

import br.programa50.taxa.Taxa;

public class PessoaJuridica extends Pessoa implements Taxa {
	private String cnpj;

	public PessoaJuridica(String nome, double pretensaoSalarial, String especializacao, String cnpj) {
		super(nome, pretensaoSalarial, especializacao);
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		String aux = super.toString();
		aux += "CNPJ: " + cnpj + "\n";
		return aux;
	}

	@Override
	public double calcularTaxa() {
		return pretensaoSalarial * 0.60;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}	
}
