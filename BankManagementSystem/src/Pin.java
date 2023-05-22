//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField password1,password2;
    JButton change, back;                               
    JLabel text, newPin, reEnterPin;
    String pin;
    Pin(String pin)
    {
        this.pin = pin;
        
        text = new JLabel("Change your Pin", JLabel.CENTER);
        text.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        text.setForeground(Color.BLACK);
        text.setBounds(170,80,200,35);
        add(text);
 //------------------------------------------------------------------------------------------------------------------------------------------------       
        newPin = new JLabel("New PIN:");
        newPin.setBounds(100,160,150,35);
        newPin.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        newPin.setForeground(Color.BLACK);
        add(newPin);

        password1 = new JPasswordField();
        password1.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        password1.setBounds(300,160,150,25);
        add(password1);
//--------------------------------------------------------------------------------------------------------------------------------------        
        reEnterPin = new JLabel("Re-Enter New PIN:");
        reEnterPin.setBounds(70,240,170,35);
        reEnterPin.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        reEnterPin.setForeground(Color.BLACK);
        add(reEnterPin);
        
        password2 = new JPasswordField();
        password2.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        password2.setBounds(300,240,150,25);
        add(password2);
//-------------------------------------------------------------------------------------------------------------------------------------        
        change = new JButton("CHANGE");
        change.setBounds(300,300,150,35);
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);  
        add(change);

        back = new JButton("BACK");
        back.setBounds(300,350,150,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);  
        add(back);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setSize(600,430);
        setTitle("CHANGE PIN");
        setLocationRelativeTo(null); 
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setResizable(false);       
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = password1.getText();
            String rpin = password2.getText();
            
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==change)
            {
                if (password1.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (password2.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                Conn c1 = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c1.s.executeUpdate(query1);
                c1.s.executeUpdate(query2);
                c1.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            
            }
            else if(ae.getSource()==back)
            {
                new Transaction(pin).setVisible(true);
                setVisible(false);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
