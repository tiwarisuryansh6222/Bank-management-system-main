package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel l1, l2 , l3;
    JTextField t1;
    JPasswordField p1;
    JButton b1 , b2 , b3;

    login(){
        super("Bank Management system");
        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        //
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 =  i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        l1 = new JLabel("WELCOME TO THE BANK");
        l1.setForeground(Color.red);
        l1.setFont(new Font("ralway" , Font.BOLD , 25));
        l1.setBounds(250,100,450,70);
        add(l1);

        l2 = new JLabel("Card Number : ");
        l2.setFont(new Font("ralway" , Font.BOLD , 28));
        l2.setBounds(150,200,450,50);
        add(l2);

        l3 = new JLabel("Pin : ");
        l3.setFont(new Font("ralway" , Font.BOLD , 28));
        l3.setBounds(150,250,450,50);
        add(l3);

        t1 = new JTextField(15);
        t1.setBounds(400,210,250,30);
        add(t1);

        p1 = new JPasswordField(15);
        p1.setBounds(400,250,250,30);
        add(p1);

        b1 = new JButton("Sign-in");
        b1.setBounds(280,320,100,40);
        b1.addActionListener(this);
        add(b1);



        b2 = new JButton("Sign-up");
        b2.addActionListener(this);
        b2.setBounds(280,370,220,40);
        b2.setForeground(Color.BLUE);
        b2.setBackground(Color.black);
        add(b2);

        b3 = new JButton("Clear");
        b3.setBounds(400,320,100,40);
        b3.addActionListener(this);
        add(b3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image iii2 = iii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel image3 = new JLabel(iii3);
        image3.setBounds(600,355,100,100);
        add(image3);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image ii2 = ii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image2 = new JLabel(ii3);
        image2.setBounds(0,0,850,480);
        add(image2);
        //
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
                dbcon c = new dbcon();
                String cardno = t1.getText();
                String pin = p1.getText();
                String q = "select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultset =  c.statement.executeQuery(q);
                if(resultset.next()){
                    setVisible(false);
                    new welcome(pin);
                }




                
            } else if (e.getSource()==b2) {
                new signup();
                setVisible(false);
                
            } else if (e.getSource()==b3) {
                t1.setText("");
                p1.setText("");
            }


        }catch(Exception E){
            E.printStackTrace();

        }
    }

    public static void main(String[] args) {
        new login();
    }
}


