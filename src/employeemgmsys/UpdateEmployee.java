package employeemgmsys;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    
    
    JTextField tfeducation,tffname,tfsalary,tfaddress,tfphno,tfemail,tfdesig,tfaadhar;
    
    JLabel labeleid;
    JButton add,back;
    String empId;
    
    UpdateEmployee(String empId){
        this.empId=empId;//storing of local into global  
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Update Employees Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        //name is uneditable
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif",Font.BOLD,20));
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        //father name is uneditable
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif",Font.BOLD,20));
        add(labelfname);
        
        tffname =new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //dateofbirth
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif",Font.BOLD,20));
        add(labeldob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        
        //Salary
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif",Font.BOLD,20));
        add(labelsalary);
        
        tfsalary =new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        //address
        JLabel labeladdress=new JLabel("Addreess");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif",Font.BOLD,20));
        add(labeladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //Phonenumber
        JLabel labelphno=new JLabel("PhoneNumber");
        labelphno.setBounds(400, 250, 150, 30);
        labelphno.setFont(new Font("serif",Font.BOLD,20));
        add(labelphno);
        
        tfphno =new JTextField();
        tfphno.setBounds(600,250,150,30);
        add(tfphno);
        
        //email
        JLabel labelemail=new JLabel("Email(gmail.com)");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif",Font.BOLD,20));
        add(labelemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //education
        JLabel labeleducation=new JLabel("Qualification");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif",Font.BOLD,20));
        add(labeleducation);
        
        
        
        tfeducation =new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        
        //Designation
        JLabel labeldesig=new JLabel("Designation");
        labeldesig.setBounds(50, 350, 150, 30);
        labeldesig.setFont(new Font("serif",Font.BOLD,20));
        add(labeldesig);
        
        tfdesig =new JTextField();
        tfdesig.setBounds(200,350,150,30);
        add(tfdesig);
        
        //AadharNumber
        JLabel aadhar=new JLabel("AadharNumber");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("serif",Font.BOLD,20));
        add(aadhar);
        
        JLabel lblaadhar =new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        //employeeid
        JLabel labelid=new JLabel("Employee ID");
        labelid.setBounds(50, 400, 150, 30);
        labelid.setFont(new Font("serif",Font.BOLD,20));
        add(labelid);
        
        labeleid=new JLabel();
        labeleid.setBounds(200, 400, 150, 30);
        labeleid.setFont(new Font("serif",Font.BOLD,20));
        add(labeleid);
        
        //calling id for the update 
        try{
            Conn c  = new Conn();
            String query="select *from employee where empId = '"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                
                tfphno.setText(rs.getString("phonenumber"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesig.setText(rs.getString("designaniton"));
                lblaadhar.setText(rs.getString("aadhar"));
                labeleid.setText(rs.getString("empId"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        //Button creation
        add =new JButton("Update Details");
        add.setBounds(250, 500, 150,40 );
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
                
        back =new JButton("Back");
        back.setBounds(500, 500, 150,40 );
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    //taking click
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
           // String name =tfname.getText();
            String fname=tffname.getText();
            //String dob  = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary =tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphno.getText();
            String email=tfemail.getText();
            String education= tfeducation.getText();
            String designation=tfdesig.getText();
            //String aadhar=tfaadhar.getText();
            //String id=labeleid.getText();
            
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"',salary='"+salary+"',address='"+address+"',phonenumber='"+phone+"',email='"+email+"',education='"+education+"',designaniton='"+designation+"' where empId='"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated succesfully");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
     new UpdateEmployee("");   
    }
     
}

