package com.flarecafe.common.exception;

import com.flarecafe.common.response.ErrorResponse;
import com.flarecafe.common.response.code.error.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {
  
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  protected ErrorResponse handleException(Exception e) {
    return ErrorResponse.of(ErrorCodes.Default.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  protected ErrorResponse handlerNotFoundException(NoHandlerFoundException e) {
    return ErrorResponse.of(ErrorCodes.Default.NOT_FOUND);
  }

  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  protected ErrorResponse handleBusinessException(final BusinessException e) {
    return ErrorResponse.of(e.getErrorCode());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  protected ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
    return ErrorResponse.of(ErrorCodes.Default.NOT_FOUND, e.getBindingResult());
  }
  
}