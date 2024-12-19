package br.com.atos.gui.frente;

import java.util.List;
import java.util.Scanner;

import br.com.atos.entity.VendedorEntity;
import br.com.atos.gui.cadastro.GerenciarVendedor;
import br.com.atos.repository.impl.VendedorRepositoryImpl;

public class GerenciarVendedorFrente {
	
	VendedorRepositoryImpl vendedorRepository = new VendedorRepositoryImpl();
	GerenciarVendedor vendedor = new GerenciarVendedor();
	
	Scanner scan = new Scanner(System.in);

	public void showVendedor() {
		
		int opcao = 0;
		
		do {
			
			System.out.println("1 - Cadastrar vendedor");
			System.out.println("2 - Consultar vendedor por CPF");
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
		vendedor.cadastar();
	}
	
	public void consultarCpf() {
		System.out.println("Digite o CPF do vendedor: ");
		String cpf = scan.nextLine();
		
		List<VendedorEntity> vendedoresEncontrados = vendedorRepository.findByCpf(cpf);
		
		if(vendedoresEncontrados != null && !vendedoresEncontrados.isEmpty()) {
			VendedorEntity vendedorEncontrado = vendedoresEncontrados.get(0);
			System.out.println("Vendedor encontrado: ");
			System.out.println("CPF: " + vendedorEncontrado.getCpf());
			System.out.println("Nome: " + vendedorEncontrado.getNome());
			System.out.println("Endereço: " + vendedorEncontrado.getEndereco());
			System.out.println("Telefone: " + vendedorEncontrado.getTelefone());
			
		} else {
			System.out.println("Vendedor não encontrado!");
		}
	}

}
