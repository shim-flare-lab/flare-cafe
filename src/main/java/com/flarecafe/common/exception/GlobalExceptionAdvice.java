package com.flarecafe.common.exception;
import com.flarecafe.common.response.ErrorResponse;
import com.flarecafe.common.response.code.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

  /**
   * Handles BusinessExceptions
   */
  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  protected ErrorResponse handleBusinessException(final BusinessException e) {
    final ErrorCode errorCode = e.getErrorCode();

    return ErrorResponse.of(errorCode);
  }

  /**
   * Handle MethodArgumentNotValidException
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  protected ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
    final ErrorCode errorCode = ErrorCode.INVALID_INPUT_VALUE;

    return ErrorResponse.of(errorCode, e.getBindingResult());
  }
}