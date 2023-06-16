package org.example;

import java.util.ArrayList;
import java.util.List;

public class BancoDeClientes {
    private List<Cliente> clientes =new ArrayList<>();

    public BancoDeClientes() {
        iniciarBDCliente();
    }

    public boolean clienteJaExiste(String cpf){
        for (Cliente c:this.clientes) {
            if (c.getCpf().equals(cpf)) return true;
        }
        return false;
    }
    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);

    }
    public void iniciarBDCliente(){
        adicionarCliente(new Cliente("João", "572.571.860-30", "joao@example.com", 25,"A#b3C"));
        adicionarCliente(new Cliente("Maria", "246.564.540-44", "maria@example.com", 30,"X$y9Z"));
        adicionarCliente(new Cliente("Pedro", "309.930.100-08", "pedro@example.com", 35,"M@p5Q"));
        adicionarCliente(new Cliente("Ana", "863.325.530-81", "ana@example.com", 40,"L!k2J"));
        adicionarCliente(new Cliente("Carlos", "201.479.790-05", "carlos@example.com", 45,"R#s8T"));
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean verificarClienteExiste(String cpf) {
        if(cpf == null){
            return true;
        }else {
            return false;
        }
    }

    public void deletaClienteBanco(String cpf) {
        //deleta cliente no banco de dados
    }
}
