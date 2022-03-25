package com.example.freemoneynoscam.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailRepository {

    //Declaring the connection and statement
    static Connection con;
    static Statement stmt;

    static ArrayList<String> emails = new ArrayList<>();

    //Method to connect to my database
    public static void connectToDB(String email) {

        try {
            //Declaring my url with an assigned value as my database link
            String url = "jdbc:mysql://localhost:3306/free_money";
            //Attempting to get a connection with the before given url, together with the username and password to the database
            con = DriverManager.getConnection(url, "root", ""); //For password see comment on my answer

            System.out.println("URL: " + url);
            System.out.println("Success");
        }
        catch (Exception e) {
            System.out.println("Couldn't connect to database");
            e.printStackTrace();
        }
    }

    public static String fetchSingleEmail() {
        //Creating an empty email string;
        String email = "";
        connectToDB(email);

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT email FROM free_emails");

            while (rs.next()) {
                email = rs.getString("email");

            }
            return email;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static List<String> fetchAllEmails() {

        try {
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT email FROM free_emails");

            while (rs.next()) {
                String email = rs.getString("email");
                emails.add(email);
            }
            return emails;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
