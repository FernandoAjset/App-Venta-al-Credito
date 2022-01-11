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
public class PlantillaContrato {

    String texto;
    int contrato;
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    public PlantillaContrato(String texto, int contrato) {
        this.texto = texto;
        this.contrato = contrato;
        documento = new Document();
    }

    public boolean CrearPlantilla() {
        try {
            archivo = new FileOutputStream("contrato-No." + contrato + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            Paragraph contenido = new Paragraph(texto);
            contenido.setAlignment(Element.ALIGN_JUSTIFIED);
            documento.add(contenido);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            Paragraph firmaVendedor = new Paragraph("Firma del vendedor");
            firmaVendedor.setAlignment(Element.ALIGN_CENTER);
            documento.add(firmaVendedor);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            Paragraph firmaComprador = new Paragraph("Firma del comprador");
            firmaComprador.setAlignment(Element.ALIGN_CENTER);
            documento.add(firmaComprador);
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
