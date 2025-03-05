/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_topicos;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author AJMM
 */
public class panelMovible extends JPanel{
    public panelMovible(int ancho, int largo){
        this.setPreferredSize(new Dimension(ancho,largo));
        
        
        final Point initialClick = new Point();
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick.setLocation(e.getPoint());
            }
        });
        
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Component component = e.getComponent();
                Point windowPoint = component.getLocation();
                
                int x = windowPoint.x + e.getX() - initialClick.x;
                int y = windowPoint.y + e.getY() - initialClick.y;
                
                component.setLocation(x, y);
            }
        });
        
         
       
        //this.addMouseMotionListener(new arrastrarMouseListener(this));
//        this.addComponentListener(new ComponentAdapter(){
//            @Override
//            public void componentResized(ComponentEvent e){
//                System.out.println("RAAAAAAAAAAAAAAa");
//            }
//        });
    }
}

