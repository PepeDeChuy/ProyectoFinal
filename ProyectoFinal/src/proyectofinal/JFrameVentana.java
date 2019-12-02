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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author chris
 */
public class JFrameVentana extends JFrame {
    
    public JFrameVentana(){
        inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        JPanel panelCentral = new JPanel(new GridLayout(5, 3));
        Dimension dim = new Dimension (30, 30);
        JButtonVentana add = new JButtonVentana("Agregar elemento", dim, Color.YELLOW);
        panelCentral.add(add);
        JButtonVentana rmv = new JButtonVentana("Eliminar elemento", dim, Color.green);
        panelCentral.add(rmv);
        JButtonVentana upd = new JButtonVentana("Actualizar elemento", dim, Color.cyan);
        panelCentral.add(upd);
        JButtonVentana idk = new JButtonVentana("Consultar elemento", dim, Color.blue);
        panelCentral.add(idk);
        JButtonVentana info = new JButtonVentana("Informacion", dim, Color.MAGENTA);
        panelCentral.add(info);
        
        setLayout(new BorderLayout());
        add(panelCentral, BorderLayout.CENTER);
        JTextField display = new JTextField();
        Font auxF = display.getFont();
        Font nueva = new Font(auxF.getName(), auxF.getStyle(), 60);
        display.setFont(nueva);
        display.setBackground(Color.lightGray);
        setSize(340, 500);
        setResizable(false);
        display.setEditable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ListenerVentana listV = new ListenerVentana(display);
        add.addActionListener(listV);
        rmv.addActionListener(listV);
        upd.addActionListener(listV);
        idk.addActionListener(listV);
        info.addActionListener(listV);
    }
}
