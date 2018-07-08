/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.validator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrator
 */
public class LoginValidator {
    private String emailPattern = "[a-z0-9A-Z]+([-|\\.]?[a-z0-9A-Z])*@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
    private String namePattern = "(([A-Z][a-z]+)\\s?)+([A-Z][a-z]+)?";
    private String passwordPattern ="[a-z]{8,}[0-9]+";
    private HashMap<String,String> errors = new HashMap();
    
    public LoginValidator(){ }
    
    public void add(String key, String err){
    errors.put(key,err);
    }
    
    public boolean validate(String pattern, String input){
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    
    public boolean checkEmpty(String email, String password){
        return password == null || email == null || email.isEmpty() || password.isEmpty();
    }
    
    public boolean validateEmail(String email){
        return validate(emailPattern,email);
    }
    
    public boolean validatePassword(String password){
        return validate(passwordPattern,password);
    }
}
