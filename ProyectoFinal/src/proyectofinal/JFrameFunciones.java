/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.omg.CORBA.DATA_CONVERSION;

/**
 *
 * @author chris
 */
public class JFrameFunciones extends JFrame {
    
    private int tipo;
    
    public JFrameFunciones(int tipo){
        
        this.tipo = tipo;
        inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        setSize(500, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        JLabel name = new JLabel();
        name.setText("Nombre: ");
        name.setBounds(30, 10, 100, 100);
        name.setFont(new Font("Arial", 0, 18));
        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(150, 35, 150, 30);
        
        add(name);
        add(cajaNombre);
        
        JLabel id = new JLabel();
        id.setText("ID: ");
        id.setBounds(30, 10, 100, 200);
        id.setFont(new Font("Arial", 0, 18));
        JTextField cajaId = new JTextField();
        cajaId.setBounds(150, 95, 150, 30);
        
        add(id);
        add(cajaId);
        
        JLabel cantidad = new JLabel();
        cantidad.setText("Cantidad: ");
        cantidad.setBounds(30, 10, 100, 300);
        cantidad.setFont(new Font("Arial", 0, 18));
        JTextField cajaCantidad = new JTextField();
        cajaCantidad.setBounds(150, 155, 150, 30);
        
        add(cantidad);
        add(cajaCantidad);
        
        Dimension dim = new Dimension (30, 30);
        ListenerFunciones Listener = new ListenerFunciones(cajaNombre,cajaId,cajaCantidad);
        switch (tipo)
        {
            case 1:
                JButtonVentana confirmarALTA = new JButtonVentana("ALTA", dim, Color.green);
                confirmarALTA.setBounds(320, 50, 150, 100);
                add(confirmarALTA);
                confirmarALTA.addActionListener(Listener);
                setTitle("Agregar elementos");
                break;
                
            case 2:
                JButtonVentana confirmarBAJA = new JButtonVentana("BAJA", dim, Color.RED);
                confirmarBAJA.setBounds(320, 50, 150, 100);
                add(confirmarBAJA);
                confirmarBAJA.addActionListener(Listener);
                setTitle("Eliminar elementos");
                break;
                
            case 3:
                JButtonVentana confirmarCONSULTA = new JButtonVentana("CONS.", dim, Color.BLUE);
                confirmarCONSULTA.setBounds(320, 50, 150, 100);
                add(confirmarCONSULTA);
                confirmarCONSULTA.addActionListener(Listener);
                setTitle("Consultar");
                break;
                
            case 4:
                JButtonVentana confirmarMODIFICAR = new JButtonVentana("MOD.", dim, Color.YELLOW);
                confirmarMODIFICAR.setBounds(320, 50, 150, 100);
                add(confirmarMODIFICAR);
                confirmarMODIFICAR.addActionListener(Listener);
                setTitle("Modificar");
                break;
        }
    }   
}