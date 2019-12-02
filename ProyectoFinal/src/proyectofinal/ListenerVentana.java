/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author chris
 */
class ListenerVentana implements ActionListener {
    
    private JTextField display;
    
    public ListenerVentana(JTextField display){
        this.display = display;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       switch(e.getActionCommand()){
           case "Agregar elemento":
               JFrameFunciones add = new JFrameFunciones(1);
               add.setVisible(true);
               break;
           case "Eliminar elemento":
               JFrameFunciones rmv = new JFrameFunciones(2);
               rmv.setVisible(true);
               break;
           case "Actualizar elemento":
               JFrameFunciones upd = new JFrameFunciones(4);
               upd.setVisible(true);
               break;
           case "Consultar elemento":
               JFrameFunciones cons= new JFrameFunciones(3);
               cons.setVisible(true);
               break;
           case "Informacion":
               JOptionPane.showMessageDialog(null, "Alumnos: \nChristian Iván Aguilar Valdez\n"
                       + "Jose de Jesus Arellano Garcia\n\n"
                       + "Sugerencias:\n"
                       + "1- Para ingresar a un usuario ingrese con todos los capos llenos para evitar errores\n"
                       + "2- Al eliminar se eliminara el primer elemento encontrado en la consulta\n"
                       + "\n\nCodigo DB:\n"
                       + "create database POO;\n"
                       + "use POO;\n" 
                       + "create table Producto(nombre varchar(50), ID int primary key,cantidad int);");
               break;
       } 
    }
}