/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Hector
 */
public class ComeGalletas{
    int posx, posy, desx, desy, largo, ancho;
    Image img;
    
    public ComeGalletas() {
        posx = 0;  
        posy = 120;  
        desx = 80;
        desy = 60;
        ancho = 60;
        largo = 80;
        img = new ImageIcon(getClass().getResource("/imagenes/ComeGalletas.jpg")).getImage();
    }

    public void paint(Graphics g){
        g.drawImage(img, posx, posy, largo, ancho, null);
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
        
}
