package br.programa50.controle;

import java.util.ArrayList;
import java.util.List;

import br.programa50.pessoa.Pessoa;
import br.programa50.pessoa.PessoaFisica;
import br.programa50.pessoa.PessoaJuridica;
import br.programa50.vaga.Vaga;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Controle {

	private List<Vaga> listaVaga = new ArrayList<Vaga>();
	private List<Pessoa> listaCandidato = new ArrayList<Pessoa>();
	
	public void menu() {
		int opcao = 0;
		
		do {
			try {
				opcao = parseInt(showInputDialog(montarMenu()));
				if(opcao < 1 || opcao > 4) {
					showMessageDialog(null, "Opção inválida");
				} else {
					switch(opcao) {
						case 1:
							cadastrarVaga();
							break;
						case 2:
							cadastrarCandidato();
							break;
						case 3:
							exibir();
							break;
					}
				}				
			}
			catch(NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número");
			}
		} while(opcao != 4);
		
	}
	
	private void exibir() {
		int opcao = 0;
		String cpf, cnpj;
		
		do {
			try {
				opcao = parseInt(showInputDialog(montarSubMenu()));
				if(opcao < 1 || opcao > 4) {
					showMessageDialog(null, "Opção inválida");
				} else if(opcao == 1) {
					cpf = showInputDialog("CPF");
					exibirPessoaFisica(cpf);
				} else if(opcao == 2) {
					cnpj = showInputDialog("CNPJ");
					exibirPessoaJuridica(cnpj);
				}
			}
			catch(NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número");
			}
		} while(opcao != 3);
		
	}

	private void exibirPessoaJuridica(String cnpj) {
		String aux = "";
		String especializacao = "";
		PessoaJuridica pj;
		
		// descobre a especialização do candidato pessoa física
		for(Pessoa pessoa : listaCandidato) {
			if(pessoa instanceof PessoaJuridica) {
				pj = (PessoaJuridica) pessoa;
				if(pj.getCnpj().equals(cnpj)) {
					especializacao = pj.getEspecializacao();
				}
			}
		}
		
		// exibe as vagas compatíveis com o candidato pessoa física
		for(Vaga vaga : listaVaga) {
			if(vaga.getFuncao().equals(especializacao)) {
				aux += vaga + "\n";
			}
		}
		
		showMessageDialog(null, aux);
		
	}

	private void exibirPessoaFisica(String cpf) {
		String aux = "";
		String especializacao = "";
		PessoaFisica pf;
		
		// descobre a especialização do candidato pessoa física
		for(Pessoa pessoa : listaCandidato) {
			if(pessoa instanceof PessoaFisica) {
				pf = (PessoaFisica) pessoa;
				if(pf.getCpf().equals(cpf)) {
					especializacao = pf.getEspecializacao();
				}
			}
		}
		
		// exibe as vagas compatíveis com o candidato pessoa física
		for(Vaga vaga : listaVaga) {
			if(vaga.getFuncao().equals(especializacao)) {
				aux += vaga + "\n";
			}
		}
		
		showMessageDialog(null, aux);
	}

	private void cadastrarCandidato() {
		String nome;
		double pretensaoSalarial;
		String especializacao, cpf, cnpj;		
		int opcao = 0;
		
		do {
			try {
				opcao = parseInt(showInputDialog(montarSubMenu()));
				if(opcao < 1 || opcao > 3) {
					showMessageDialog(null, "Opção inválida");
				} else {
					if(opcao != 3) {
						nome = showInputDialog("Nome");
						pretensaoSalarial = parseDouble(showInputDialog("Pretensão Salarial"));
						especializacao = showInputDialog("Especialização");
						if(opcao == 1) {
							cpf = showInputDialog("CPF");
							listaCandidato.add(new PessoaFisica(nome, pretensaoSalarial, especializacao, cpf));
						} else if(opcao == 2) {
							cnpj = showInputDialog("CNPJ");
							listaCandidato.add(new PessoaJuridica(nome, pretensaoSalarial, especializacao, cnpj));
						}
					}
				}
			}
			catch(NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número");
			}
		} while(opcao != 3);
		
	}

	private void cadastrarVaga() {
		String funcao = showInputDialog("Função");
		double salario = parseDouble(showInputDialog("Salário"));
		listaVaga.add(new Vaga(funcao, salario));		
	}

	private String montarMenu() {
		String aux = "Escolha uma opção\n";
		aux += "1. Cadastrar vaga\n";
		aux += "2. Cadastrar candidato\n";
		aux += "3. Exibir oportunidade\n";
		aux += "4. Finalizar";
		return aux;
	}
	
	private String montarSubMenu() {
		String aux = "Escolha o tipo de candidato\n";
		aux += "1. Pessoa física\n";
		aux += "2. Pessoa jurídica\n";
		aux += "3. Retornar";
		return aux;
	}
	
}
