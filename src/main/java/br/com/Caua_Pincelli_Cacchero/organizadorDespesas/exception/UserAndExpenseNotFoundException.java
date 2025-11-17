package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserAndExpenseNotFoundException extends RuntimeException {
    public UserAndExpenseNotFoundException(String message) {
        super(message);
    }
}
