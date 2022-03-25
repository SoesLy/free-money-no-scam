package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repository.Database;

public class ValidateEmailService {

    public static boolean isEmailValid(String email){

        //An if statement to se if the mail contains an '@' and an '.'
        if (email.contains("@") && email.contains(".")) {
            return true;
        } else {
            return false;
        }
    }

    public static String addEmail(String email) {

        //Using isEmailValid-method with an if-statement
        if (isEmailValid(email)) {
            //If true, add the email to the database via the dbConnection class and the addEmailToDatabase-method
            Database.addEmailToDB(email);
            return "successful";
        } else {
            return "unsuccessful";
        }
    }
}

//dbConnection.connectToDB(email);


