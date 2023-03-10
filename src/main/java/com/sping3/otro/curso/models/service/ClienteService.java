package com.sping3.otro.curso.models.service;

import com.sping3.otro.curso.models.entity.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> getClientes();

    public Cliente getClienteById(Long id);

    public void saveCliente(Cliente cliente);

    public void deleteClienteById(Long id);



}
