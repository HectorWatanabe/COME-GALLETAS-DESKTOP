/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Hector
 */
public class Terreno {
    int posx, posy, ancho, largo;
    Image img;
    
    public Terreno(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
        ancho = 60;
        largo  = 80;
        img = new ImageIcon(getClass().getResource("/imagenes/terreno.jpg")).getImage();
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
