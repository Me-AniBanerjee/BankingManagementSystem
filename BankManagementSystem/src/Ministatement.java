//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ministatement extends JFrame implements ActionListener
{
    JButton exit;
    //JLabel l1;
    String pin;
    Ministatement(String pin)
    {
        this.pin = pin;

        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        add(l1);
        
        JLabel l2 = new JLabel("This is your Mini Statement ", JLabel.CENTER);
        l2.setBounds(130, 20, 270, 20);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        add(l4);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next())
            {
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try
        {
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next())
            {
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("mode").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs "+balance);
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
        
        exit = new JButton("Exit");
        exit.setBounds(20, 500, 100, 25);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        
        
        l1.setBounds(20, 140, 400, 200);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setTitle("MINI STATEMENT");
        setSize(550,600);
        setLocationRelativeTo(null); 
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setResizable(false);    
    }
    public void actionPerformed(ActionEvent ae)
    {
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new Ministatement("").setVisible(true);
    }
    
}