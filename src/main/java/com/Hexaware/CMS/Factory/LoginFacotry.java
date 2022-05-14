package com.Hexaware.CMS.Factory;

import com.Hexaware.CMS.Persistence.LoginDb;

/**
 * LoginFactory class used to fetch and insert data to database.
 * 
 * @author Dinesh Uttam Das
 */
public class LoginFacotry {

    public static boolean checkEmail(String email) {
        return LoginDb.checkEmail(email);
    }

    public static int resetPassword(String email, String pass) {
        return LoginDb.resetPassword(email, pass);
    }

    public static int getIdByType(String email) {
        return LoginDb.getIdByType(email);
    }

    public static int checkCredential(String email, String password) {
        return LoginDb.checkCredential(email, password);
    }

    public static int signupDb(int loginType, String email, String password) {
        return LoginDb.signupDb(loginType, email, password);
    }

}
