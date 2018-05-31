package com.example.jessicairving.myapplication;


public class Validator {

    public String password;

    // Sets the password string
    public void setPassword(String pass) {
        password = pass;
    }

    // Gets the password string
    public String getPassword() {
        return password;
    }

    // Returns 1 if the string has at least 8 characters, returns 0 otherwise
    public int passwordLength() {
        if (password.length() >= 8) {
            return 1;
        }
        return 0;
    }

    // Returns 1 if the password is not 'password' regardless of case. Returns 0
    // otherwise.
    public int passwordText() {
        if (!password.equalsIgnoreCase("password")) {
            return 1;
        }
        return 0;
    }


    // Adds up the number of tests passed and returns that number
    public int validate() {
        int passed = 0;
        passed += passwordText();
        passed += passwordLength();
        return passed;
    }
}
