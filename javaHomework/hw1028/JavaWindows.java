package javaHomework.hw1028;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class JavaWindows {
    public JavaWindows() {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        
        
        frame.getContentPane().add(BorderLayout.NORTH, new JLabel("上"));
        frame.getContentPane().add(BorderLayout.EAST, new JButton("右"));
        frame.getContentPane().add(BorderLayout.WEST, new JButton("左"));
        frame.getContentPane().add(BorderLayout.SOUTH, new JButton("下"));
        frame.getContentPane().add(BorderLayout.CENTER, new JTextArea("JTextArea"));
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JavaWindows();
    }
}
