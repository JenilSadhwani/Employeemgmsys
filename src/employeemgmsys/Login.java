package employeemgmsys;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername,tfpassword;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //used to create box infornt of username and password
        
        tfusername=new JTextField();
        tfusername.setBounds(150, 25, 150, 20);
        add(tfusername);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(150, 55, 150, 20);
        add(tfpassword);
        
        //used to create username and password written
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,18,100,30);
        add(lblusername);
        
        JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(40,50,100,30);
        add(lblpassword);
        
        //use to add image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        
        //use to create a login button
        JButton Login=new JButton("LOGIN");
        Login.setBounds(150, 150, 150, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
    
    
    
    
        setSize(600,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c=new Conn();
            
            String query = "select * from login where username = '"+username+"'and password = '"+password+"'";  
            
            ResultSet rs=c.s.executeQuery(query);
            
            
            if(rs.next()){
                setVisible(false);
                new Home();
            } else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        new Login();
    }
}
