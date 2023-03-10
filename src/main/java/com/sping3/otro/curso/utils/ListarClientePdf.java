package com.sping3.otro.curso.utils;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sping3.otro.curso.models.entity.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
@Component("/views/clientes/listar")

public class ListarClientePdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("error");

        List<Cliente> listadoClientes = (List<Cliente>) model.get("clientes");

        PdfPTable tablaClientes = new PdfPTable(6);

        listadoClientes.forEach(cliente -> {
            tablaClientes.addCell(cliente.getId().toString());
            tablaClientes.addCell(cliente.getNombres());
            tablaClientes.addCell(cliente.getApellidos());
            tablaClientes.addCell(cliente.getTelefono());
            tablaClientes.addCell(cliente.getEmail());
            tablaClientes.addCell(cliente.getCiudad().getCiudad());
        });

        document.add(tablaClientes);

    }
}
