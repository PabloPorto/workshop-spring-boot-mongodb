package com.pabloporto.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public ObjectNotFoundException (String msg){
        super(msg);
    }
}
