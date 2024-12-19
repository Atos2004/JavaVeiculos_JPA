package br.com.atos.gui.cadastro;

import java.util.Date;
import java.util.Scanner;

import br.com.atos.entity.ClienteEntity;
import br.com.atos.entity.VeiculoEntity;
import br.com.atos.entity.VendaEntity;
import br.com.atos.entity.VendedorEntity;
import br.com.atos.repository.impl.ClienteRepositoryImpl;
import br.com.atos.repository.impl.VeiculoRepositoryImpl;
import br.com.atos.repository.impl.VendaRepositoryImpl;
import br.com.atos.repository.impl.VendedorRepositoryImpl;

public class GerenciarVenda {

    private VendaRepositoryImpl vendaRepository;
    private ClienteRepositoryImpl clienteRepository;
    private VendedorRepositoryImpl vendedorRepository;
    private VeiculoRepositoryImpl veiculoRepository;

    public GerenciarVenda(
        VendaRepositoryImpl vendaRepository,
        ClienteRepositoryImpl clienteRepository,
        VendedorRepositoryImpl vendedorRepository,
        VeiculoRepositoryImpl veiculoRepository
    ) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.vendedorRepository = vendedorRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public void showVenda() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Cadastro de Venda");

            System.out.print("ID do cliente: ");
            int clienteId = scanner.nextInt();
            ClienteEntity cliente = clienteRepository.findById(clienteId);
            if (cliente == null) {
                System.out.println("Cliente não encontrado!");
                return;
            }

            System.out.print("ID do vendedor: ");
            int vendedorId = scanner.nextInt();
            VendedorEntity vendedor = vendedorRepository.findById(vendedorId);
            if (vendedor == null) {
                System.out.println("Vendedor não encontrado!");
                return;
            }

            System.out.print("ID do veículo: ");
            int veiculoId = scanner.nextInt();
            VeiculoEntity veiculo = veiculoRepository.findById(veiculoId);
            if (veiculo == null) {
                System.out.println("Veículo não encontrado!");
                return;
            }

            
            VendaEntity venda = new VendaEntity();
            venda.setCliente(cliente);
            venda.setVendedor(vendedor);
            venda.setVeiculo(veiculo);
            venda.setData(new Date()); 

            vendaRepository.save(venda);
            System.out.println("Venda cadastrada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar a venda: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

