//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener
{
    JButton deposit, cashWithdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pin;


    Transaction(String pin)
    {
        this.pin = pin;
        JLabel transactionType = new JLabel("Please Select Your Transaction",JLabel.CENTER);
        transactionType.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        transactionType.setBounds(100,80,400,30);
        add(transactionType);
//-----------------------------------------------------------------------------------------------------------------------------------------   
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(180,170,220,35);
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.addActionListener(this);  
        add(deposit);

        cashWithdrawl = new JButton("CASH WITHDRAWL");
        cashWithdrawl.setBounds(180,230,220,35);
        cashWithdrawl.setBackground(Color.BLACK);
        cashWithdrawl.setForeground(Color.WHITE);
        cashWithdrawl.addActionListener(this);  
        add(cashWithdrawl);

        fastCash = new JButton("FAST CASH");
        fastCash.setBounds(180,290,220,35);
        fastCash.setBackground(Color.BLACK);
        fastCash.setForeground(Color.WHITE);
        fastCash.addActionListener(this);  
        add(fastCash);

        miniStatement = new JButton("MINI STATEMENT");
        miniStatement.setBounds(180,350,220,35);
        miniStatement.setBackground(Color.BLACK);
        miniStatement.setForeground(Color.WHITE);
        miniStatement.addActionListener(this);  
        add(miniStatement);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(180,410,220,35);
        pinChange.setBackground(Color.BLACK);
        pinChange.setForeground(Color.WHITE);
        pinChange.addActionListener(this);  
        add(pinChange);

        balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setBounds(180,470,220,35);
        balanceEnquiry.setBackground(Color.BLACK);
        balanceEnquiry.setForeground(Color.WHITE);
        balanceEnquiry.addActionListener(this);  
        add(balanceEnquiry);
 //-------------------------------------------------------------------------------------------------------------------------------------------   
        exit = new JButton("EXIT");
        exit.setBounds(320,520,80,35);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);  
        add(exit);
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        setTitle("TRANSACTIONS");
        setSize(600,600);
        setLocationRelativeTo(null); 
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setResizable(false); 
    
 }

@Override
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==deposit)
    { 
        setVisible(false);
        new Deposit(pin).setVisible(true);
    }
    else if(ae.getSource()==cashWithdrawl)
    { 
        setVisible(false);
        new Withdrawl(pin).setVisible(true);
    }
    else if(ae.getSource()==fastCash)
    { 
        setVisible(false);
        new Fastcash(pin).setVisible(true);
    }
    else if(ae.getSource()==miniStatement)
    { 
        new Ministatement(pin).setVisible(true);
    }
    else if(ae.getSource()==pinChange)
    { 
        setVisible(false);
        new Pin(pin).setVisible(true);
    }
    else if(ae.getSource()==balanceEnquiry)
    { 
        this.setVisible(false);
        new Balanceenquiry(pin).setVisible(true);
    }
    else if(ae.getSource()==exit)
    { 
        System.exit(0);
    }
}

  public static void main(String args[])
   {
      new Transaction(" ");
   }
}