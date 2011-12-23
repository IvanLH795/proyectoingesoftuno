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

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
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

    public List<Proveedores> buscarListaProveedores(String producto, DefaultTableModel modelo){
       List<Proveedores> listaProveedores = new ArrayList<Proveedores>();
       Vector datosBasicos = new Vector();
       if (validarProducto(producto)){
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

    public Proveedores buscaProveedor(int Nit){
        Proveedores proveedorSeleccionado = new Proveedores();
        for (Proveedores u : Splash.sistema.getProveedores()){
            if (u.getNit() == Nit){
                proveedorSeleccionado = u;
            }
        }
        return proveedorSeleccionado;
    }

    public String generarContrato(){
       String salida = "Se ha generado el contrato correctamente en C:\\book\\";
       try {
            Document contrato = new Document(PageSize.LETTER);

            PdfWriter file = PdfWriter.getInstance(contrato, new FileOutputStream("c:\\book\\Contrato "+proveedorContratado.getNombre()+".pdf"));

            contrato.setMargins(72f, 72f, 72f, 72f);
            
            contrato.open();
            contrato.add(new Paragraph("\n \t Nombre del Proveedor: " + proveedorContratado.getNombre()));
            contrato.add(new Paragraph("\n \t Nit: " + Integer.toString(proveedorContratado.getNit())));
            contrato.add(new Paragraph("\n \t Representante: " + proveedorContratado.getRepresentante()));
            contrato.add(new Paragraph("\n \t Productos: "));
            for (ProductoProveedor p : productos){
                contrato.add(new Paragraph(p.getNombreProducto()));
            }
            contrato.add(new Paragraph("\n \t Direccion: " + proveedorContratado.getDireccion()));
            contrato.add(new Paragraph("\n \t Telefono: " + Integer.toString(proveedorContratado.getTelefono())));
            contrato.add(new Paragraph("\n \t Correo: " + proveedorContratado.getCorreo()));
            contrato.add(new Paragraph("\n \t Pagina Web: " + proveedorContratado.getPaginaWeb()));
            if(validarPedido(cantidad)){
                salida = "Pedido invalido";
            }
            else contrato.add(new Paragraph("\n \t Pedido Total: " + Float.toString(cantidad)));
            contrato.add(new Paragraph("\n \t Valor por unidad: " + Float.toString(valorUnidad)));
            contrato.add(new Paragraph("\n \t Valor total: " + Float.toString(cantidad * valorUnidad)));
            contrato.add(new Paragraph(new Date().toString()));
            
            contrato.close();
            file.close();

        } catch(Exception ee){
            System.out.println(ee.getMessage());
            salida = ee.getMessage();
        }
       return salida;
    }

    private boolean validarPedido (float pedido) {
        if(pedido <= 0){
            return false;
        }
        return true;
    }

     private boolean validarProducto(String prod) {
        if(prod.equals(null)){
            return true;
        }
        return false;
    }
}