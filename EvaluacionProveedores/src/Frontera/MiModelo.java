/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Frontera;

import javax.swing.table.DefaultTableModel;

public class MiModelo extends DefaultTableModel
{
   /** Primera columna Boolean, segunda Float y el resto Float */
   public Class getColumnClass(int columna)
   {
      if (columna == 0) return String.class;
      if (columna == 1) return Float.class;
      return Float.class;
   }
}