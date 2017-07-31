/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import objetos.Lienzo;

/**
 *
 * @author Hector
 */
public class Juego extends JFrame{
    
    public static void main(String args[]) {
        Juego ventana = new Juego();
    }
    public Juego(){
        JButton salir = new JButton();
        JLabel fondo = new JLabel();
        Lienzo lienzo = new Lienzo();
        
        //Propiedades del boton salir
        salir.setBounds(750, 10, 70, 30);
        salir.setBackground(new java.awt.Color(51, 102, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 14));
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.setBorderPainted(false);
        salir.setFocusPainted(false);
        salir.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
                
        //Propiedades del fondo
        fondo.setIcon(getfondo());
        fondo.setBounds(0, 0, 831, 449);
        
        //Propiedades de la ventana
        this.setUndecorated(true);
        this.setSize(831, 449);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        //Agregando componentes a la ventana        
        this.add(salir);
        this.add(lienzo);
        this.add(fondo);
        addKeyListener(lienzo);
        setFocusable(true);
        
    }
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        System.out.println("Hola");
    }

    private Icon getfondo() {
        ImageIcon img = new ImageIcon(getClass().getResource("/imagenes/fondo2.png"));
        return img;
    }
    
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }
    
    
    
    
}
