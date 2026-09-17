package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class signup extends JFrame implements ActionListener {

    // Class-level variables
    JTextField f3, f4, f5, f6, f7, p9, p10, p13, p14, p15, p16;
    JRadioButton c1, c2, c3;
    Checkbox c4;
    JDateChooser d1;
    JButton b1;
    int appno;

    signup() {
        Random ran = new Random();
        appno = 1000 + ran.nextInt(9000); // 4-digit application number

        super("Sign-up");

        // Heading
        JLabel t1 = new JLabel("Application form no. " + appno);
        t1.setFont(new Font("Alice", Font.BOLD, 35));
        t1.setBounds(200, 30, 500, 40);
        add(t1);

        JLabel t12 = new JLabel("Personal Details");
        t12.setFont(new Font("Alice", Font.BOLD, 20));
        t12.setBounds(340, 80, 500, 40);
        add(t12);

        JLabel t2 = new JLabel("Page 1");
        t2.setFont(new Font("Ralway", Font.ITALIC, 15));
        t2.setBounds(790, 10, 100, 40);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(20, 20, 100, 100);
        add(i4);

        // First Name
        JLabel t3 = new JLabel("First name : ");
        t3.setFont(new Font("Ralway", Font.PLAIN, 17));
        t3.setBounds(100, 150, 150, 20);
        add(t3);
        f3 = new JTextField(15);
        f3.setBounds(350, 150, 300, 20);
        add(f3);

        // Last Name
        JLabel t4 = new JLabel("Last name : ");
        t4.setFont(new Font("Ralway", Font.PLAIN, 17));
        t4.setBounds(100, 190, 150, 20);
        add(t4);
        f4 = new JTextField(15);
        f4.setBounds(350, 190, 300, 20);
        add(f4);

        // Email
        JLabel t5 = new JLabel("E-mail : ");
        t5.setFont(new Font("Ralway", Font.PLAIN, 17));
        t5.setBounds(100, 230, 150, 20);
        add(t5);
        f5 = new JTextField(15);
        f5.setBounds(350, 230, 300, 20);
        add(f5);

        // Aadhar
        JLabel t6 = new JLabel("Aadhar number : ");
        t6.setFont(new Font("Ralway", Font.PLAIN, 17));
        t6.setBounds(100, 270, 150, 20);
        add(t6);
        f6 = new JTextField(15);
        f6.setBounds(350, 270, 300, 20);
        add(f6);

        // Phone
        JLabel t7 = new JLabel("Phone no. : ");
        t7.setFont(new Font("Ralway", Font.PLAIN, 17));
        t7.setBounds(100, 310, 150, 20);
        add(t7);
        f7 = new JTextField(15);
        f7.setBounds(350, 310, 300, 20);
        add(f7);

        // Gender
        JLabel t8 = new JLabel("Gender : ");
        t8.setFont(new Font("Ralway", Font.PLAIN, 17));
        t8.setBounds(100, 350, 150, 20);
        add(t8);
        c1 = new JRadioButton("Male");
        c2 = new JRadioButton("Female");
        c3 = new JRadioButton("Others");
        c1.setBounds(350, 350, 100, 25);
        c2.setBounds(450, 350, 100, 25);
        c3.setBounds(550, 350, 100, 25);
        add(c1);
        add(c2);
        add(c3);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(c1);
        bg1.add(c2);
        bg1.add(c3);

        // Date of Birth
        JLabel dob = new JLabel("Date of birth : ");
        dob.setFont(new Font("Ralway", Font.PLAIN, 17));
        dob.setBounds(100, 390, 150, 20);
        add(dob);
        d1 = new JDateChooser();
        d1.setBounds(350, 390, 200, 20);
        add(d1);

        // Father's Name
        JLabel t9 = new JLabel("Father's name :");
        t9.setFont(new Font("Ralway", Font.PLAIN, 17));
        t9.setBounds(100, 440, 150, 20);
        add(t9);
        p9 = new JTextField(15);
        p9.setBounds(350, 440, 200, 20);
        add(p9);

        // Occupation
        JLabel t10 = new JLabel("Occupation : ");
        t10.setFont(new Font("Ralway", Font.PLAIN, 17));
        t10.setBounds(100, 480, 150, 20);
        add(t10);
        p10 = new JTextField(15);
        p10.setBounds(350, 480, 200, 20);
        add(p10);

        // Nationality
        JLabel t11 = new JLabel("Nationality : ");
        t11.setFont(new Font("Ralway", Font.PLAIN, 17));
        t11.setBounds(100, 520, 150, 20);
        add(t11);
        c4 = new Checkbox("Indian");
        c4.setBounds(350, 520, 200, 25);
        add(c4);

        // Address
        JLabel t13 = new JLabel("Address : ");
        t13.setFont(new Font("Ralway", Font.PLAIN, 17));
        t13.setBounds(100, 560, 150, 20);
        add(t13);
        p13 = new JTextField(15);
        p13.setBounds(350, 560, 200, 20);
        add(p13);

        // City
        JLabel t14 = new JLabel("City : ");
        t14.setFont(new Font("Ralway", Font.PLAIN, 17));
        t14.setBounds(100, 600, 150, 20);
        add(t14);
        p14 = new JTextField(15);
        p14.setBounds(350, 600, 200, 20);
        add(p14);

        // PIN Code
        JLabel t15 = new JLabel("PIN-CODE : ");
        t15.setFont(new Font("Ralway", Font.PLAIN, 17));
        t15.setBounds(100, 640, 150, 20);
        add(t15);
        p15 = new JTextField(15);
        p15.setBounds(350, 640, 200, 20);
        add(p15);

        // State
        JLabel t16 = new JLabel("State :");
        t16.setFont(new Font("Ralway", Font.PLAIN, 17));
        t16.setBounds(100, 680, 150, 20);
        add(t16);
        p16 = new JTextField(15);
        p16.setBounds(350, 680, 200, 20);
        add(p16);

        // Next Button
        b1 = new JButton("Next");
        b1.setBounds(380, 720, 100, 30);
        b1.addActionListener(this);
        add(b1);

        setLayout(null);
        setSize(850, 800);
        setLocation(350, 50);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {

                // Get all input values
                String firstName = f3.getText();
                String lastName = f4.getText();
                String email = f5.getText();
                String aadhar = f6.getText();
                String phone = f7.getText();
                String gender = c1.isSelected() ? "Male" : c2.isSelected() ? "Female" : "Others";
                java.util.Date dobValue = d1.getDate();
                String dob = new java.sql.Date(dobValue.getTime()).toString();
                String fatherName = p9.getText();
                String occupation = p10.getText();
                String nationality = c4.getState() ? "Indian" : "";
                String address = p13.getText();
                String city = p14.getText();
                String pinCode = p15.getText();
                String state = p16.getText();

                // JDBC insertion using PreparedStatement
                dbcon c = new dbcon();
                String query = "INSERT INTO signup (application_no, first_name, last_name, email, aadhar_number, phone_number, gender, dob, father_name, occupation, nationality, address, city, pin_code, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = c.connection.prepareStatement(query);
                pst.setInt(1, appno);
                pst.setString(2, firstName);
                pst.setString(3, lastName);
                pst.setString(4, email);
                pst.setString(5, aadhar);
                pst.setString(6, phone);
                pst.setString(7, gender);
                pst.setString(8, dob);
                pst.setString(9, fatherName);
                pst.setString(10, occupation);
                pst.setString(11, nationality);
                pst.setString(12, address);
                pst.setString(13, city);
                pst.setString(14, pinCode);
                pst.setString(15, state);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Saved Successfully!");
                new signup2(appno);
                setVisible(false);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new signup();
    }
}