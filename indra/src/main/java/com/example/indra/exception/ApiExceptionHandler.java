package com.example.indra.exception;

import com.example.indra.dto.ResponseDTO;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.sql.SQLException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class, FileNotFoundException.class})
    public ResponseDTO notFoundRequest(HttpServletRequest request, Exception exception) {
        return new ResponseDTO(HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    @ExceptionHandler({FileUploadException.class})
    public ResponseDTO fileStorageRequest(HttpServletRequest request, Exception exception) {
        return new ResponseDTO(HttpStatus.INSUFFICIENT_STORAGE.value(), exception.getMessage(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({org.springframework.dao.DuplicateKeyException.class,
            org.springframework.dao.DataAccessException.class, SQLException.class,
            org.springframework.dao.EmptyResultDataAccessException.class,
            MethodArgumentNotValidException.class,
            org.springframework.web.bind.MissingRequestHeaderException.class,
            org.springframework.web.bind.MissingServletRequestParameterException.class,
            org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class, MethodArgumentNotValidException.class,
            javax.validation.ConstraintViolationException.class, InvalidDataAccessApiUsageException.class,
            NullPointerException.class, BadRequestException.class
    })
    public ResponseDTO badRequest(HttpServletRequest request, Exception exception) {
        return new ResponseDTO(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class, ServletException.class})
    public ResponseDTO fatalErrorUnexpectedException(HttpServletRequest request, Exception exception) {
        return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), request.getRequestURI());
    }


    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({org.springframework.web.HttpRequestMethodNotSupportedException.class})
    public ResponseDTO methodNotAllowed(HttpServletRequest request, Exception exception) {
        return new ResponseDTO(HttpStatus.METHOD_NOT_ALLOWED.value(), exception.getMessage(), request.getRequestURI());
    }

}
