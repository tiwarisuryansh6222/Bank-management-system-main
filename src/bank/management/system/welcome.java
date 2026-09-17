package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class welcome extends JFrame implements ActionListener  {
    String pin;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    welcome(String pin){
        this.pin = pin;
        super("Welcome to the Bank");





        JLabel t1 = new JLabel("Welcome");
        t1.setBounds(330,100,600,30);
        t1.setFont(new Font("Raleway" , Font.BOLD , 25));
        t1.setBackground(new Color(255, 0, 0, 255));
        t1.setForeground(Color.RED);
        add(t1);

        b1 = new JButton("Deposit");
        b1.addActionListener(this);
        b1.setBounds(180,215,200,30);
        b1.setFont(new Font("Raleway" , Font.BOLD , 15));
        b1.setForeground(Color.RED);
        b1.setBackground(Color.BLUE);
        add(b1);

        b2 = new JButton("Cash Withdrawal");
        b2.addActionListener(this);
        b2.setBounds(180,270,200,30);
        b2.setFont(new Font("Raleway" , Font.BOLD , 15));
        b2.setForeground(Color.RED);
        b2.setBackground(Color.BLUE);
        add(b2);



        b4 = new JButton("Mini Statement");
        b4.addActionListener(this);
        b4.setBounds(420,325,200,30);
        b4.setFont(new Font("Raleway" , Font.BOLD , 15));
        b4.setForeground(Color.RED);
        b4.setBackground(Color.BLUE);
        add(b4);

        b5 = new JButton("Pin Change");
        b5.addActionListener(this);
        b5.setBounds(420,215,200,30);
        b5.setFont(new Font("Raleway" , Font.BOLD , 15));
        b5.setForeground(Color.RED);
        b5.setBackground(Color.BLUE);
        add(b5);

        b6= new JButton("Balance Enquiry");
        b6.addActionListener(this);
        b6.setBounds(420,270,200,30);
        b6.setFont(new Font("Raleway" , Font.BOLD , 15));
        b6.setForeground(Color.RED);
        b6.setBackground(Color.BLUE);
        add(b6);

        b7= new JButton("Exit");
        b7.addActionListener(this);
        b7.setBounds(350,400,100,50);
        b7.setFont(new Font("Raleway" , Font.BOLD , 20));
        b7.setForeground(Color.RED);
        b7.setBackground(Color.BLUE);
        add(b7);
//
//        b8 = new JButton("Cash");
//        b8.setBounds(500,380,100,30);
//        b8.setFont(new Font("Raleway" , Font.BOLD , 20));
//        b8.setForeground(Color.RED);
//        b8.setBackground(Color.BLUE);
//        add(b8);








        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1500,1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(1080,1080,1500,1080);
        add(i4);



        setSize(1080,1080);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==b1){
                new deposit(pin);
            }
            if(e.getSource()==b2){
                new withdrawal(pin);

            }

            if(e.getSource()==b4){
                new mini (pin);
            }
            if(e.getSource()==b5){
                setVisible(false);
                new pinchange(pin);
            }
            if(e.getSource()==b6){
                dbcon c1 = new dbcon();
                ResultSet set = c1.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int tbalance = 0 ;
                while (set.next()){
                    if (set.getString("type").equals("deposit")) {
                        tbalance += Integer.parseInt(set.getString("amount"));
                    } else {
                        tbalance -= Integer.parseInt(set.getString("amount"));
                    }
                }
                JOptionPane.showMessageDialog(null , "your current balance is Rs. "+ tbalance + "\nThankyou");
            }


            if(e.getSource()==b7){
                System.exit(0);

            }



        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
       new welcome("");
    }
}
