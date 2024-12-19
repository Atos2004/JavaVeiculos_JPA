 package br.com.atos.gui.frente;

import java.util.List;
import java.util.Scanner;

import br.com.atos.entity.VeiculoEntity;
import br.com.atos.repository.impl.VeiculoRepositoryImpl;


public class GerenciarVeiculoFrente {
	
	VeiculoRepositoryImpl veiculo = new VeiculoRepositoryImpl();
	Scanner scan = new Scanner(System.in);

	public void showVeiculo() {
		
		int opcao = 0;
		
		do {
			
			System.out.println("1 - Consultar veículo por placa");
			System.out.println("2 - Voltar para o menu");
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
				consultarPlaca();
				break;
			}
			
		} while(opcao != 2);
	}
	
	public void consultarPlaca() {
	    System.out.println("Digite a placa do veículo: ");
	    String placa = scan.nextLine();

	    
	    List<VeiculoEntity> veiculosEncontrados = veiculo.findByPlaca(placa);

	   
	    if (veiculosEncontrados != null && !veiculosEncontrados.isEmpty()) {
	        VeiculoEntity veiculoEncontrado = veiculosEncontrados.get(0);
	        System.out.println("Veículo encontrado:");
	        System.out.println("Placa: " + veiculoEncontrado.getPlaca());
	        System.out.println("ID: " + veiculoEncontrado.getId());
	        System.out.println("Marca: " + veiculoEncontrado.getMarca());
	        System.out.println("Modelo: " + veiculoEncontrado.getModelo());
	        System.out.println("Ano: " + veiculoEncontrado.getAno());
	        System.out.println("Preço: R$ " + veiculoEncontrado.getPreco());
	    } else {
	        System.out.println("Placa não encontrada!");
	    }
	}


}
