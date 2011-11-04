/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import Entidad.Proveedores;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
/**
 *
 * @author Darthian
 */
public class ControlContratarProveedor {

    Proveedores proveedorContratado = new Proveedores();
    float valorUnidad, cantidad;

    public ControlContratarProveedor(){

    }

    public ControlContratarProveedor(Proveedores proveedor, float cantidad, float valorUnidad){
        proveedorContratado = proveedor;
        cantidad = this.cantidad;
        valorUnidad = this.valorUnidad;
    }

    public void generarContrato(){
    
       try {
            OutputStream file = new FileOutputStream(new File("C:\\Contrato.pdf"));
            
            Document contrato = new Document();
            PdfWriter.getInstance(contrato, file);
            contrato.open();
            contrato.add(new Paragraph("Nombre"));
            contrato.add(new Paragraph("Nit"));
            contrato.add(new Paragraph(new Date().toString()));

            contrato.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
            
        }
    }

}
