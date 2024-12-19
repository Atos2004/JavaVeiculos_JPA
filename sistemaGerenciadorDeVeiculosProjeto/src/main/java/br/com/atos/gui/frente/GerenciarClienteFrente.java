package br.com.atos.gui.frente;

import java.util.List;
import java.util.Scanner;

import br.com.atos.entity.ClienteEntity;
import br.com.atos.gui.cadastro.GerenciarCliente;
import br.com.atos.repository.impl.ClienteRepositoryImpl;

public class GerenciarClienteFrente {
	
	ClienteRepositoryImpl clienteRepository = new ClienteRepositoryImpl();
	GerenciarCliente cliente = new GerenciarCliente();
	
	Scanner scan = new Scanner(System.in);

	public void showCliente() {
		
		int opcao = 0;
		
		do {
			
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Consultar cliente por CPF");
			System.out.println("3 - Voltar para o menu");
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
				cadastrar();
				break;
			case 2:
				consultarCpf();
				break;
			}
		} while(opcao != 3);
	}
	
	public void cadastrar() {
		cliente.cadastar();
	}
	
	public void consultarCpf() {
		System.out.println("Digite o CPF do cliente: ");
		String cpf = scan.nextLine();
		
		List<ClienteEntity> clientesEncontrados = clienteRepository.findByCpf(cpf);
		
		if(clientesEncontrados != null && !clientesEncontrados.isEmpty()) {
			ClienteEntity clienteEncontrado = clientesEncontrados.get(0);
			System.out.println("Cliente encontrado: ");
			System.out.println("CPF: " + clienteEncontrado.getCpf());
			System.out.println("Nome: " + clienteEncontrado.getNome());
			System.out.println("Endereço: " + clienteEncontrado.getEndereco());
			System.out.println("Telefone: " + clienteEncontrado.getTelefone());
			
		} else {
			System.out.println("Cliente não encontrado!");
		}
	}

}
