//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupThree extends JFrame implements ActionListener
{   
    JRadioButton saving, current, recurring, fixed;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlerts, chequeBook, eStatement, confirm;
    JButton submit, cancel;
    String formnum;

    SignupThree(String formnum)
    {
        this.formnum = formnum;

        JLabel accountDetails = new JLabel("Page 3: Account Details", JLabel.CENTER);
        accountDetails.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        accountDetails.setBounds(100,80,400,30);
        add(accountDetails);
//-------------------------------------------------------------------------------------------------------------------------------
        JLabel accountType = new JLabel("Account Type", JLabel.LEFT);
        accountType.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        accountType.setBounds(100,160,200,30);
        add(accountType);

        saving = new JRadioButton("Savings");
        saving.setBounds(300,160,100,30);
        saving.setBackground(Color.WHITE);
        add(saving);

        current = new JRadioButton("Current");
        current.setBounds(410,160,70,30);
        current.setBackground(Color.WHITE);
        add(current);

        recurring = new JRadioButton("Recurring");
        recurring.setBounds(300,190,100,30);
        recurring.setBackground(Color.WHITE);
        add(recurring);

        fixed = new JRadioButton("Fixed Deposit");
        fixed.setBounds(410,190,150,30);
        fixed.setBackground(Color.WHITE);
        add(fixed);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(saving);
        accountGroup.add(current);
        accountGroup.add(recurring);
        accountGroup.add(fixed);
//-------------------------------------------------------------------------------------------------------------------------------  
        JLabel cardNumber = new JLabel("Card Number", JLabel.LEFT);
        cardNumber.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        cardNumber.setBounds(100,250,200,30);
        add(cardNumber); 

        JLabel number1 = new JLabel("XXXX-XXXX-XXXX-3245", JLabel.LEFT);
        number1.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        number1.setBounds(310,250,260,30);
        add(number1); 

        JLabel number1Text = new JLabel("This your 16 digit card number", JLabel.LEFT);
        number1Text.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        number1Text.setBounds(310,270,260,30);
        add(number1Text); 
//------------------------------------------------------------------------------------------------------------------------------- 
        JLabel pinNumber = new JLabel("Pin Number", JLabel.LEFT);
        pinNumber.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        pinNumber.setBounds(100,310,200,30);
        add(pinNumber);   
        
        JLabel number2 = new JLabel("XXXX", JLabel.LEFT);
        number2.setFont(new Font(Font.SERIF, Font.BOLD, 15));
        number2.setBounds(310,310,100,30);
        add(number2); 

        JLabel number2Text = new JLabel("This your auto generated pin", JLabel.LEFT);
        number2Text.setFont(new Font(Font.SERIF, Font.BOLD, 14));
        number2Text.setBounds(310,330,260,30);
        add(number2Text); 
//---------------------------------------------------------------------------------------------------------------------------------
        JLabel servicesRequired = new JLabel("Services Required", JLabel.LEFT);
        servicesRequired.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        servicesRequired.setBounds(100,380,200,30);
        add(servicesRequired);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBounds(310,380,110,30);
        atmCard.setBackground(Color.WHITE);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(460,380,150,30);
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(310,410,120,30);
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking);

        emailAlerts = new JCheckBox("Email Alerts");
        emailAlerts.setBounds(460,410,110,30);
        emailAlerts.setBackground(Color.WHITE);
        add(emailAlerts);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(310,440,120,30);
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook);

        eStatement = new JCheckBox("E Statement");
        eStatement.setBounds(460,440,120,30);
        eStatement.setBackground(Color.WHITE);
        add(eStatement);
//-----------------------------------------------------------------------------------------------------------------------------------------------
        confirm = new JCheckBox("I, hereby declare all the information entered here is correct");
        confirm.setBounds(90,480,450,30);
        confirm.setBackground(Color.WHITE);
        add(confirm);
//------------------------------------------------------------------------------------------------------------------------------------------
        submit = new JButton("Submit");
        submit.setBounds(90,520,80,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);   
        add(submit);  
        
        cancel = new JButton("Cancel");
        cancel.setBounds(360,520,80,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);   
        add(cancel);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
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
        String accountType = null;
        if(saving.isSelected())
            accountType = "Saving Account";
        else if(fixed.isSelected()) 
            accountType = "Fixed Deposit Account";
        else if(current.isSelected()) 
            accountType = "Current Account";
        else if(recurring.isSelected()) 
            accountType = "Recurring Deposit Account";

        String cardNumber = null;
        int upper = 100000000;
        int lower = 90000000;
        int r = (int) (Math.random() * (upper - lower)) + lower;
        cardNumber = Integer.toString(r);  
        
        String pinNumber = null;
        int upper1 = 9000;
        int lower1 = 1000;
        int r1 = (int) (Math.random() * (upper1- lower1)) + lower1;
        pinNumber = Integer.toString(r1); 
        
        String facility = null;
        if(atmCard.isSelected())
            facility = facility + " ATM Card";
        if(internetBanking.isSelected()) 
            facility = facility + " Internet Banking";
        if(mobileBanking.isSelected()) 
            facility = facility + " Mobile Banking";
        if(emailAlerts.isSelected())
            facility = facility + " EMAIL Alerts";
        if(chequeBook.isSelected()) 
            facility = facility + " Cheque Book";
        if(eStatement.isSelected())
            facility = facility + " E-Statement";
        
        try
        {
            if(ae.getSource()==submit)
            {
               if(accountType.equals(""))
                   JOptionPane.showMessageDialog(null, "Fill all the required fields");
        
                else
                 {
                    Conn c1 = new Conn();
                    String query1 = "insert into signupthree values('"+formnum+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";  
                    String query2 = "insert into login values('"+formnum+"','"+cardNumber+"','"+pinNumber+"')";
                    c1.s.executeUpdate(query1);
                    c1.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin:"+ pinNumber);
                        
                    new Deposit(pinNumber).setVisible(true);
                    setVisible(false);
                  }
            }
                
            else if(ae.getSource()==cancel)
                System.exit(0); 
        }   
        
        catch(Exception e)
        {
           System.out.println(e);
        }
             
    }

    public static void main(String args[])
    {
        new SignupThree(" ");
    }
}
