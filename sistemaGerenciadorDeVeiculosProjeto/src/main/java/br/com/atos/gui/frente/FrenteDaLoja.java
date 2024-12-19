package br.com.atos.gui.frente;

import java.util.Scanner;

public class FrenteDaLoja {
	
	GerenciarVeiculoFrente veiculoFrente = new GerenciarVeiculoFrente();
	GerenciarLojaFrente lojaFrente = new GerenciarLojaFrente();
	GerenciarClienteFrente clienteFrente = new GerenciarClienteFrente();
	GerenciarVendedorFrente vendedorFrente = new GerenciarVendedorFrente();
	GerenciarVendaFrente vendaFrente = new GerenciarVendaFrente();

	Scanner scan = new Scanner(System.in);

	public void showFrenteDaLoja() {
		int opcao = 0;
		
		do {
			
			System.out.println("--- FRENTE DA LOJA ---");
			System.out.println("1 - Gerenciar veículo");
			System.out.println("2 - Gerenciar loja");
			System.out.println("3 - Gerenciar cliente");
			System.out.println("4 - Gerenciar vendedor");
			System.out.println("5 - Gerenciar venda");
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
				gerenciarVeiculo();
				break;
			case 2:
				gerenciarLoja();
				break;
			case 3: 
				gerenciarCliente();
				break;
			case 4:
				gerenciarVendedor();
				break;
			case 5:
				gerenciarVenda();
				break;
			}
			
		} while(opcao !=6);
	}
	
	public void gerenciarVeiculo() {
		veiculoFrente.showVeiculo();
	}
	
	public void gerenciarLoja() {
		lojaFrente.showLoja();
	}
	
	public void gerenciarCliente() {
		clienteFrente.showCliente();
	}
	
	public void gerenciarVendedor() {
		vendedorFrente.showVendedor();
	}
	
	public void gerenciarVenda() {
		vendaFrente.showVenda();
	}

}
