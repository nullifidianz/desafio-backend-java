package com.nullifidianz.biblioteca.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LimiteEmprestimosException.class)
    public ResponseEntity<?> handleLimiteEmprestimos(LimiteEmprestimosException ex) {
        return buildErrorResponse("Limite de empréstimos atingido", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    

    @ExceptionHandler(LivroIndisponivelException.class)
    public ResponseEntity<?> handleLivroIndisponivel(LivroIndisponivelException ex) {
        return buildErrorResponse("Livro indisponível", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException ex) {
        return buildErrorResponse("Recurso não encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e ->
            erros.put(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
        return buildErrorResponse("Violação de restrição", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return buildErrorResponse("Erro interno", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Map<String, String>> buildErrorResponse(String tipo, String mensagem, HttpStatus status) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", tipo);
        erro.put("mensagem", mensagem);
        return ResponseEntity.status(status).body(erro);
    }
}
