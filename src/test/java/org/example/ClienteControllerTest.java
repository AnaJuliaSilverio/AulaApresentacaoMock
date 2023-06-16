package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {
    @Mock
    private BancoDeClientes bancoDeClientes;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    void cadastrarClienteComCPFEmailRepetido() {
        Cliente cliente = new Cliente("Joao", "161.478.698-78", "ana@gmail.com", 20, "juju");
        //quando eu chamar meu clientJaExiste me retorne true
        when(bancoDeClientes.clienteJaExiste(cliente.getEmail())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> clienteController.cadastrarCliente(cliente));
        //verifica se eu nunca salvei esse cliente
        verify(bancoDeClientes, never()).adicionarCliente(cliente);
    }


    @Test
    void validaRemoverClienteExistenteComSucesso(){
        String cpf = "160.093.110-39";
        //preparacao
        when(bancoDeClientes.verificarClienteExiste(any())).thenReturn(true);// any() = qualquer coisa

        //execucao
        clienteController.removerCliente(cpf);

        //validacao
        verify(bancoDeClientes, times(1)).deletaClienteBanco(any());
    }

    @Test
    void validaRemoverClienteNaoExistente(){
        String cpf = "160.093.110-39";

        when(bancoDeClientes.verificarClienteExiste(any())).thenReturn(false);// any() = qualquer coisa

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> clienteController.removerCliente(cpf));

        Assertions.assertEquals(exception.getMessage(), "Cliente nao encontrado");
    }
}