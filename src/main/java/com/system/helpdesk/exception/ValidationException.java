package com.system.helpdesk.exception;

public class ValidationException extends RuntimeException{

    public ValidationException(String mensagem) {
        super(mensagem);
    }
}
