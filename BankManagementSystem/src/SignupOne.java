//package BankManagementSystem;

import javax.swing.*;
import com.toedter.calendar.*;
//import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupOne extends JFrame implements ActionListener
{
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, married, unmarried;
    int r;
    String formnum;

    SignupOne()
    {
        int upper = 1000;
        int lower = 100000;
        r = (int) (Math.random() * (upper - lower)) + lower;
        formnum = Integer.toString(r);
        

        JLabel formno = new JLabel("APPLICATION FORM: "+r, JLabel.CENTER);
        formno.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        formno.setBounds(100,20,600,40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details", JLabel.CENTER);
        personDetails.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        personDetails.setBounds(200,80,400,30);
        add(personDetails);
//-----------------------------------------------------------------------------------------------------------------------
        JLabel name = new JLabel("Name",JLabel.CENTER);
        name.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        name.setBounds(100,140,200,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
//--------------------------------------------------------------------------------------------------------------------------
        JLabel fname = new JLabel("Father's Name",JLabel.CENTER);
        fname.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
//----------------------------------------------------------------------------------------------------------------------------
        JLabel dob = new JLabel("Date Of Birth",JLabel.CENTER);
        dob.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        add(dateChooser);
//------------------------------------------------------------------------------------------------------------------------        

        JLabel gender = new JLabel("Gender",JLabel.CENTER);
        gender.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
//-------------------------------------------------------------------------------------------------------------
        JLabel email = new JLabel("Email",JLabel.CENTER);
        email.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
//-----------------------------------------------------------------------------------------------------------------
        JLabel marital = new JLabel("Marital Status",JLabel.CENTER);
        marital.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,110,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,110,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);
//-----------------------------------------------------------------------------------------------------------------
        JLabel address = new JLabel("Address",JLabel.CENTER);
        address.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
//-----------------------------------------------------------------------------------------------------------------
        JLabel city = new JLabel("City",JLabel.CENTER);
        city.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
//-----------------------------------------------------------------------------------------------------------------
        JLabel state = new JLabel("State",JLabel.CENTER);
        state.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
//-----------------------------------------------------------------------------------------------------------------
        JLabel pincode = new JLabel("Pin Code",JLabel.CENTER);
        pincode.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);

//------------------------------------------------------------------------------------------------------------------
        next = new JButton("Next");
        next.setBounds(600,650,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);   
        add(next);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        setSize(850,800);
        setLocationRelativeTo(null); 
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setResizable(false);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = "null";
        if(male.isSelected()==true)
           gender = "male";
        else if(female.isSelected()==true)
           gender ="female";  
           
        String marital = "null";
        if(married.isSelected()==true)
            marital = "married";
        else if(unmarried.isSelected()==true)
            marital ="unmarried";  
        
        try
        {  
                if(ae.getSource()==next)
                {
                    if(nameTextField.getText().equals("")|| email.equals("") ||  address.equals("") ||
                    city.equals("") || state.equals("") || pincode.equals("") || dob.equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Fill all the required fields");
                    }
                         else
                        { 
                            Conn c = new Conn();
                            String query = "insert into signup values('"+formnum+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                            c.s.executeUpdate(query);

                            setVisible(false);
                            new SignupTwo(formnum).setVisible(true);
                
                        }       
               
                }
        } 
        catch(Exception e)
        {
                System.out.println(e);
        }   
    }

    public static void main(String args[])
    {
        new SignupOne();
    }
}
