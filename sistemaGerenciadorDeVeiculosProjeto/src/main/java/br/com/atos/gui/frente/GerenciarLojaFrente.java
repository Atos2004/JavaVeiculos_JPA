package br.com.atos.gui.frente;

import java.util.List;
import java.util.Scanner;

import br.com.atos.entity.LojaEntity;
import br.com.atos.repository.impl.LojaRepositoryImpl;

public class GerenciarLojaFrente {

	LojaRepositoryImpl loja = new LojaRepositoryImpl();
	Scanner scan = new Scanner(System.in);

	public void showLoja() {

		int opcao = 0;

		do {
			System.out.println("1 - Listar todas as lojas");
			System.out.println("2 - Voltar para o menu");
			System.out.println("Escolha uma opção: ");

			while (!scan.hasNextInt()) {
				System.out.println("Opção inválida");
				System.out.println("Escolha uma opção: ");
				scan.next();
			}

			opcao = scan.nextInt();
			scan.nextLine();

			switch (opcao) {
			case 1:
				listar();
				break;
			}

		} while (opcao != 2);
	}

	public void listar() {
		List<LojaEntity> lojaLista = loja.findAll();
		for (LojaEntity loja : lojaLista) {
	        System.out.println(loja.getNomeLoja());
	}

}
	
}
