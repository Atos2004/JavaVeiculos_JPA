package br.com.atos.controller.request;

import java.util.Date;

public class VendaRequest {
    private int clienteId;
    private int vendedorId;
    private int veiculoId;
    private Date data;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

