/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import Entidad.Proveedores;
import Entidad.ProductoProveedor;
import Frontera.Splash;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Darthian
 */
public class ControlContratarProveedor {

    Proveedores proveedorContratado = new Proveedores();
    List<ProductoProveedor> productos = new ArrayList<ProductoProveedor>();
    float valorUnidad, cantidad;

    public ControlContratarProveedor(){

    }

    public ControlContratarProveedor(Proveedores proveedor, float cantidad, float valorUnidad, List<ProductoProveedor> productos){
        proveedorContratado = proveedor;
        cantidad = this.cantidad;
        valorUnidad = this.valorUnidad;
        productos = this.productos;
    }

     public List buscarListaProveedores(String producto, DefaultTableModel modelo){
       List listaProveedores = new ArrayList();
       Vector datosBasicos = new Vector();
       if (producto.equals(null)){
           listaProveedores = null;
       }
       else{
            for (Proveedores u : Splash.sistema.getProveedores()){
                for (ProductoProveedor p : u.getProductos()){
                    if (p.getNombreProducto().equals(producto)){
                        listaProveedores.add(u);
                        datosBasicos.add(u.getNit());//Nit
                        datosBasicos.add(u.getNombre());//Nombre
                        datosBasicos.add(u.getEvaluaciones().get(u.getEvaluaciones().size()-1).getFiabilidad());//Fiabilidad
                        datosBasicos.add(p.getPrecio());//Precio
                        modelo.addRow(datosBasicos);
                    }
                }
            }
       }
       return listaProveedores;
   }


    public String generarContrato(){
    
       try {
            OutputStream file = new FileOutputStream(new File("C:\\Contrato.pdf"));
            
            Document contrato = new Document();
            PdfWriter.getInstance(contrato, file);
            contrato.open();
            contrato.add(new Paragraph("\n \t Nombre: "));
            contrato.add(new Paragraph(proveedorContratado.getNombre()));
            contrato.add(new Paragraph("\n \t Nit: "));
            contrato.add(new Paragraph(Integer.toString(proveedorContratado.getNit())));
            contrato.add(new Paragraph("\n \t Representante: "));
            contrato.add(new Paragraph(proveedorContratado.getRepresentante()));
            contrato.add(new Paragraph("\n \t Productos: "));
            Iterator i = productos.iterator() ;
            int iterator = 0;
            while(i.hasNext()){
                contrato.add(new Paragraph(productos.get(iterator).getNombreProducto()));
                iterator++;
            }
            contrato.add(new Paragraph("\n \t Direccion: "));
            contrato.add(new Paragraph(proveedorContratado.getDireccion()));
            contrato.add(new Paragraph("\n \t Telefono: "));
            contrato.add(new Paragraph(proveedorContratado.getTelefono()));
            contrato.add(new Paragraph("\n \t Correo: "));
            contrato.add(new Paragraph(proveedorContratado.getCorreo()));
            contrato.add(new Paragraph("\n \t Pagina Web: "));
            contrato.add(new Paragraph(proveedorContratado.getPaginaWeb()));
            contrato.add(new Paragraph("\n \t Envios por mes: "));
            contrato.add(new Paragraph());
            contrato.add(new Paragraph("\n \t Valor por unidad: "));
            contrato.add(new Paragraph(valorUnidad));
            contrato.add(new Paragraph("\n \t Valor total: "));
            contrato.add(new Paragraph(cantidad * valorUnidad));

            contrato.add(new Paragraph(new Date().toString()));

            contrato.close();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al generar el contrato";
        }
       return "El contrato se genero correctamente en la direccion 'C:\\Contrato.pdf'";
    }

}
