package employeemgmsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployees extends JFrame implements ActionListener{
    
    
    JTable table;
    Choice cemployeeId;
    JButton search,update,back,print;
    
    ViewEmployees(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //searching an employee
        JLabel searchlbl =new JLabel("Search by Employee Id");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);
        
        cemployeeId= new Choice();
        cemployeeId.setBounds(180,20,150,20);
        add(cemployeeId);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from employee");
            
            while(rs.next()) {
            cemployeeId.add(rs.getString("empId"));
        }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from employee");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0, 100, 1200, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(1200,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){//to perform the search button action
            String query = "select *from employee where empId= '"+cemployeeId.getSelectedItem()+"'";
            try{//above is connection to the mysql
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                //update of the table
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            
            try{
                table.print();//use to print the table froom java
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
            
        }
    }
    
    public static void main(String args[]){
        new ViewEmployees();
    }
}
