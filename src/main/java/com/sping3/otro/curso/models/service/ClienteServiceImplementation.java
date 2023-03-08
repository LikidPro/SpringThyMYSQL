package com.sping3.otro.curso.models.service;

import com.sping3.otro.curso.models.entity.Cliente;
import com.sping3.otro.curso.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplementation implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);

    }

    @Override
    public void deleteClienteById(Long id) {
        clienteRepository.deleteById(id);

    }
}
