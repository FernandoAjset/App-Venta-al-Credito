package domain;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Fer
 */
public class PlantillaFactura {

    Factura nuevaFactura;

    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public PlantillaFactura(Factura nuevaFactura) {
        this.nuevaFactura = nuevaFactura;
        documento = new Document();
        titulo = new Paragraph("FACTURA ELECTRONICA\t\t" + "SERIE: FECI-545");
    }

    public boolean CrearPlantilla() {
        try {
            archivo = new FileOutputStream("factura-No." + nuevaFactura.getCodigoFactura() + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1);
            documento.add(titulo);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("No. Factura: " + nuevaFactura.getCodigoFactura()));
            documento.add(new Paragraph("Fecha: " + nuevaFactura.getFecha()));
            documento.add(new Paragraph("Codigo Cliente: " + nuevaFactura.getCodigoCliente()));
            documento.add(new Paragraph("Nombre Cliente: " + nuevaFactura.getNombre()));
            documento.add(new Paragraph("Dirección: " + nuevaFactura.getDireccion()));
            documento.add(new Paragraph("Nit: " + nuevaFactura.getNit()));
            documento.add(Chunk.NEWLINE);
            //Detalles producto
            Paragraph tituloProducto = new Paragraph("DETALLES DE LA COMPRA");
            tituloProducto.setAlignment(1);
            documento.add(tituloProducto);
            documento.add(Chunk.NEWLINE);
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            PdfPCell codigo = new PdfPCell(new Phrase("Codigo Producto"));
            PdfPCell nombre = new PdfPCell(new Phrase("Nombre Producto"));
            PdfPCell precio = new PdfPCell(new Phrase("Precio Producto"));
            PdfPCell cuotas = new PdfPCell(new Phrase("Cantidad de cuotas"));
            tabla.addCell(codigo);
            tabla.addCell(nombre);
            tabla.addCell(precio);
            tabla.addCell(cuotas);

            tabla.addCell(String.valueOf(nuevaFactura.getCodigoProducto()));
            tabla.addCell(String.valueOf(nuevaFactura.getNombreProducto()));
            tabla.addCell(String.valueOf(nuevaFactura.getPrecioProducto()));
            tabla.addCell(String.valueOf(nuevaFactura.getCuotas()));
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            JOptionPane.showConfirmDialog(null, "Error al crear archivo", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (DocumentException e) {
            e.printStackTrace(System.out);
            JOptionPane.showConfirmDialog(null, "Error al crear archivo", "Error", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
