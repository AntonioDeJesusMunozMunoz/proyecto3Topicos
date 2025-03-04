/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto3_topicos;

import java.awt.Component;
import java.awt.Dimension;
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
        this.addMouseMotionListener(new arrastrarMouseListener(this));
    }
}

