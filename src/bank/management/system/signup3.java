package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {
    long appno;
    JButton button, button2;
    JComboBox c1,c2,c3;
    JRadioButton r1,r2,r3,r4;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;



    signup3(long appno){
        this.appno = appno;
        super("Sign-up page");
        setLayout(null);


        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image iii2 = iii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel image3 = new JLabel(iii3);
        image3.setBounds(20,20,100,100);
        add(image3);

        JLabel t1 = new JLabel("Account Details");
        t1.setFont(new Font("Raleway",Font.BOLD,35));
        t1.setBounds(300,40,400,40);
        add(t1);


        JLabel t2 = new JLabel("Account type : ");
        t2.setFont(new Font("Raleway",Font.BOLD,17));
        t2.setBounds(100,200,200,20);
        add(t2);
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100,230,200,20);
        r1.setFont(new Font("Raleway",Font.BOLD , 13));
        add(r1);
        r2 = new JRadioButton("Demate Account");
        r2.setBounds(500,230,200,20);
        r2.setFont(new Font("Raleway",Font.BOLD , 13));
        add(r2);
        r3 = new JRadioButton("Fixed deposit Account");
        r3.setBounds(100,270,200,20);
        r3.setFont(new Font("Raleway",Font.BOLD , 13));
        add(r3);
        r4 = new JRadioButton("Recurring saving Account");
        r4.setBounds(500,270,250,20);
        r4.setFont(new Font("Raleway",Font.BOLD , 13));
        add(r4);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);
        bg1.add(r4);

        JLabel t3 = new JLabel("Card Number : ");
        t3.setFont(new Font("Raleway",Font.BOLD,17));
        t3.setBounds(100,320,200,20);
        add(t3);
        JLabel t4 = new JLabel("(your 16 Digit Card Number)");
        t4.setFont(new Font("Raleway",Font.BOLD,11));
        t4.setBounds(100,350,200,11);
        add(t4);
        JLabel t5 = new JLabel("XXXX-XXXX-XXXX-4841");
        t5.setFont(new Font("Raleway",Font.BOLD,17));
        t5.setBounds(400,320,400,20);
        add(t5);
        JLabel t6 = new JLabel("(It would appear on your cheque/statements/card)");
        t6.setFont(new Font("Raleway",Font.BOLD,11));
        t6.setBounds(400,350,400,11);
        add(t6);

        JLabel t7 = new JLabel("PIN : ");
        t7.setFont(new Font("Raleway",Font.BOLD,17));
        t7.setBounds(100,390,200,20);
        add(t7);
        JLabel t8 = new JLabel("(Your four digit password)");
        t8.setFont(new Font("Raleway",Font.BOLD,11));
        t8.setBounds(100,420,200,11);
        add(t8);
        JLabel t9 = new JLabel("XXXX");
        t9.setFont(new Font("Raleway",Font.BOLD,17));
        t9.setBounds(400,390,400,20);
        add(t9);
        JLabel t10 = new JLabel("(Kindly use it when you login to the app)");
        t10.setFont(new Font("Raleway",Font.BOLD,11));
        t10.setBounds(400,420,400,11);
        add(t10);

        //
        JLabel t11 = new JLabel("Service Required : ");
        t11.setFont(new Font("Raleway",Font.BOLD,17));
        t11.setBounds(100,450,200,20);
        add(t11);

        cb1 = new JCheckBox("ATM card");
        cb1.setFont(new Font("Raleway" , Font.BOLD , 14));
        cb1.setBounds(100,490,200,20);
        add(cb1);
        cb2 = new JCheckBox("Cheque Book");
        cb2.setFont(new Font("Raleway" , Font.BOLD , 14));
        cb2.setBounds(400,490,200,20);
        add(cb2);
        cb3 = new JCheckBox("E-Statement");
        cb3.setFont(new Font("Raleway" , Font.BOLD , 14));
        cb3.setBounds(100,530,200,20);
        add(cb3);
        cb4 = new JCheckBox("E-Mail Alerts");
        cb4.setFont(new Font("Raleway" , Font.BOLD , 14));
        cb4.setBounds(400,530,200,20);
        add(cb4);
        cb5 = new JCheckBox("Internet Banking");
        cb5.setFont(new Font("Raleway" , Font.BOLD , 14));
        cb5.setBounds(100,570,200,20);
        add(cb5);
        cb6 = new JCheckBox("Mobile Banking");
        cb6.setFont(new Font("Raleway" , Font.BOLD , 14));
        cb6.setBounds(400,570,200,20);
        add(cb6);

        cb7 = new JCheckBox("I here by declare that all the information provided by me was correct.",true);
        cb7.setBounds(100,630,600,20);
        cb7.setFont(new Font("Raleway" , Font.ITALIC, 15));
        add(cb7);

        button = new JButton("Submit");
        button.addActionListener(this);
        button.setFont(new Font("Raleway", Font.BOLD,15));
        button.setBounds(310,680,100,50);
        add(button);

        button2 = new JButton("Cancle");
        button2.addActionListener(this);
        button2.setFont(new Font("Raleway", Font.BOLD,15));
        button2.setBounds(430,680,100,50);
        add(button2);
//
        setSize(850,800);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if(r1.isSelected()){
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype= "Demate Account";

        } else if (r3.isSelected()) {
            atype="Fixed deposit Account";
        } else if (r4.isSelected()) {
            atype = "Recurring saving Account";
        }
        Random ram = new Random();
        long first7 = (ram.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = ""+Math.abs(first7);
        long first3 = (ram.nextLong() % 9000L) + 1000L ;
        String pin = "" + Math.abs(first3);

        String fac = "";
        if(cb1.isSelected()){
            fac += "ATM card";

        } else if (cb2.isSelected()) {
            fac += "Cheque Book";
        } else if (cb3.isSelected()) {
            fac += "E-Statement";
        }else if(cb4.isSelected()){
            fac +="E-Mail Alerts";
        } else if (cb5.isSelected()) {
            fac +="Internet Banking";
        } else if (cb6.isSelected()) {
            fac +="Mobile Banking";
        }


        try{
            if(e.getSource()==button){
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter all the fields");
                }else{
                    dbcon c1 = new dbcon();
                    String q1 = "insert into signup3 values('"+appno+"' , '"+atype+"' , '"+cardno+"' , '"+pin+"' , '"+fac+"')";
                    String q2 = "insert into login values ('"+appno+"' , '"+cardno+"' , '"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null , "Card no: "+ cardno + "\n pin: " + pin);
                    setVisible(false);
                    new deposit(pin);
                }
            } else if (e.getSource()==button2) {
                System.exit(0);


            }

        }catch(Exception ae){
            ae.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup3(1234L);
    }
}
