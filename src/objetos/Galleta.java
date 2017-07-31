/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Hector
 */
public class Galleta extends Terreno{
    
    public Galleta(int posx, int posy) {
        super(posx, posy);
        this.img = new ImageIcon(getClass().getResource("/imagenes/Cookie.jpg")).getImage();
    }
    
    public void paint(Graphics g){
        g.drawImage(img, posx, posy, largo, ancho, null);
    }
}
