package com.company;
import java.sql.*;
import javax.swing.*;
import java.util.Scanner;


public class Main extends javax.swing.JFrame {
    public static JLabel label1 = new JLabel();
    public static JLabel label2 = new JLabel();
    public static Scanner kb = new Scanner(System.in);
    public static JTextArea ta = new JTextArea();
    public static void main(String[] args) throws ClassNotFoundException  {
        Class.forName("org.sqlite.JDBC");
        Connection c = null;
        JFrame frame = new JFrame("SQL Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement statement = c.createStatement();
            statement.setQueryTimeout(30);

//            statement.executeUpdate("drop table if exists employees");
//            statement.executeUpdate("create table employees (id integer, name string)");
//            statement.executeUpdate("insert into employees values(1, 'Josh')");
//            statement.executeUpdate("insert into employees values(2, 'Ron')");
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            frame.getContentPane().add(label1);
            frame.getContentPane().add(ta);

            frame.setVisible(true);
            while(rs.next()) {
                System.out.println("--------------------");
                System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("--------------------");
                label1.setText("ID - " + rs.getString("id") + " Name - " + rs.getString("name"));
                ta.setText(ta.getText() + "ID - " + rs.getString("id") + "\nName - " + rs.getString("name") + "\n\n");
                frame.pack();
            }
            c.close();
        } catch (Exception e){
            System.out.print(e.getMessage());
        }




    }

    private void createGroup() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label2)))
                                .addContainerGap(27, Short.MAX_VALUE))
        );
    }
}
