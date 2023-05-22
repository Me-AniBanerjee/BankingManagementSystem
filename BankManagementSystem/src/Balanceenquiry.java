//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Balanceenquiry extends JFrame implements ActionListener
{
    JButton back;
    String pin;

    Balanceenquiry(String pin) 
    {
        this.pin = pin;

        JLabel text = new JLabel();
        text.setForeground(Color.BLACK);
        text.setBounds(190, 350, 400, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        add(text);

        back = new JButton("BACK");
        back.setBounds(390, 633, 150, 35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);  
        add(back);

        setLayout(null);
        int balance = 0;
        try{
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) 
            {
                if (rs.getString("mode").equals("Deposit")) 
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else 
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        text.setText("Your Current Account Balance is Rs "+balance);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        setSize(960,1080);
        setTitle("BALANCE ENQUIRY");
        setLocationRelativeTo(null); 
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setResizable(false);       
    
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new Balanceenquiry("").setVisible(true);
    }
}