package br.com.atos.gui.cadastro;

import java.util.Scanner;

import br.com.atos.entity.ClienteEntity;
import br.com.atos.entity.LojaEntity;
import br.com.atos.repository.IClienteRepository;
import br.com.atos.repository.impl.ClienteRepositoryImpl;
import br.com.atos.repository.impl.LojaRepositoryImpl;

public class GerenciarCliente {

	private IClienteRepository clienteRepository = new ClienteRepositoryImpl();

	Scanner scan = new Scanner(System.in);

	public void showCliente() {
		
		int opcao = 0; 
		
		do {
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Excluir cliente");
			System.out.println("3 - Alterar dados do cliente");
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
				cadastar();
				break;
			case 2:
				excluir();
				break;
			case 3:
				alterar();
				break;
			}
			
		} while(opcao != 4);

	}
	
	public void cadastar() {
		System.out.println("Cadastrar cliente");
		System.out.println("Nome do cliente: ");
		String nome = scan.nextLine();
		
		System.out.println("Cpf do cliente: ");
		String cpf = scan.nextLine();
		
		System.out.println("Endereço do cliente: ");
		String endereco = scan.nextLine();
		
		System.out.println("Telefone do cliente: ");
		String telefone = scan.nextLine();
		
		ClienteEntity cliente = new ClienteEntity(nome, cpf, endereco, telefone);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setTelefone(telefone);
		
		clienteRepository.save(cliente);
		System.out.println("Cliente cadastrado com sucesso!");
		
	}
	
	public void excluir() {
		System.out.println("Digite o ID da cliente: ");
		long idCliente = scan.nextLong();
		
		ClienteEntity cliente = clienteRepository.findById(idCliente);
		if(cliente != null) {
			clienteRepository.deleteById(idCliente);
			System.out.println("Cliente excluído com sucesso!");
		} else {
			System.out.println("Cliente não encontrado");
		}
	}
	
	public void alterar() {
		
	}

}
