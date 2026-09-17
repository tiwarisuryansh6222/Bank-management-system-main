package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup2 extends JFrame implements ActionListener {
    long appno;

    JTextField panTextField, aadharTextField;
    JComboBox<String> religionBox, categoryBox, incomeBox, educationBox, occupationBox , sibblings;
    JButton next;

    signup2(long appno) {
        this.appno = appno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(20, 20, 100, 100);
        add(i4);

        // Heading
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        additionalDetails.setBounds(260, 80, 500, 40);
        add(additionalDetails);

        // Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox<>(valReligion);
        religionBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        religionBox.setBackground(Color.WHITE);
        religionBox.setBounds(300, 140, 400, 30);
        add(religionBox);

        // Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox<>(valCategory);
        categoryBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        categoryBox.setBackground(Color.WHITE);
        categoryBox.setBounds(300, 190, 400, 30);
        add(categoryBox);

        // Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String[] incomeCategory = {"<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        incomeBox = new JComboBox<>(incomeCategory);
        incomeBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        incomeBox.setBackground(Color.WHITE);
        incomeBox.setBounds(300, 240, 400, 30);
        add(incomeBox);

        // Educational Qualification
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String[] educationValues = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        educationBox = new JComboBox<>(educationValues);
        educationBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        educationBox.setBackground(Color.WHITE);
        educationBox.setBounds(300, 305, 400, 30);
        add(educationBox);

        // Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 370, 200, 30);
        add(occupation);

        String[] occupationValues = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupationBox = new JComboBox<>(occupationValues);
        occupationBox.setFont(new Font("Raleway", Font.PLAIN, 16));
        occupationBox.setBackground(Color.WHITE);
        occupationBox.setBounds(300, 370, 400, 30);
        add(occupationBox);

        // PAN
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 420, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        panTextField.setBounds(300, 420, 400, 30);
        add(panTextField);

        // Aadhar
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 470, 200, 30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.PLAIN, 16));
        aadharTextField.setBounds(300, 470, 400, 30);
        add(aadharTextField);


        JLabel sib = new JLabel("No. of sibblings");
        sib.setBounds(100,520,200,30);
        sib.setFont(new Font("Raleway",Font.BOLD,20));
        add(sib);

        String [] sibblingvalues = {"one" , "two" , "three" , "none"};
        sibblings = new JComboBox<>(sibblingvalues);
        sibblings.setFont(new Font("Raleway", Font.PLAIN, 16));
        sibblings.setBackground(Color.WHITE);
        sibblings.setBounds(300,520,400,30);
        add(sibblings);



        // Next Button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.BLACK);
        next.setBounds(300, 600, 120, 35);
        next.addActionListener(this);
        add(next);

        // Frame Setup

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) educationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String siblings = (String) sibblings.getSelectedItem();

        try {
            if(pan.isEmpty() || aadhar.isEmpty()){
                JOptionPane.showMessageDialog(null , "Please Enter all the fields...");
            }
            else{
                dbcon dbcon1 = new dbcon();
                String q = "INSERT INTO signuptwo(application_no, religion, catagory, income, education, occupation, pan, aadhar, siblings) "
                        + "VALUES ('"+appno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+siblings+"')";
                dbcon1.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null , "Data saved successfully !!");
                new signup3(appno);
                setVisible(false);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        // Later connect to DB or next page

    }

    public static void main(String[] args) {
        new signup2(1234L);
    }
}