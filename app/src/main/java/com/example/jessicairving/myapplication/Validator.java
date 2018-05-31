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
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return 1;
            }
        }
        return 0;
    }

    // Returns 1 if the password contains an upper case letter, returns 0 otherwise
    public int passwordUpperCase() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return 1;
            }
        }
        return 0;
    }

    // Returns 1 if the password contains a lower case letter, returns 0 otherwise
    public int passwordLowerCase() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return 1;
            }
        }
        return 0;
    }

    // Returns 1 if the password does not contain whitespace, returns 0 otherwise
    public int passwordWhitespace() {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isSpaceChar(password.charAt(i))) {
                return 0;
            }
        }
        return 1;
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
