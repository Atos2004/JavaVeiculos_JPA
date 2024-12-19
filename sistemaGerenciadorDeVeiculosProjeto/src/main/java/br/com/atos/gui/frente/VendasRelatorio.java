package br.com.atos.gui.frente;

import java.util.Scanner;

import br.com.atos.repository.impl.VendaRepositoryImpl;

public class VendasRelatorio {
	
	VendaRepositoryImpl venda = new VendaRepositoryImpl();
	Scanner scan = new Scanner(System.in);
	
	public void relatorio() {
	
			System.out.println("--- Relatório de vendas ---");
			System.out.println("  |Vendas no mês: " + venda.totalVendas());
			System.out.println("  |total de clientes no sistema: " + venda.totalClientesCompraram());
			System.out.println("  |total de vendedores no sistema: |" + venda.totalVendedores());
			System.out.println("  |Veículos vendidos: |" + venda.totalVeiculos());
			System.out.println("1 - Voltar para o menu");
			
	
	}
}
