package org.example;

public class ClienteController {

    private BancoDeClientes bancoDeClientes = new BancoDeClientes();

    public void cadastrarCliente(Cliente cliente){
        if (bancoDeClientes.clienteJaExiste(cliente.getEmail())){
            throw new IllegalArgumentException("Cliente já existe");
        }
        bancoDeClientes.adicionarCliente(cliente);
    }
}
