package employeemgmsys;


import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;


public class Home extends JFrame implements ActionListener{
    
    JButton view,remove,add,update;
    
    Home(){
        
        setLayout(null);
        
        //use to add image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2= i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading =new JLabel("Employee Management System");
        heading.setBounds(380, 20, 400, 40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        heading.setForeground(Color.RED);
        image.add(heading);
        
        add =new JButton("Add Employee");
        add.setBounds(380, 180, 150,40 );
        add.addActionListener(this);
        image.add(add);
        
        view =new JButton("View Employees");
        view.setBounds(620, 180, 150,40 );
        view.addActionListener(this);
        image.add(view);
        
        update =new JButton("Update Employee");
        update.setBounds(380, 280, 150,40 );
        update.addActionListener(this);
        image.add(update);
        
        remove =new JButton("Remove Employee");
        remove.setBounds(620, 280, 150,40 );
        remove.addActionListener(this);
        image.add(remove);
        
       
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployees();
        }else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployees();//this is done so that one can know the employee id to be updated
        }else{
            setVisible(false);
            new RemoveEmployee();

        }
        
    }
    

    
    public static void main(String[] args){
        new Home();
    }
}
