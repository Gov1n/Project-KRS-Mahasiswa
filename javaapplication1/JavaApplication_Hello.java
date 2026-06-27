/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import view.InputNilai;
import view.Dashboard;

/**
 *
 * @author ngura
 */
public class JavaApplication_Hello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new InputNilai().setVisible(true);
        new Dashboard().setVisible(true);
        
        System.out.print("Hello World");
    }
    
}
