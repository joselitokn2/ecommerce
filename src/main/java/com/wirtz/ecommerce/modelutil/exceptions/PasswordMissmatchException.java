package com.wirtz.ecommerce.modelutil.exceptions;

@SuppressWarnings("serial")
public class PasswordMissmatchException extends InstanceException {

    public PasswordMissmatchException(String key, String className) {
        super("Passwords don't match", key, className);
    }
    
}
