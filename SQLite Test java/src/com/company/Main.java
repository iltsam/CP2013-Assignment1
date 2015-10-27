package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;



public class Main {
    public static JFrame frame = new JFrame("SQL Test");
    public static JLabel label1 = new JLabel();
    public static JLabel label2 = new JLabel();
    public static JTextArea ta = new JTextArea();
    public static JButton butt = new JButton("Add Employee");
    public static Connection c = null;
    public static void main(String[] args) throws ClassNotFoundException  {
        Class.forName("org.sqlite.JDBC");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        displayTable();


        butt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    c = DriverManager.getConnection("jdbc:sqlite:test.db");
                    Statement statement = c.createStatement();
                    statement.setQueryTimeout(30);

                    statement.executeUpdate("insert into employees values(3, 'Brian')");

                    c.close();

                    displayTable();

                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
        });
        frame.setSize(600, 800);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2);
        frame.getContentPane().add(ta, gbc);
        gbc.gridy++;
        ta.setEditable(false);
        frame.getContentPane().add(butt, gbc);

//        frame.pack();
        frame.setVisible(true);
    }

    public static void displayTable() {
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement statement = c.createStatement();
            statement.setQueryTimeout(30);

//            statement.executeUpdate("drop table if exists employees");
//            statement.executeUpdate("create table employees (id integer, name string)");
//            statement.executeUpdate("insert into employees values(1, 'Josh')");
//            statement.executeUpdate("insert into employees values(2, 'Ron')");
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");


            ta.setText("");
            while(rs.next()) {
                System.out.println("--------------------");
                System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("--------------------");
                label1.setText("ID - " + rs.getString("id") + " Name - " + rs.getString("name"));
                ta.append("ID - " + rs.getString("id") + "\nName - " + rs.getString("name") + "\n\n");
//                ta.setText(ta.getText() + "ID - " + rs.getString("id") + "\nName - " + rs.getString("name") + "\n\n");

            }
            rs.close();
            c.close();
            frame.pack();
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

}
