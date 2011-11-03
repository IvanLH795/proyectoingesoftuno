/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
/**
 *
 * @author Darthian
 */
public class ControlContratarProveedor {
    Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("LuAuF.pdf"));
            documento.open();
            documento.add(new Paragraph("http://luauf.com/"));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        documento.close();
}
