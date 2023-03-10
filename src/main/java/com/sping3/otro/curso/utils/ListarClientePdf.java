package com.sping3.otro.curso.utils;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.sping3.otro.curso.models.entity.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;
@Component("/views/clientes/listar")

public class ListarClientePdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Cliente> listadoClientes = (List<Cliente>) model.get("clientes");
        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(20,20,40,20);
        document.open();
        PdfPTable tablaTitulo = new PdfPTable(1);
        Font fuenteTitulo = FontFactory.getFont("Helvetica",16,Color.BLUE);
        Font fuenteTituloColumnas = FontFactory.getFont("Helvetica",14,Color.BLUE);
        Font fuenteGeneral = FontFactory.getFont("Courier",12,Color.black);

        PdfPCell celda =new PdfPCell(new Phrase("Listado General de Clientes",fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(Color.HSBtoRGB(40, 190,138)));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(30);
        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        PdfPTable tablaClientes = new PdfPTable(6);
        tablaClientes.setWidths(new float[]{0.8f,2f,2f,1.5f,3.5f,1.5f});
        celda = new PdfPCell(new Phrase("ID",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.gray);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("NOMBRES",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.gray);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("APELLIDOS",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.gray);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("TEL",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.gray);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("EMAIL",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.gray);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);

        celda = new PdfPCell(new Phrase("CIUDAD",fuenteTituloColumnas));
        celda.setBackgroundColor(Color.gray);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaClientes.addCell(celda);



        listadoClientes.forEach(cliente -> {
            PdfPCell celdaCliente =null;
            celdaCliente = new PdfPCell(new Phrase(cliente.getId().toString()));
            celdaCliente.setPadding(5);
            celdaCliente.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaClientes.addCell(celdaCliente);
            celdaCliente = new PdfPCell(new Phrase(cliente.getNombres()));
            celdaCliente.setPadding(5);
            celdaCliente.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaClientes.addCell(celdaCliente);
            celdaCliente = new PdfPCell(new Phrase(cliente.getApellidos()));
            celdaCliente.setPadding(5);
            celdaCliente.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaClientes.addCell(celdaCliente);
            celdaCliente = new PdfPCell(new Phrase(cliente.getTelefono()));
            celdaCliente.setPadding(5);
            celdaCliente.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaClientes.addCell(celdaCliente);
            celdaCliente = new PdfPCell(new Phrase(cliente.getEmail()));
            celdaCliente.setPadding(5);
            celdaCliente.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaClientes.addCell(celdaCliente);
            celdaCliente = new PdfPCell(new Phrase(cliente.getCiudad().getCiudad()));
            celdaCliente.setPadding(5);
            celdaCliente.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaClientes.addCell(celdaCliente);
//            tablaClientes.addCell(cliente.getNombres());
//            tablaClientes.addCell(cliente.getApellidos());
//            tablaClientes.addCell(cliente.getTelefono());
//            tablaClientes.addCell(cliente.getEmail());
//            tablaClientes.addCell(cliente.getCiudad().getCiudad());
        });
        document.add(tablaTitulo);
        document.add(tablaClientes);

    }
}
