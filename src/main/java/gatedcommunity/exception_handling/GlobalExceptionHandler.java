package gatedcommunity.exception_handling;

import gatedcommunity.exception_handling.exceptions.TextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TextException.class)
    public ResponseEntity<Response> handleTextException(TextException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponse> handleValidationException(MethodArgumentNotValidException ex) {
        // Cоздаем список ошибок для накопления сообщений об ошибках
        List<String> errors = new ArrayList<>();

        //перебираем все ошибки
        for (FieldError error: ex.getBindingResult().getFieldErrors()) {
            // Добавляем сообщение об ошибке для текущего поля
            errors.add(error.getField() + " ->  " +  error.getDefaultMessage());
        }

        //Создаем объект Response с накопленным сообщение
        ValidationResponse response = new ValidationResponse(errors);

        // Возвращаем ResponseEntity с объектом Response и статусом 400
        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }









}
