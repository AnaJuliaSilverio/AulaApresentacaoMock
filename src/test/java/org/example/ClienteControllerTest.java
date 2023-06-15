package org.example;


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
}