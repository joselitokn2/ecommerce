package com.wirtz.ecommerce.modelutil.exceptions;

@SuppressWarnings("serial")
public class DuplicateInstanceException extends InstanceException {

    public DuplicateInstanceException(Object key, String className) {
        super("Duplicate instance", key, className);
    }
    
}
