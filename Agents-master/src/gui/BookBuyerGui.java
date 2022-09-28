/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import agents.BookBuyerAgent;
/**
 *
 * @author carlo
 */
public class BookBuyerGui extends JFrame{
    private BookBuyerAgent vendedor;
    
    private JTextField titleField;
    String title = "";
    public BookBuyerGui(BookBuyerAgent a){
        super(a.getLocalName());	
	vendedor = a;
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(new JLabel("¿Que libro quieres comprar?"));
        titleField = new JTextField(10);
        p.add(titleField);
        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("Comprar");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                    try {
                            title = titleField.getText().trim();
                            
                            titleField.setText("");
                            vendedor.comprar(title);
                            
                    }catch(Exception e) {
                            JOptionPane.showMessageDialog(BookBuyerGui.this, "Invalid values","Error",JOptionPane.ERROR_MESSAGE);
                    }
            }
        });
        JButton addButton2 = new JButton("Cancelar");
        addButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                dispose();
                vendedor.doDelete();
            }
        });
        p = new JPanel();
        p.add(addButton);
        p.add(addButton2);
        getContentPane().add(p, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            vendedor.doDelete();
          }
        });

        setResizable(false);
    }
	
    public void showGui() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(400, 300));
        int centerX = (int)screenSize.getWidth() / 2;
        int centerY = (int)screenSize.getHeight() / 2;

        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
        super.setVisible(true);
    }
    
    public String titulo(){
        return title;
    }
}
