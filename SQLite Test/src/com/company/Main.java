package com.company;
import java.sql.*;



public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement statement = c.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists employees");
            statement.executeUpdate("create table employees (id integer, name string)");
            statement.executeUpdate("insert into employees values(1, 'Josh')");
            statement.executeUpdate("insert into employees values(2, 'Ron')");
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            while(rs.next()) {
                System.out.println("--------------------");
                System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
                System.out.println("--------------------");
            }
            c.close();
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
