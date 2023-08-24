package employeemgmsys;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tffname,tfsalary,tfaddress,tfphno,tfemail,tfdesig,tfaadhar;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel labeleid;
    JButton add,back;
    
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Employees Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        //name
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif",Font.BOLD,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        //father name
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
        
        dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        
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
        
        String courses[] ={"BBA","BCA","BA","MBA","CA","B.TECH CSE","BTECH ENG","MTECH","PHD","MSC"};
        
        cbeducation =new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);
        
        
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
        
        tfaadhar =new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        //employeeid
        JLabel labelid=new JLabel("Employee ID");
        labelid.setBounds(50, 400, 150, 30);
        labelid.setFont(new Font("serif",Font.BOLD,20));
        add(labelid);
        
        labeleid=new JLabel(""+number);
        labeleid.setBounds(200, 400, 150, 30);
        labeleid.setFont(new Font("serif",Font.BOLD,20));
        add(labeleid);
        
        //Button creation
        add =new JButton("Add Details");
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
            String name =tfname.getText();
            String fname=tffname.getText();
            String dob  = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary =tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphno.getText();
            String email=tfemail.getText();
            String education= (String)cbeducation.getSelectedItem();
            String designation=tfdesig.getText();
            String aadhar=tfaadhar.getText();
            String id=labeleid.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+id+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added succesfully");
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
     new AddEmployee();   
    }
     
}
