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

/*import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
/**
 *
 * @author Darthian
 */
public class ControlContratarProveedor {

    Proveedores proveedorContratado = new Proveedores();

    public ControlContratarProveedor(){

    }

    public ControlContratarProveedor(Proveedores proveedor){
        proveedorContratado = proveedor;
    }

    public void generarContrato(){
    
       try {
            OutputStream file = new FileOutputStream(new File("C:\\Test.pdf"));
            /*
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph(proveedor.getNombre));
            document.add(new Paragraph(proveedor.getNit));
            document.add(new Paragraph(new Date().toString()));

            document.close();
            */
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
