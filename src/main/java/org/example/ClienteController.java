package org.example;

public class ClienteController {

    private BancoDeClientes bancoDeClientes = new BancoDeClientes();

    public void cadastrarCliente(Cliente cliente){
        if (bancoDeClientes.clienteJaExiste(cliente.getEmail())){
            throw new IllegalArgumentException("Cliente já existe");
        }
        bancoDeClientes.adicionarCliente(cliente);
    }

    public void removerCliente(String cpf){
        if(bancoDeClientes.verificarClienteExiste(cpf)){
            bancoDeClientes.deletaClienteBanco(cpf);
            return;
        }
        throw new IllegalArgumentException("Cliente nao encontrado");
    }
}
