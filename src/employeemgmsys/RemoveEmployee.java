package employeemgmsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpid;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid = new JLabel("Employee Id");   
        labelempid.setBounds(50, 50, 100,30);
        add(labelempid);
        
        
        cEmpid=new Choice();
        cEmpid.setBounds(200, 50, 100,30);
        add(cEmpid);
        
        try{
           Conn c= new Conn();
           String query="select *from employee";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               cEmpid.add(rs.getString("empId"));
           }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");   
        labelname.setBounds(50, 100, 100,30);
        add(labelname);
        
        JLabel lblname = new JLabel();   
        lblname.setBounds(200, 100, 100,30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");   
        labelphone.setBounds(50, 150, 100,30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();   
        lblphone.setBounds(200, 150, 100,30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");   
        labelemail.setBounds(50, 200, 100,30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();   
        lblemail.setBounds(200, 200, 200,30);
        add(lblemail);
        
        try{
           Conn c= new Conn();
           String query="select *from employee where empId ='"+cEmpid.getSelectedItem()+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               lblname.setText(rs.getString("name"));
               lblphone.setText(rs.getString("phonenumber"));
               lblemail.setText(rs.getString("email"));
               
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
        cEmpid.addItemListener(new ItemListener() {
            
            public void itemStateChanged(ItemEvent ie){
                try{
           Conn c= new Conn();
           String query="select *from employee where empId ='"+cEmpid.getSelectedItem()+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next()){
               lblname.setText(rs.getString("name"));
               lblphone.setText(rs.getString("phonenumber"));
               lblemail.setText(rs.getString("email"));
               
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
                
            
            }
            
          });
        
        
        delete=new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.addActionListener(this);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        //use to add image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2= i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    
 
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c=new Conn();
                String query="delete from employee where empId='"+cEmpid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee information deleted");
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
        new RemoveEmployee();
    }
}
