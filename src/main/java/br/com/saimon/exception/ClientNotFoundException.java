package br.com.saimon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClientNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ClientNotFoundException(String exception){
        super(exception);
    }
}
