package br.com.atos.gui.frente;

import java.util.Scanner;

import br.com.atos.gui.cadastro.GerenciarVenda;
import br.com.atos.repository.impl.ClienteRepositoryImpl;
import br.com.atos.repository.impl.VeiculoRepositoryImpl;
import br.com.atos.repository.impl.VendaRepositoryImpl;
import br.com.atos.repository.impl.VendedorRepositoryImpl;

public class GerenciarVendaFrente {
	
	private VendaRepositoryImpl vendaRepository;
    private ClienteRepositoryImpl clienteRepository;
    private VendedorRepositoryImpl vendedorRepository;
    private VeiculoRepositoryImpl veiculoRepository;
    
    VendasRelatorio vendaRelatorio = new VendasRelatorio();
    
	GerenciarVenda venda = new GerenciarVenda(vendaRepository, clienteRepository, vendedorRepository, veiculoRepository);
	Scanner scan = new Scanner(System.in);

	public void showVenda() {
		int opcao = 0;

		do {
			System.out.println("1 - Cadastrar venda");
			System.out.println("2 - Mostrar relatório de vendas");
			System.out.println("3 - Voltar para o menu");
			System.out.println("Escolha uma opção: ");

			if (scan.hasNextInt()) {
				opcao = scan.nextInt();
				scan.nextLine(); 
				
				switch (opcao) {
					case 1:
						cadastrar();
						break;
					case 2:
						relatorio();
						break;
					case 3:
				
						break;
					default:
						System.out.println("Opção inválida!");
				}
			} else {
				System.out.println("Opção inválida! Por favor, digite um número.");
				scan.next();
			}
		} while (opcao != 3);
	}
	
	public void cadastrar() {
		venda.showVenda();
	}
	
	public void relatorio() {
		vendaRelatorio.relatorio();
		
	}
}
