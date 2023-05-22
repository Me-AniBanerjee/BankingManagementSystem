//package BankManagementSystem;

import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
//import java.util.*;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener
{
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, qualificationComboBox, occupationComboBox;
    JTextField panTextField, aadharTextField;
    JRadioButton seniorYes, seniorNo, existYes, existNo;
    JButton next;
    String formnum;

    SignupTwo(String formnum)
    {
        this.formnum = formnum;
        
        JLabel additionalDetails = new JLabel("Page 2: Additonal Details", JLabel.CENTER);
        additionalDetails.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        additionalDetails.setBounds(200,80,400,30);
        add(additionalDetails);
//------------------------------------------------------------------------------------------------------------------------------
        JLabel religion = new JLabel("Religion",JLabel.CENTER);
        religion.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        religion.setBounds(100,160,200,30); 
        add(religion);

        String r[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionComboBox = new JComboBox(r);
        religionComboBox.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        religionComboBox.setBounds(300,160,400,30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);
//------------------------------------------------------------------------------------------------------------------------------   
        JLabel category = new JLabel("Category",JLabel.CENTER);
        category.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        category.setBounds(100,210,200,30); 
        add(category);

        String ca[] = {"General","OBC","SC","ST","Other"};
        categoryComboBox = new JComboBox(ca);
        categoryComboBox.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        categoryComboBox.setBounds(300,210,400,30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);
//-----------------------------------------------------------------------------------------------------------------------------
        JLabel income = new JLabel("Income",JLabel.CENTER);
        income.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        income.setBounds(100,260,200,30); 
        add(income);

        String in[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        incomeComboBox = new JComboBox(in);
        incomeComboBox.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        incomeComboBox.setBounds(300,260,400,30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);
//-----------------------------------------------------------------------------------------------------------------------------   
        JLabel qualification = new JLabel("Qualification",JLabel.CENTER);
        qualification.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        qualification.setBounds(100,310,200,30); 
        add(qualification);

        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        qualificationComboBox = new JComboBox(education);
        qualificationComboBox.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        qualificationComboBox.setBounds(300,310,400,30);
        qualificationComboBox.setBackground(Color.WHITE);
        add(qualificationComboBox);
//-----------------------------------------------------------------------------------------------------------------------------  
        JLabel occupation = new JLabel("Occupation",JLabel.CENTER);
        occupation.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        occupation.setBounds(100,360,200,30); 
        add(occupation);

        String occu[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occupationComboBox = new JComboBox(occu);
        occupationComboBox.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        occupationComboBox.setBounds(300,360,400,30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);
//----------------------------------------------------------------------------------------------------------------------------- 
        JLabel pan = new JLabel("Pan Number",JLabel.CENTER);
        pan.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        pan.setBounds(100,410,200,30); 
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        panTextField.setBounds(300,410,400,30);
        add(panTextField);
//----------------------------------------------------------------------------------------------------------------------------- 
        JLabel aadhar = new JLabel("Aadhar Number",JLabel.CENTER);
        aadhar.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        aadhar.setBounds(100,460,200,30); 
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        aadharTextField.setBounds(300,460,400,30);
        add(aadharTextField);
//----------------------------------------------------------------------------------------------------------------------------- 
        JLabel seniorcitizen = new JLabel("Senior Citizen",JLabel.CENTER);
        seniorcitizen.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        seniorcitizen.setBounds(100,510,200,30); 
        add(seniorcitizen);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300,510,60,30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(450,510,60,30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);
//-----------------------------------------------------------------------------------------------------------------------------
        JLabel existingaccount = new JLabel("Existing Account",JLabel.CENTER);
        existingaccount.setFont(new Font(Font.SERIF, Font.BOLD, 20)); 
        existingaccount.setBounds(100,560,200,30); 
        add(existingaccount);

        existYes = new JRadioButton("Yes");
        existYes.setBounds(300,560,60,30);
        existYes.setBackground(Color.WHITE);
        add(existYes);

        existNo = new JRadioButton("No");
        existNo.setBounds(450,560,60,30);
        existNo.setBackground(Color.WHITE);
        add(existNo);

        ButtonGroup existGroup = new ButtonGroup();
        existGroup.add(existYes);
        existGroup.add(existNo);
//-----------------------------------------------------------------------------------------------------------------------------
        next = new JButton("Next");
        next.setBounds(600,650,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);   
        add(next);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(850,800);
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
        String religion = (String) religionComboBox.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String qualification = (String) qualificationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();

        String senior = "null";
        if(seniorYes.isSelected()==true)
             senior = "Yes";
        else if(seniorNo.isSelected()==true)
             senior ="No";  
           
        String exist = "null";
        if(existYes.isSelected()==true)
             exist = "Yes";
        else if(existNo.isSelected()==true)
             exist ="No"; 

        try
         {
                
             if(aadharTextField.equals("") || panTextField.equals(""))
                 JOptionPane.showMessageDialog(null, "Fill the required fields");
             Conn c = new Conn();
             String query = "insert into signuptwo values('"+formnum+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+exist+"')";
             c.s.executeUpdate(query); 

             new SignupThree(formnum).setVisible(true);
             setVisible(false);

         }    
        catch(Exception e)
         {
            System.out.println(e);
         }          
    }   

    public static void main(String args[])
    {
        new SignupTwo("");
    }
}
