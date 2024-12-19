package br.com.atos.gui.cadastro;

import java.util.Scanner;

import br.com.atos.entity.VendedorEntity;
import br.com.atos.repository.IVendedorRepository;
import br.com.atos.repository.impl.VendedorRepositoryImpl;

public class GerenciarVendedor {

	private IVendedorRepository vendedorRepository = new VendedorRepositoryImpl();

	Scanner scan = new Scanner(System.in);

	public void showVendedor() {
		
		int opcao = 0; 
		
		do {
			System.out.println("1 - Cadastrar vendedor");
			System.out.println("2 - Excluir vendedor");
			System.out.println("3 - Alterar dados do vendedor");
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
		System.out.println("Cadastrar vendedor");
		System.out.println("Nome do vendedor: ");
		String nome = scan.nextLine();
		
		System.out.println("Cpf do vendedor: ");
		String cpf = scan.nextLine();
		
		System.out.println("Endereço do vendedor: ");
		String endereco = scan.nextLine();
		
		System.out.println("Telefone do vendedor: ");
		String telefone = scan.nextLine();
		
		VendedorEntity vendedor = new VendedorEntity(nome, cpf, endereco, telefone);
		vendedor.setNome(nome);
		vendedor.setCpf(cpf);
		vendedor.setEndereco(endereco);
		vendedor.setTelefone(telefone);
		
		vendedorRepository.save(vendedor);
		System.out.println("vendedor cadastrado com sucesso!");
		
	}
	
	public void excluir() {
		System.out.println("Digite o ID do vendedor: ");
		long idVendedor = scan.nextLong();
		
		VendedorEntity vendedor = vendedorRepository.findById(idVendedor);
		if(vendedor != null) {
			vendedorRepository.deleteById(idVendedor);
			System.out.println("Vendedor excluído com sucesso!");
		} else {
			System.out.println("Vendedor não encontrado");
		}
	}
	
	public void alterar() {
		
	}

}
