/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import codeProlog.Algoritmo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.swing.JPanel;
import org.jpl7.Term;

/**
 *
 * @author Hector
 */
public class Lienzo extends JPanel implements Runnable, KeyListener{
    
    Algoritmo alg;
    ComeGalletas come = new ComeGalletas();
    Map<Integer,Terreno> mapa;
    Thread hilo;
    int DELAY=700;
    int tiempo = 0;
    Term[] ruta;
    int tamano;
    
    public Lienzo(){
        setDoubleBuffered(true);
        this.setBackground(java.awt.Color.WHITE);
        this.setBounds(100,100,640,300);
        alg = new Algoritmo();
        alg.conexion();
        ruta = alg.encontrarCamino();
        tamano = ruta.length;
        mapa = new TreeMap<Integer,Terreno>();
        
        //Primera Columna
        mapa.put(1, new Terreno(0,0));
        mapa.put(2, new Terreno(0,60));
        mapa.put(3, new Terreno(0,120));
        mapa.put(4, new Terreno(0,180));
        mapa.put(5, new Terreno(0,240));
        
        //Segunda Columna
        mapa.put(6, new Terreno(80,0));
        mapa.put(7, new Terreno(80,60));
        mapa.put(8, new Terreno(80,120));
        mapa.put(9, new Arbol(80,180));
        mapa.put(10, new Terreno(80,240));
        
        //Tercera Columna
        mapa.put(11, new Terreno(160,0));
        mapa.put(12, new Barro(160,60));
        mapa.put(13, new Terreno(160,120));
        mapa.put(14, new Terreno(160,180));
        mapa.put(15, new Terreno(160,240));
        
        //Cuarta Columna
        mapa.put(16, new Terreno(240,0));
        mapa.put(17, new Barro(240,60));
        mapa.put(18, new Barro(240,120));
        mapa.put(19, new Terreno(240,180));
        mapa.put(20, new Arbol(240,240));
        
        //Quinta Columna
        mapa.put(21, new Terreno(320,0));
        mapa.put(22, new Terreno(320,60));
        mapa.put(23, new Terreno(320,120));
        mapa.put(24, new Terreno(320,180));
        mapa.put(25, new Terreno(320,240));
        
        //Sexta Columna
        mapa.put(26, new Arbol(400,0));
        mapa.put(27, new Terreno(400,60));
        mapa.put(28, new Barro(400,120));
        mapa.put(29, new Barro(400,180));
        mapa.put(30, new Terreno(400,240));
        
        //Setima Columna
        mapa.put(31, new Terreno(480,0));
        mapa.put(32, new Terreno(480,60));
        mapa.put(33, new Barro(480,120));
        mapa.put(34, new Terreno(480,180));
        mapa.put(35, new Terreno(480,240));
        
        //Octaba Columna
        mapa.put(36, new Terreno(560,0));
        mapa.put(37, new Terreno(560,60));
        mapa.put(38, new Galleta(560,120));
        mapa.put(39, new Terreno(560,180));
        mapa.put(40, new Terreno(560,240));
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        for(Entry<Integer,Terreno> terreno: mapa.entrySet()){
            terreno.getValue().paint(g2);
        }
        come.paint(g);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    @Override
    public void run() {
        while(true){
            ciclo();
            repaint();
            try{
                Thread.sleep(DELAY);
            }catch(InterruptedException err){
                System.out.println(err);
            }
        }
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("Hola");
    }
    
    public void ciclo(){
        if( tiempo < tamano){
            String numero = ruta[tiempo].toString();
            int posicion = Integer.valueOf(numero);
            int posx = mapa.get(posicion).getPosx();
            int posy = mapa.get(posicion).getPosy();
            come.setPosx(posx);
            come.setPosy(posy);
            tiempo++;
        }
    }

}
