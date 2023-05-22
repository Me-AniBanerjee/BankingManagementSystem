//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.util.Date;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Fastcash extends JFrame implements  ActionListener
{
    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pin;
    JTextField withdrawlAmount;

    Fastcash(String pin)
    {
        this.pin = pin;
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT", JLabel.CENTER);
        text.setForeground(Color.BLACK);
        text.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        text.setBounds(60,80,450,30);
        add(text);
//----------------------------------------------------------------------------------------------------------
        withdrawlAmount = new JTextField();
        //depositedAmount.setFont(new Font(Font.BOLD, Font.BOLD, 15));
        withdrawlAmount.setBounds(102,120,402,30);
        add(withdrawlAmount);        
//----------------------------------------------------------------------------------------------------------
        hundred= new JButton("Rs 100");
        hundred.setBounds(112,200,100,30);
        hundred.setBackground(Color.BLACK);
        hundred.setForeground(Color.WHITE);
        hundred.addActionListener(this);  
        add(hundred);

        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(250,200,100,30);
        fiveHundred.setBackground(Color.BLACK);
        fiveHundred.setForeground(Color.WHITE);
        fiveHundred.addActionListener(this);  
        add(fiveHundred);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(112,260,100,30);
        thousand.setBackground(Color.BLACK);
        thousand.setForeground(Color.WHITE);
        thousand.addActionListener(this);  
        add(thousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(250,260,100,30);
        twoThousand.setBackground(Color.BLACK);
        twoThousand.setForeground(Color.WHITE);
        twoThousand.addActionListener(this);  
        add(twoThousand);

        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(112,320,100,30);
        fiveThousand.setBackground(Color.BLACK);
        fiveThousand.setForeground(Color.WHITE);
        fiveThousand.addActionListener(this);  
        add( fiveThousand);

        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(250,320,100,30);
        tenThousand.setBackground(Color.BLACK);
        tenThousand.setForeground(Color.WHITE);
        tenThousand.addActionListener(this);  
        add(tenThousand);

        back = new JButton("BACK");
        back = new JButton("BACK");
        back.setBounds(388,260,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);  
        add(back);
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        setTitle("FAST CASH");
        setSize(550,400);
        setLocationRelativeTo(null); 
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setResizable(false);         
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) 
            {
                if (rs.getString("type").equals("Deposit")) 
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                } 
                else 
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            String num = "17";
            if (ae.getSource() != back && balance < Integer.parseInt(amount)) 
            {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == back) 
            {
                this.setVisible(false);
                new Transaction(pin).setVisible(true);
            }
            else
            {
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        } catch (Exception e) 
        {
            System.out.println(e);
        }

    }

    public static void main(String[] args) 
    {
        new Fastcash("").setVisible(true);
    }
}