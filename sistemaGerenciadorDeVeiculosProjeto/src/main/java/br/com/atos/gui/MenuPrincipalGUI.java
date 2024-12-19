package br.com.atos.gui;

import java.util.Scanner;

import br.com.atos.gui.cadastro.ManutencaoDeCadastro;
import br.com.atos.gui.frente.FrenteDaLoja;
import jakarta.persistence.EntityManager;

public class MenuPrincipalGUI {
	
	public void show() {
		
		
		
		//FRENTE DA LOJA
		FrenteDaLoja frenteDaLoja = new FrenteDaLoja();
		
		//MANUTENÇÃO DE CADASTRO
		ManutencaoDeCadastro manutencao = new ManutencaoDeCadastro();
		
		Scanner scan = new Scanner(System.in);
		
		int opcao;
		
		do {
			
			System.out.println("---MENU PRINCIPAL---");
			System.out.println("1 - Frente da loja");
			System.out.println("2 - Manutenção de cadastro");
			System.out.println("3 - Sair");
			System.out.println("Escolha uma opção: ");
			
			while(!scan.hasNextInt()) {
				System.out.println("Opção inválida");
				System.out.println("Escolha uma opção: ");
				scan.next();
			}
			
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1:
				frenteDaLoja.showFrenteDaLoja();
				break;
			case 2:
				manutencao.showManutencao();
				break;
			}
			
		} while (opcao != 3);
		
	}

}
