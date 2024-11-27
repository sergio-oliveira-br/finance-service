package com.alucontrol.financeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;
import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle custom resource not found exception
    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<ProblemDetails> handleExpenseNotFoundException(ExpenseNotFoundException ex) {

        ProblemDetails problemDetails = new ProblemDetails(
            HttpStatus.NOT_FOUND.toString(),
            "Expense Not Found",
            ex.getMessage(),
            "A despesa solicitada não foi encontrada",
                UUID.randomUUID()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetails);
    }

    // Handle custom resource not found exception
    @ExceptionHandler(IncomeNotFoundException.class)
    public ResponseEntity<ProblemDetails> handleIncomeNotFoundException(IncomeNotFoundException ex) {

        ProblemDetails problemDetails = new ProblemDetails(
            HttpStatus.NOT_FOUND.toString(),
            "Income Not Found",
            ex.getMessage(),
            "O Faturamento solicitado nao foi encontrado",
            UUID.randomUUID()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetails);
    }

    //Handling generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetails> handleException(Exception ex){

        ProblemDetails problemDetails = new ProblemDetails(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                "Internal Server Error",
                "Ocorreu um erro inesperado no servidor",
                ex.getMessage(),
                UUID.randomUUID()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetails);
    }

    //Deals with timeout of communication between microservices
    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ProblemDetails> handleTimeoutException(TimeoutException ex){

        ProblemDetails problemDetails = new ProblemDetails(
                HttpStatus.REQUEST_TIMEOUT.toString(),
                "Request Timeout",
                "O tempo de resposta do microserviço de destino expirou",
                ex.getMessage(),
                UUID.randomUUID()
        );
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(problemDetails);
    }
}
