package employeemgmsys;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener{
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //use to add heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(380,30,1200,40);
        heading.setFont(new Font("serif",Font.PLAIN,40));
        heading.setForeground(Color.red);
        add(heading);
        
        //use to add image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2= i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        //use to add button
        JButton clickhere=new JButton("Click here to continue");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this); //use to catch the button click goes to action func
        image.add(clickhere);
        
        setSize(1170,650);//use to make a frame
        setLocation(200,50);//use to change popup location of the frame
        setVisible(true);//use to show frame
        
        while(true){
            heading.setVisible(false);//use for blink effect
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
                        heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String args[]) {
        new Splash();
    }
}
