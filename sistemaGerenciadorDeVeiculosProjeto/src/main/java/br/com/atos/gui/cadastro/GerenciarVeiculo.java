package br.com.atos.gui.cadastro;
import br.com.atos.entity.VeiculoEntity;
import br.com.atos.repository.IVeiculoRepository;
import br.com.atos.repository.impl.VeiculoRepositoryImpl;
import java.util.Scanner;

public class GerenciarVeiculo {
	
	private IVeiculoRepository veiculoRepository = new VeiculoRepositoryImpl();
	
	private Scanner scan = new Scanner(System.in);
	
	public void showVeiculo() {
		
		int opcao = 0;
		
		do {
			System.out.println("1 - Cadastrar veículo");
			System.out.println("2 - Excluir veículo");
			System.out.println("3 - Alterar dados do veículo");
			System.out.println("4 - Voltar para o menu");
			System.out.println("Escolha uma opção: ");
			
			while(!scan.hasNextInt()) {
				System.out.println("Opção inválida");
				System.out.println("Escolha uma opção: ");
				scan.next();
			} 
			
			opcao = scan.nextInt();
			scan.nextLine();
			
			switch (opcao) {
			case 1:
				cadastrarVeiculo();
				break;
			case 2:
				excluirVeiculo();
				break;
			case 3:
				alterarVeiculo();
				break;
			}
			
		} while(opcao != 4);
	}
	
	public void cadastrarVeiculo() {
		System.out.println("Cadastrar veículo: ");
		System.out.println("Marca: ");
		String marca = scan.nextLine();
		
		System.out.println("Modelo: ");
		String modelo = scan.nextLine();
		
		System.out.println("Ano: ");
		int ano = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Placa: ");
		String placa = scan.nextLine();
		
		System.out.println("Preço: ");
		double preco = scan.nextDouble();
		scan.nextLine();
		
		VeiculoEntity veiculo = new VeiculoEntity();
		veiculo.setMarca(marca);
		veiculo.setModelo(modelo);
		veiculo.setAno(ano);
		veiculo.setPlaca(placa);
		veiculo.setPreco(preco);
		
		veiculoRepository.save(veiculo);
		System.out.println("Veículo cadastrado com sucesso!");
		
		
	}
	
	public void excluirVeiculo() {
		System.out.println("Digite o ID do veículo: ");
		long id = scan.nextLong();
		
		VeiculoEntity veiculo = veiculoRepository.findById(id);
		if(veiculo != null) {
			veiculoRepository.deleteById(id);
			System.out.println("Veículo deletado com sucesso!");
		} else {
			System.out.println("Veículo não encontrado");
		}
	}
	
	public void alterarVeiculo() {
		
	}

}
