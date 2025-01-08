package br.com.jean.wedding.advice;

import br.com.jean.wedding.dto.ErrorDTO;
import br.com.jean.wedding.exceptions.ItemConflictException;
import br.com.jean.wedding.exceptions.ItemInvalidException;
import br.com.jean.wedding.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerAdivice {


    @ExceptionHandler(ItemConflictException.class)
    public ResponseEntity<ErrorDTO> itemConflictException(ItemConflictException e) {
        return ResponseEntity.status(409).body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(ItemInvalidException.class)
    public ResponseEntity<ErrorDTO> itemInvalidException(ItemInvalidException e) {
        return ResponseEntity.status(400).body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorDTO> itemNotFoundException(ItemNotFoundException e) {
        return ResponseEntity.status(404).body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(400).body(new ErrorDTO(e.getMessage()));
    }
}
