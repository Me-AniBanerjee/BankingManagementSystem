//package BankManagementSystem;


import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JButton login, clear, signUp;
    JTextField cardDetails;
    JPasswordField passwordDetail;

    Login()
    {
        JLabel text = new JLabel("WELCOME TO YOUR BANK", JLabel.CENTER);
        text.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        text.setBounds(200,40,400,40);
        add(text);
        ////////////////////////////////////////////////////////////////////////////////////////////

        JLabel cardNumber = new JLabel("Card Number", JLabel.CENTER); 
        cardNumber.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        cardNumber.setBounds(120, 150, 150,30);
        add(cardNumber);
        
        JLabel password = new JLabel("Password", JLabel.CENTER); 
        password.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        password.setBounds(120, 220, 150,30);
        add(password);
        
        cardDetails = new JTextField(""); 
        cardDetails.setFont(new Font(Font.SERIF,Font.PLAIN ,10));
        cardDetails.setBounds(300, 150, 230,30);
        add(cardDetails); 

        passwordDetail = new JPasswordField(""); 
        passwordDetail.setBounds(300,220,230,30);
        add(passwordDetail);

        /////////////////////////////////////////////////////////////////////////////////////////////////
        
        login = new JButton("Login", null);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430,300,100,30); 
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Signup");
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.setBounds(300,350,230,30);
        signUp.addActionListener(this);
        add(signUp); 

        ///////////////////////////////////////////////////////////////////////////////////////////////

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(600, 450);
        setVisible(true);
        setLocationRelativeTo(null); 
        setTitle("WELCOME TO YOUR BANK"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {   
        if(ae.getSource() == login)
        {
            try
            {            
                Conn c1 = new Conn();
                String cardno  = cardDetails.getText();
                String pin  = passwordDetail.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next())
                {
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
            catch(Exception e)
            {}
         }
        else if(ae.getSource() == clear)
        {
             cardDetails.setText("");
             passwordDetail.setText("");
        }
        else if(ae.getSource() == signUp)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String args[])
    {
        new Login();
    }   
}
