/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author JHoang2026
 */
import java.awt.*;
import javax.swing.*;



// Create a constructor method
public class Main extends JPanel{
    public Main(){
        super();
    }
    /* Create a paintComponent() method to override the one in
    JPanel.This is where the drawing happens. We don't have
    to call it in our program, it gets called automatically
    whenever the panel needs to be redrawn, like when it is
    made visible or moved or whatever.
    */
    public void paintComponent(Graphics g){
        //g.drawLine(10,150,150,10); // Draw a line from (10,10) to (150,150)
        //g.drawRect(50, 50, 40, 40);
        //g.drawRect(60, 80, 225, 30);
        g.drawOval(100, 100, 100, 500);
        g.drawOval(300, 100, 100, 500);
        g.drawLine(100, 700, 400, 700);
        g.drawLine(50, 650, 100, 700);
        g.drawLine(450, 650, 400, 700);
        
        String string1 = "Hi Mr. Nelson";
        Font string1Font = new Font( "SansSerif", Font.PLAIN, 200 );
        g.setFont( string1Font );
        g.drawString( string1, 600, 300 );
        
        g.drawLine(700, 400, 800, 400);
        g.drawLine(700, 400, 700, 500);
        g.drawLine(800, 400, 800, 500);
        g.drawLine(700, 500, 650, 650);
        g.drawLine(800, 500, 850, 650);
        g.drawLine(650, 650, 850, 650);
        g.drawLine(700, 500, 800, 500);
        g.drawOval(750, 470, 20, 20);
        g.drawOval(770, 440, 20, 20);
        g.drawOval(750, 400, 20, 20);
        g.drawOval(720, 350, 20, 20);
        
        String string2 = "<-- I made this Chemistry Beaker just for you.";
        Font string2Font = new Font( "SansSerif", Font.PLAIN, 50 );
        g.setFont( string2Font );
        g.drawString( string2, 900, 600 );
        //g.drawString("<-- I made this Chemistry Beaker just for you.", 900, 700);
        
        
        
        //g.drawString("-- Albert Einstein", 130, 100);
    }

    public static void main(String arg[]){
        JFrame frame = new JFrame("BasicJPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2000, 800);
// Create a new identifier for a BasicJPanel called "panel",
// then create a new BasicJPanel object for it to refer to.
        Main panel = new Main();
// Make the panel object the content pane of the JFrame.
// This puts it into the drawable area of frame, and now
// we do all our drawing to panel, using paintComponent(), above.
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
