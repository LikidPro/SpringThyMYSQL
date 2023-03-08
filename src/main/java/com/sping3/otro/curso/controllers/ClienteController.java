package com.sping3.otro.curso.controllers;

import com.sping3.otro.curso.models.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String getClientes(Model model){
        model.addAttribute("titulo","Listado de clientes");
        model.addAttribute("clientes",clienteService.getClientes());
        return "/views/clientes/listar";
    }

    @GetMapping("/create")
    public String createClient(){
        return "/views/clientes/crear";
    }
}
