/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_topicos;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
/**
 *
 * @author AJMM
 */
public class arrastrarMouseListener extends MouseMotionAdapter{
        Component parentComponent;
        
        public arrastrarMouseListener(Component parent){
            this.parentComponent = parent;
        }
        
        @Override
        public void mouseDragged(MouseEvent e){
            parentComponent.setLocation(MouseInfo.getPointerInfo().getLocation().x - 100, MouseInfo.getPointerInfo().getLocation().y - 100);
        }
}
