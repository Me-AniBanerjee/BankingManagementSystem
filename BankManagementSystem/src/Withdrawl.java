//package BankManagementSystem;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java .util.Date;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener
{   
    JTextField withdrawlAmount;
    JButton withdraw,back;
    JLabel text;
    String pin;
    Withdrawl(String pin)
    {
  
        this.pin = pin;
      
        text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW", JLabel.CENTER);
        text.setForeground(Color.BLACK);
        text.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        text.setBounds(90,80,450,30);
        add(text);
//----------------------------------------------------------------------------------------------------------------        
        withdrawlAmount = new JTextField();
        //depositedAmount.setFont(new Font(Font.BOLD, Font.BOLD, 15));
        withdrawlAmount.setBounds(112,120,402,30);
        add(withdrawlAmount);
//---------------------------------------------------------------------------------------------------------------
        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(112,200,100,35);
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);  
        add(withdraw);

        back = new JButton("BACK");
        back.setBounds(414,200,100,35);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);  
        add(back);

      /////////////////////////////////////////////////////////////////////////////////////////////////////
        setTitle("WITHDRAW");
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
    
                String amount = withdrawlAmount.getText();
                Date date = new Date();


                if(ae.getSource()==withdraw)
                  {
                    try
                    {
                      if(withdrawlAmount.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
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
                            if(balance < Integer.parseInt(amount))
                            {
                                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                                return;
                            }
                            
                            c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                            JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                            
                            setVisible(false);
                            new Transaction(pin).setVisible(true);
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                  }
                
                  else if(ae.getSource()==back)
                    {
                       setVisible(false);
                        new Transaction(pin).setVisible(true);
                      }
          }
   
       public static void main(String args[])
      {
         new Withdrawl("");
       }
 }  