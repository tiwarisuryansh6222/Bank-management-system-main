package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinchange extends JFrame implements ActionListener {
    String pin ;
    JLabel j1 ,j2,j3;
    JPasswordField t1 , t2 , t3;
    JButton b1 , b2;

    pinchange(String pin){
        this.pin = pin;
        super("PIN Change Section");
        j1 = new JLabel("PIN CHANGE");
        j1.setBounds(75,50,400,50);
        j1.setFont(new Font("Raleway" , Font.BOLD , 40));
        add(j1);

        j2 = new JLabel("New Pin : ");
        j2.setBounds(40,150,200,50);
        j2.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(j2);

        j3 = new JLabel("Confirm pin : ");
        j3.setBounds(40,200,200,50);
        j3.setFont(new Font("Raleway" , Font.BOLD , 20));
        add(j3);

        t1 = new JPasswordField();
        t1.setBounds(200 , 165 , 100  ,20);
        add(t1);

        t2 = new JPasswordField();
        t2.setBounds(200 , 215 , 100  ,20);
        add(t2);


        b1 = new JButton("Submit");
        b1.addActionListener(this);
        b1.setBounds(145 , 300 , 100,40);
        add(b1);

        b2 = new JButton("Cancle");
        b2.addActionListener(this);
        b2.setBounds(145 , 350 , 100,40);
        add(b2);



        setLayout(null);







        setSize(400,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pin1 = t1.getText();
        String pin2 = t2.getText();
        try{
            if(!t1.getText().equals(t2.getText())){
                JOptionPane.showMessageDialog(null,"Pin Mismatched");
            }
            if(e.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null , "please enter the pin");
                } else if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null , "please re-enter the pin");
                }

                dbcon c1 = new dbcon();
                String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update signup3 set pin = '"+pin1+"' where pin = '"+pin+"'";

                c1.statement.executeUpdate(q1);
                c1.statement.executeUpdate(q2);
                c1.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN change successfully");
                setVisible(false);
                new welcome(pin);
            }

        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new pinchange("");
    }
}
