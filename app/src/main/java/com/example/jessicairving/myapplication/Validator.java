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

    // Returns 1 if the password contains a number, returns 0 otherwise
    public int passwordNumber() {

    }

    // Returns 1 if the password contains an upper case letter, returns 0 otherwise
    public int passwordUpperCase() {

    }

    // Returns 1 if the password contains a lower case letter, returns 0 otherwise
    public int passwordLowerCase() {

    }

    // Returns 1 if the password does not contain whitespace, returns 0 otherwise
    public int passwordWhitespace() {

    }


    // Adds up the number of tests passed and returns that number
    public int validate() {
        int passed = 0;
        passed += passwordText();
        passed += passwordLength();
        passed += passwordNumber();
        passed += passwordUpperCase();
        passed += passwordLowerCase();
        passed += passwordWhitespace();
        return passed;
    }
}
