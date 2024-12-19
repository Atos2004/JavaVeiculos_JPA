package br.com.atos.gui.cadastro;

import java.util.Scanner;

import br.com.atos.entity.LojaEntity;
import br.com.atos.repository.ILojaRepository;
import br.com.atos.repository.impl.LojaRepositoryImpl;

public class GerenciarLoja {
	
	private ILojaRepository lojaRepository = new LojaRepositoryImpl();

	Scanner scan = new Scanner(System.in);

	public void showLoja() {
		
		int opcao = 0; 
		
		do {
			System.out.println("1 - Cadastrar loja");
			System.out.println("2 - Excluir loja");
			System.out.println("3 - Alterar dados da loja");
			System.out.println("4 - Voltar para o menu");
			System.out.println("Escolha uma opção: ");

			while (!scan.hasNextInt()) {
				System.out.println("Opção inválida");
				System.out.println("Escolha uma opção: ");
				scan.next();
			}
			
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch(opcao) {
			case 1:
				cadastarLoja();
				break;
			case 2:
				excluirLoja();
				break;
			case 3:
				alterarLoja();
				break;
			}
			
		} while(opcao != 4);

	}
	
	public void cadastarLoja() {
		System.out.println("Cadastrar loja");
		System.out.println("Nome da loja: ");
		String nomeLoja = scan.nextLine();
		
		System.out.println("Endereço da loja: ");
		String enderecoLoja = scan.nextLine();
		
		System.out.println("Telefone da loja: ");
		String telefoneLoja = scan.nextLine();
		
		LojaEntity loja = new LojaEntity();
		loja.setNomeLoja(nomeLoja);
		loja.setEnderecoLoja(enderecoLoja);
		loja.setTelefoneLoja(telefoneLoja);
		
		lojaRepository.save(loja);
		System.out.println("Loja cadastrada com sucesso!");
		
	}
	
	public void excluirLoja() {
		System.out.println("Digite o ID da loja: ");
		long idLoja = scan.nextLong();
		
		LojaEntity loja = lojaRepository.findById(idLoja);
		if(loja != null) {
			lojaRepository.deleteById(idLoja);
			System.out.println("Loja excluída com sucesso!");
		} else {
			System.out.println("Loja não encontrada");
		}
	}
	
	public void alterarLoja() {
		
	}

}
