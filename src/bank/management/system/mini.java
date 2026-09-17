package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class mini extends JFrame {
    String pin;
    JTable table;
    DefaultTableModel model;

    mini(String pin) {
        this.pin = pin;
        super("Mini Statement");

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Mini Statement", JLabel.CENTER);
        title.setFont(new Font("Raleway", Font.BOLD, 25));
        add(title, BorderLayout.NORTH);



        // Table setup
        String[] columns = {"Date", "Type", "Amount"};

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        try {
            dbcon c1 = new dbcon();
            String q = "SELECT * FROM bank WHERE pin = '" + pin + "' ORDER BY date DESC LIMIT 5";
            ResultSet rs = c1.statement.executeQuery(q);

            while (rs.next()) {
                String date = rs.getString("date");   // use getString if your date is stored as text
                String type = rs.getString("type");
                String amount = rs.getString("amount");

                model.addRow(new Object[]{date, type, "Rs. " + amount});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new mini("1234"); // Example pin
    }
}