package com.sping3.otro.curso.controllers;

import com.sping3.otro.curso.models.entity.Ciudad;
import com.sping3.otro.curso.models.entity.Cliente;
import com.sping3.otro.curso.models.service.CiudadService;
import com.sping3.otro.curso.models.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CiudadService ciudadService;

    @GetMapping("/")
    public String getClientes(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.getClientes());
        return "/views/clientes/listar";
    }

    @GetMapping("/create")

    public String createClient(Model model) {
        Cliente cliente = new Cliente();
        List<Ciudad> listCiudades = ciudadService.listaCiudades();
        model.addAttribute("titulo", "Formulario: Nuevo Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listCiudades);


        return "/views/clientes/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            List<Ciudad> listCiudades = ciudadService.listaCiudades();
            model.addAttribute("titulo", "Formulario: Nuevo Cliente");
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", listCiudades);

            System.out.println("Hubo un error en el formulario");

            return "/views/clientes/crear";
        }
        clienteService.saveCliente(cliente);
        redirectAttributes.addFlashAttribute("success","cliente guardadon con exito");
        return "redirect:/clientes/";
    }

    @GetMapping("/edit/{id}")

    public String editar(@PathVariable("id") Long idCliente, Model model , RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteService.getClienteById(idCliente);
        if (idCliente > 0 && cliente != null) {
            List<Ciudad> listCiudades = ciudadService.listaCiudades();
            model.addAttribute("titulo", "Formulario: Editar Cliente");
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", listCiudades);

            redirectAttributes.addFlashAttribute("error","Hubo un error con el id del cliente o no existe");
            return "/views/clientes/crear";
        } else {
            return "redirect:/clientes/";
        }


    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long idCliente, Model model , RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteService.getClienteById(idCliente);
        if (idCliente > 0 && cliente != null) {
            clienteService.deleteClienteById(idCliente);
            redirectAttributes.addFlashAttribute("warning","Cliente eliminado con exito  ");

            return "redirect:/clientes/";

        } else {
            redirectAttributes.addFlashAttribute("error","Hubo un error con el id del cliente o no existe");
            return "redirect:/clientes/";
        }
    }
}