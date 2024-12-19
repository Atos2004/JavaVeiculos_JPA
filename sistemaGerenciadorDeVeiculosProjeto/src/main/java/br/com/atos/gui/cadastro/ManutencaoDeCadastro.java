package br.com.atos.gui.cadastro;

import java.util.Scanner;

import br.com.atos.repository.impl.ClienteRepositoryImpl;
import br.com.atos.repository.impl.LojaRepositoryImpl;
import br.com.atos.repository.impl.VeiculoRepositoryImpl;
import br.com.atos.repository.impl.VendaRepositoryImpl;
import br.com.atos.repository.impl.VendedorRepositoryImpl;

public class ManutencaoDeCadastro {

	GerenciarVeiculo gerenciarVeiculo = new GerenciarVeiculo();
	GerenciarLoja gerenciarLoja = new GerenciarLoja();
	GerenciarCliente gerenciarCliente = new GerenciarCliente();
	GerenciarVendedor gerenciarVendedor = new GerenciarVendedor();
	
	VeiculoRepositoryImpl veiculoRepository = new VeiculoRepositoryImpl();
	LojaRepositoryImpl lojaRepository = new LojaRepositoryImpl();
	ClienteRepositoryImpl clienteRepository = new ClienteRepositoryImpl();
	VendedorRepositoryImpl vendedorRepository = new VendedorRepositoryImpl();
	VendaRepositoryImpl vendaRepository = new VendaRepositoryImpl();
	
	
	GerenciarVenda gerenciarVenda = new GerenciarVenda(vendaRepository, clienteRepository, vendedorRepository, veiculoRepository);
	
	Scanner scan = new Scanner(System.in);

	public void showManutencao() {

		int opcao;

		do {

			System.out.println("--- MANUTENÇÃO DE CADASTRO ---");
			System.out.println("1 - Gerenciar veículo");
			System.out.println("2 - Gerenciar Loja");
			System.out.println("3 - Gerenciar cliente");
			System.out.println("4 - Gerenciar vendedor");
			System.out.println("5 - Gerenciar venda");
			System.out.println("6 - Voltar Para o menu");
			System.out.println("Escolha uma opção: ");

			while (!scan.hasNextInt()) {
				System.out.println("Opção inválida");
				System.out.println("Escolha uma opção: ");
				scan.next();
			}

			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				gerenciarVeiculo.showVeiculo();
				break;
			case 2:
				gerenciarLoja.showLoja();
				break;
			case 3:
				gerenciarCliente.showCliente();
				break;
			case 4:
				gerenciarVendedor.showVendedor();
				break;
			case 5:
				gerenciarVenda.showVenda();
				break;
			
			}

		} while (opcao != 6);

	}

}
