//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import java .util.Date;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener
{   
  JTextField depositAmount;
  JButton deposit,back;
  JLabel text;
  String pin;
  Deposit(String pin)
  {

      this.pin = pin;
    
      text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT", JLabel.CENTER);
      text.setForeground(Color.BLACK);
      text.setFont(new Font(Font.SERIF, Font.BOLD, 20));
      text.setBounds(90,80,450,30);
      add(text);
//----------------------------------------------------------------------------------------------------------------        
      depositAmount = new JTextField();
      //depositedAmount.setFont(new Font(Font.BOLD, Font.BOLD, 15));
      depositAmount.setBounds(112,120,402,30);
      add(depositAmount);
//---------------------------------------------------------------------------------------------------------------
      deposit = new JButton("DEPOSIT");
      deposit.setBounds(112,200,100,35);
      deposit.setBackground(Color.BLACK);
      deposit.setForeground(Color.WHITE);
      deposit.addActionListener(this);  
      add(deposit);

      back = new JButton("BACK");
      back.setBounds(414,200,100,35);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);  
      add(back);

    /////////////////////////////////////////////////////////////////////////////////////////////////////
      setTitle("DEPOSIT");
      setSize(650,300);
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
        try
          {        
              String amount = depositAmount.getText();
              Date date = new Date();


              if(ae.getSource()==deposit)
                {
                    if(depositAmount.getText().equals(" "))
                      {
                          JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                      }
                    else
                      {
                          Conn c1 = new Conn();
                          ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                          int balance = 0;
                          while(rs.next())
                          {
                             if(rs.getString("type").equals("Deposit"))
                             {
                                 balance += Integer.parseInt(rs.getString("amount"));
                             }
                             else
                             {
                                 balance -= Integer.parseInt(rs.getString("amount"));
                             }
                          }
                          
                          c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                          JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                          
                          setVisible(false);
                          new Transaction(pin).setVisible(true);
                      }
                }
              
                else if(ae.getSource()==back)
                  {
                      setVisible(false);
                      new Transaction(pin).setVisible(true);
                    }
          }
        
          catch(Exception e)
            {
                System.out.println(e);
            }
    }
 
 
     public static void main(String args[])
    {
       new Deposit("");
     }
}  