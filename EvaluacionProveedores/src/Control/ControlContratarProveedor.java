/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;
import DAO.ContratosJpaController;
import DAO.PresupuestoDisponibleJpaController;
import DAO.ProductosJpaController;
import DAO.ProveedoresJpaController;
import Entidad.Contratos;
import Entidad.PresupuestoDisponible;
import Entidad.Proveedores;
import Entidad.ProductoProveedor;
import Entidad.Productos;
import Frontera.Splash;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Darthian
 */
public class ControlContratarProveedor {

    ProveedoresJpaController listaProve = new ProveedoresJpaController();
    Proveedores proveedorContratado = new Proveedores();
    List<ProductoProveedor> productos = new ArrayList<ProductoProveedor>();
    float cantidad;
    String producto;
    ProductoProveedor productoSeleccionado = new ProductoProveedor();

    EntityManager em;
    
    public ControlContratarProveedor(){
        em = Splash.em;
    }

    public ControlContratarProveedor(Proveedores proveedor, float cantidad, ProductoProveedor producto){
        proveedorContratado = proveedor;
        this.cantidad = cantidad;
        this.productoSeleccionado = producto;
    }

    public List<Proveedores> buscarListaProveedores(String producto, DefaultTableModel modelo){
       List<Proveedores> listaProveedores = new ArrayList<Proveedores>();
       
       Vector datosBasicos = new Vector();
       if (validarProducto(producto)){
           listaProveedores = null;
       }
       else{
            for (Proveedores u : listaProve.getProveedores(em)){
                for (ProductoProveedor p : u.getProductos()){
                    if (p.getNombreProducto().equals(producto)){
                        listaProveedores.add(u);
                        datosBasicos.add(u.getNit());//Nit
                        datosBasicos.add(u.getNombre());//Nombre
                        datosBasicos.add(u.getEvaluaciones().get(u.getEvaluaciones().size()-1).getFiabilidad());//Fiabilidad
                        datosBasicos.add(p.getPrecioPorUnidad());//Precio
                        modelo.addRow(datosBasicos);
                    }
                }
            }
       }
       return listaProveedores;
    }

    public String buscaProveedor(int Nit, Proveedores proveedorSeleccionado){
        String salida = "El proveedor no se encuentra en la lista";
        ProveedoresJpaController proveedor = new ProveedoresJpaController();
        Proveedores p = proveedor.getProveedorNit(Nit, em);
        if (p != null) salida = "Succes";
        return salida;
    }

    public String generarContrato(){
       String salida = "Se ha generado el contrato correctamente en "+System.getProperty("user.dir");
       try {
            Document contrato = new Document(PageSize.LETTER);
            PdfWriter file = PdfWriter.getInstance(contrato, new FileOutputStream(System.getProperty("user.dir")+"\\Contrato_"+proveedorContratado.getNombre()+"_"+ productoSeleccionado.getNombreProducto()+".pdf"));
            Contratos cont = new Contratos();

            contrato.setMargins(72f, 72f, 72f, 72f);
            
            contrato.open();
            contrato.add(new Paragraph("\n \t Nombre del Proveedor: " + proveedorContratado.getNombre()));
            contrato.add(new Paragraph("\n \t Nit: " + Integer.toString(proveedorContratado.getNit())));
            contrato.add(new Paragraph("\n \t Representante: " + proveedorContratado.getRepresentante()));
            contrato.add(new Paragraph("\n \t Direccion: " + proveedorContratado.getDireccion()));
            contrato.add(new Paragraph("\n \t Telefono: " + Integer.toString(proveedorContratado.getTelefono())));
            contrato.add(new Paragraph("\n \t Correo: " + proveedorContratado.getCorreo()));
            contrato.add(new Paragraph("\n \t Pagina Web: " + proveedorContratado.getPaginaWeb()));
            contrato.add(new Paragraph("\n \t Producto: " + productoSeleccionado.getNombreProducto()));
            contrato.add(new Paragraph("\n \t Valor por unidad: " + productoSeleccionado.getPrecioPorUnidad()+ " pesos"));
            contrato.add(new Paragraph("\n \t Pedido Total: " + Float.toString(cantidad) + " unidades"));
            contrato.add(new Paragraph("\n \t Valor total: " + Float.toString(cantidad * productoSeleccionado.getPrecioPorUnidad())+ " pesos"));
            contrato.add(new Paragraph("\n \t" + new Date().toString()));
            
            contrato.close();
            file.close();
            
            cont.setCantidad((int)cantidad);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            java.util.Date date = new java.util.Date();
            String datetime = dateFormat.format(date);
            cont.setFecha(datetime);
            cont.setProveedor(proveedorContratado);

            Productos prod = buscarProducto(productoSeleccionado.getNombreProducto());
            prod.setDineroDisponible(prod.getDineroDisponible() - productoSeleccionado.getPrecioPorUnidad()*cantidad);
            ProductosJpaController productoControl = new ProductosJpaController();
            productoControl.delete(prod.getNombreProducto(), em);
            productoControl.create(prod, em);
            cont.setProducto(prod);
            
            PresupuestoDisponibleJpaController presupuestoControl = new PresupuestoDisponibleJpaController();
            PresupuestoDisponible presupuestoDisponible = new PresupuestoDisponible();
            presupuestoDisponible = presupuestoControl.getPresupuestoDisponible(em);
            presupuestoDisponible.setPresupuesto(presupuestoDisponible.getPresupuesto() - productoSeleccionado.getPrecioPorUnidad()*cantidad);
            presupuestoControl.update(presupuestoDisponible, em);

            ContratosJpaController control =new ContratosJpaController();
            cont.setCantidad((int)cantidad);
            cont.setProducto(null);
            control.create(cont, em);            

        } catch(Exception ee){
            System.out.println(ee.getMessage());
            salida = "Error al generar el contrato";
        }
       return salida;
    }

    private boolean validarPedido (float pedido) {
        if(pedido <= 0){
            return false;
        }
        return true;
    }

    private Productos buscarProducto (String nombre) {
        ProductosJpaController p = new ProductosJpaController();
        return p.getProductoNombre(nombre, em);
    }

     private boolean validarProducto(String prod) {
        if(prod.equals(null)){
            return true;
        }
        return false;
    }
}