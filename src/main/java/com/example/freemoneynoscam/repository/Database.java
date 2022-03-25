package com.example.freemoneynoscam.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    //Declaring the connection and statement
    static Connection con;
    static Statement stmt;

    //Method to connect to my database
    public static void connectToDB(String email) {

        try {
            //Declaring my url with an assigned value as my database link
            String url = "jdbc:mysql://localhost:3306/free_money";
            //Attempting to get a connection with the before given url, together with the username and password to the database
            con = DriverManager.getConnection(url, "root", "Kiy3ia3#"); //For password see comment on my answer

            System.out.println("URL: " + url);
            System.out.println("Success");
        }
        catch (Exception e) {
            System.out.println("Couldn't connect to database");
            e.printStackTrace();
        }
    }

    public static void addEmailToDB(String email) {

        try
        {
            //Connecting to the database by using the connectToDB-method
            connectToDB(email);
            //Inserting email into the table free_emails
            String insertSQL = "INSERT INTO free_emails "
                + "(`email`) "
                + "VALUES('"+ email +"')";

            //Establish a connection and creating a statement to send an SQL query to the database
            stmt = con.createStatement();
            //Updating the table
            stmt.executeUpdate(insertSQL);

            //Close the connection
            con.close();

        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    }
}
