package com.example.tacademy.terrykim;

import java.util.regex.Pattern;

/**
 * Created by Tacademy on 2017-06-29.
 */
public class Exception {
    public final static int TRUE = 1;
    public final static int FALSE = 0;
    private static Exception ourInstance = new Exception();

    public static Exception getInstance() {
        return ourInstance;
    }

    private Exception() {

    }
    public int emailException(String email){
        if(!Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+$",email)){
            return FALSE;
        }
        else
            return TRUE;
    }
}
