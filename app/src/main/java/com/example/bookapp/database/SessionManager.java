package com.example.bookapp.database;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences userSession;
    SharedPreferences.Editor editor;
    Context _context;

    //Session Names
    public static final String SESSION_USERSESSION = "userLoginSession";
    public static final String SESSION_REMEMBERME = "rememberMe";

    //Login Session Variables
    private static final String IS_LOGIN = "IsLoggedIn";

    public static  final String KEY_FULLNAME = "fullName";
    public static  final String KEY_USERNAME = "userName";
    public static  final String KEY_EMAIL = "eMail";
    public static  final String KEY_PASSWORD = "password";
    public static  final String KEY_PHONENUMBER = "phoneNumber";
    public static  final String KEY_DATEOFBIRTH = "dateOfBirth";
    public static  final String KEY_GENDER = "gender";

    //Remember Me Variables
    private static final String IS_REMEMBERME = "IsRememberMe";

    public static final String KEY_SESSIONUSERNAME = "sessionUsername";
    public static final String KEY_SESSIONPASSWORD = "sessionPassword";

    public SessionManager(Context context, String SessionName) {
        this._context = context;
        userSession = _context.getSharedPreferences(SessionName, Context.MODE_PRIVATE);
        editor = userSession.edit();
    }

    /*
    Login Session Functions
     */

    public void CreateLoginSession(String fullname, String username, String email, String password , String phonenumber, String date_of_bith, String gender){
        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_FULLNAME, fullname);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_PHONENUMBER, phonenumber);
        editor.putString(KEY_DATEOFBIRTH, date_of_bith);
        editor.putString(KEY_GENDER, gender);

        editor.commit();
    }

    public HashMap<String,String> GetUserDetailsFromSession(){
        HashMap<String, String> userData = new HashMap<>();

        userData.put(KEY_FULLNAME, userSession.getString(KEY_FULLNAME,null));
        userData.put(KEY_USERNAME, userSession.getString(KEY_USERNAME,null));
        userData.put(KEY_EMAIL, userSession.getString(KEY_EMAIL,null));
        userData.put(KEY_PASSWORD, userSession.getString(KEY_PASSWORD,null));
        userData.put(KEY_PHONENUMBER, userSession.getString(KEY_PHONENUMBER,null));
        userData.put(KEY_DATEOFBIRTH, userSession.getString(KEY_DATEOFBIRTH,null));
        userData.put(KEY_GENDER, userSession.getString(KEY_GENDER,null));

        return userData;
    }

    public Boolean CheckLogin(){
        if (userSession.getBoolean(IS_LOGIN,true)){
            return true;
        }else {
            return false;
        }
    }

    public void LogoutUserFromSession(){
        editor.clear();
        editor.commit();
    }

    /*
    Remember Me Session Functions
     */

    public void CreateRememberMeSession(String username, String password){
        editor.putBoolean(IS_REMEMBERME, true);

        editor.putString(KEY_SESSIONUSERNAME, username);
        editor.putString(KEY_SESSIONPASSWORD, password);

        editor.commit();
    }

    public HashMap<String,String> GetRememberMeDetailsFromSession(){
        HashMap<String, String> rememberMeData = new HashMap<>();

        rememberMeData.put(KEY_SESSIONUSERNAME, userSession.getString(KEY_SESSIONUSERNAME,null));
        rememberMeData.put(KEY_SESSIONPASSWORD, userSession.getString(KEY_SESSIONPASSWORD,null));

        return rememberMeData;
    }

    public Boolean CheckRememberMe(){
        if (userSession.getBoolean(IS_REMEMBERME,true)){
            return true;
        }else {
            return false;
        }
    }
}
