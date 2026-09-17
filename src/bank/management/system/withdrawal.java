package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class withdrawal extends JFrame implements ActionListener {
    String pin;

    TextField t1 ;
    JButton b1 , b2;
    withdrawal(String pin){
        this.pin=pin;
        super("Cash Withdrawal Section");
        JLabel j1 = new JLabel("Welcome to Cash Withdrawal Section");
        j1.setBounds(190,100,600,40);
        j1.setFont(new Font("Raleway" , Font.BOLD , 20));
        j1.setForeground(Color.CYAN);
        j1.setBackground(Color.BLUE);
        add(j1);
        //

        JLabel j2 = new JLabel("Enter the amount you want to withdraw : ");
        j2.setBounds(200,220,400,20);
        j2.setFont(new Font("Raleway" , Font.BOLD , 17));
        j2.setForeground(Color.WHITE);
        add(j2);

        t1 =  new TextField();
        t1.setBackground(new Color(226, 20, 52 ));
        t1.setForeground(Color.yellow);
        t1.setBounds(350,260,100,30);
        add(t1);

        //

        b1 = new JButton("Withdraw");
        b1.addActionListener(this);
        b1.setFont(new Font("Raleway" , Font.BOLD , 18));
        b1.setBackground(new Color(220, 194, 9));
        b1.setForeground(Color.BLUE );
        b1.setBounds(350,300,100,50);
        add(b1);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setFont(new Font("Raleway" , Font.BOLD , 18));
        b2.setBackground(new Color(220, 194, 9));
        b2.setForeground(Color.BLUE );
        b2.setBounds(350,350,100,50);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1500,1080,Image.SCALE_DEFAULT);
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
        try {
            String amount = t1.getText();
            Date date = new Date();

            if(e.getSource()==b1) {

                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount");
                } else {
                    dbcon c1 = new dbcon();
                    ResultSet set = c1.statement.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (set.next()) {
                        if (set.getString("type").equals("deposit")) {
                            balance += Integer.parseInt(set.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(set.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        return;
                    }

                    c1.statement.executeUpdate("insert into bank values('" + pin + "' , '" + date + "' , 'withdrawal' , '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Withdrawal of Rs. " + amount + " successfull");
                    setVisible(false);
                    new welcome(pin);

                }
            } else if (e.getSource()==b2) {
                setVisible(false);
                new welcome(pin);

            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new withdrawal("");
    }
}
