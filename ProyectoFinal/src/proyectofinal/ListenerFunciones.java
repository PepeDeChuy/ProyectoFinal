/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import com.mysql.jdbc.Connection;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author peper
 */
public class ListenerFunciones implements ActionListener{
    
    Statement stmt = null;
            
    private JTextField cajaName;
    private JTextField cajaId;
    private JTextField cajaCantidad;
    
    private static Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String contrasena = "";
    private static final String url = "jdbc:mysql://localhost:3306/POO";

   public ListenerFunciones(JTextField cajaName, JTextField cajaId, JTextField cajaCantidad) {
       
        this.cajaName = cajaName;
        this.cajaId = cajaId;
        this.cajaCantidad = cajaCantidad;
        
        con = null;
        try{
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, contrasena); 
            
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error de " + e, "Error!!!", JOptionPane.WARNING_MESSAGE);
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            
           case "ALTA":
           {
                try {
                    stmt = con.createStatement();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            
                try {
                    stmt.executeUpdate("INSERT INTO Producto VALUES('" + cajaName.getText() + "','"+ cajaId.getText()+"','"+cajaCantidad.getText()+"')");
                } 
                catch (SQLException ex) {
                      
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
                  cajaName.setText("");
                  cajaId.setText("");
                  cajaCantidad.setText("");
                  
                  JOptionPane.showMessageDialog(null, "Regitro guardado");
                  
                  break;
           }    
           case "BAJA":
           {
                 ResultSet rs = null;
              try {
                    stmt = con.createStatement();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            
                try {
                    String querry="";
                    int cont=0;
                    String nombre = cajaName.getText();
                    String Id = cajaId.getText();
                    String cantidad = cajaCantidad.getText();
                    if("".equals(nombre))
                    { 
                    }
                    else
                    {
                       if(cont==0)
                        {
                            querry = querry + " nombre = '"+cajaName.getText()+"'";
                            
                            cont++;
                        }
                        else
                        {
                            querry = querry + ", nombre = '"+cajaName.getText()+"'";
                        } 
                    }
                    if("".equals(Id))
                    {
                    }
                    else
                    {
                        if(cont==0)
                        {
                            querry = querry + "ID = "+cajaId.getText();
                            cont++;
                        }
                        else
                        {
                            querry = querry + ",ID = "+cajaId.getText();
                        }
                        
                    }
                    if("".equals(cantidad))
                    {
                    }
                    else
                    {
                        if(cont==0)
                        {
                            querry = querry + " cantidad = "+cajaCantidad.getText();
                            cont++;
                        }
                        else
                        {
                            querry = querry + ",cantidad = "+cajaCantidad.getText();
                        }
                    }
                       
                        rs = stmt.executeQuery("select * from Producto WHERE "+querry+"");
                        rs.next();
                        String ID = rs.getString("ID");
                        stmt.executeUpdate("Delete from Producto where ID ="+ID);
        //("select * from Producto WHERE nombre = '"+cajaName.getText()+"'");
                    
                    
                   
                } 
                catch (SQLException ex) {
                      
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
                cajaName.setText("");
                  cajaId.setText("");
                  cajaCantidad.setText("");
                  
                  JOptionPane.showMessageDialog(null, "Regitro Eliminado");
                break;
           }
               
           case "CONS.":
           {
               ResultSet rs = null;
              try {
                    stmt = con.createStatement();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            
                try {
                    String querry="";
                    int cont=0;
                    String nombre = cajaName.getText();
                    String Id = cajaId.getText();
                    String cantidad = cajaCantidad.getText();
                    if("".equals(nombre))
                    { 
                    }
                    else
                    {
                       if(cont==0)
                        {
                            querry = querry + " nombre = '"+cajaName.getText()+"'";
                            
                            cont++;
                        }
                        else
                        {
                            querry = querry + ", nombre = '"+cajaName.getText()+"'";
                        } 
                    }
                    if("".equals(Id))
                    {
                    }
                    else
                    {
                        if(cont==0)
                        {
                            querry = querry + "ID = "+cajaId.getText();
                            cont++;
                        }
                        else
                        {
                            querry = querry + ",ID = "+cajaId.getText();
                        }
                        
                    }
                    if("".equals(cantidad))
                    {
                    }
                    else
                    {
                        if(cont==0)
                        {
                            querry = querry + " cantidad = "+cajaCantidad.getText();
                            cont++;
                        }
                        else
                        {
                            querry = querry + ",cantidad = "+cajaCantidad.getText();
                        }
                    }
                       
                        rs = stmt.executeQuery("select * from Producto WHERE "+querry+"");
                    
                   while(rs.next())
                   {
                        JOptionPane.showMessageDialog(null, "Nombre: "+rs.getString("nombre") + " \nId: "+rs.getString("ID")+ " \nCantidad: "+rs.getString("cantidad"));
                   }
                } 
                catch (SQLException ex) {
                      
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                  } 
                cajaName.setText("");
                  cajaId.setText("");
                  cajaCantidad.setText("");
                  
                break;
           }
           case "MOD.":
           {
                ResultSet rs = null;
              try {
                    stmt = con.createStatement();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            
                try {
                    String querry="";
                    int cont=0;
                    String nombre = cajaName.getText();
                    String Id = cajaId.getText();
                    String cantidad = cajaCantidad.getText();
                    if("".equals(nombre))
                    { 
                    }
                    else
                    {
                       if(cont==0)
                        {
                            querry = querry + " nombre = '"+cajaName.getText()+"'";
                            
                            cont++;
                        }
                        else
                        {
                            querry = querry + ", nombre = '"+cajaName.getText()+"'";
                        } 
                    }
                    if("".equals(Id))
                    {
                    }
                    else
                    {
                        if(cont==0)
                        {
                            querry = querry + "ID = "+cajaId.getText();
                            cont++;
                        }
                        else
                        {
                            querry = querry + ",ID = "+cajaId.getText();
                        }
                        
                    }
                    if("".equals(cantidad))
                    {
                    }
                    else
                    {
                        if(cont==0)
                        {
                            querry = querry + " cantidad = "+cajaCantidad.getText();
                            cont++;
                        }
                        else
                        {
                            querry = querry + ",cantidad = "+cajaCantidad.getText();
                        }
                    }
                       
                        rs = stmt.executeQuery("select * from Producto WHERE "+querry+"");
                   
                    rs.next();
                    
                   String idPrimero = rs.getString("ID");
                   String nombre2 = JOptionPane.showInputDialog("Nombre",rs.getString("nombre"));
                   String ID = JOptionPane.showInputDialog("ID",rs.getString("ID"));
                   String cantidad2 = JOptionPane.showInputDialog("Cantidad",rs.getString("cantidad"));
                   
                   
                   stmt.executeUpdate("update Producto set nombre = '"+nombre2+"', ID = "+ID+" ,cantidad = "+cantidad2+" where ID ="+idPrimero);
                } 
                catch (SQLException ex) {
                      
                    Logger.getLogger(ListenerFunciones.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
                cajaName.setText("");
                  cajaId.setText("");
                  cajaCantidad.setText("");
                  
                  JOptionPane.showMessageDialog(null, "Regitro Modificado");
                break;
           }
        }
    
    }
}
