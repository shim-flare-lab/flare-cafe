package com.flarecafe.common.response;

import com.flarecafe.common.response.code.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

  private String code;
  private String message;
  private List<FieldErrorDetail> errorDetails;

  private ErrorResponse(final ErrorCode code) {
    this.message = code.getMessage();
    this.code = code.getCode();
    this.errorDetails = new ArrayList<>();
  }

  private ErrorResponse(final ErrorCode code, final List<FieldErrorDetail> errors) {
    this.message = code.getMessage();
    this.code = code.getCode();
    this.errorDetails = errors;
  }

  public static ErrorResponse of(final ErrorCode code) {
    return new ErrorResponse(code);
  }

  public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
    return new ErrorResponse(code, FieldErrorDetail.from(bindingResult));
  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class FieldErrorDetail {
    private String field;
    private String value;
    private String message;

    private FieldErrorDetail(final String field, final String value, final String message) {
      this.field = field;
      this.value = value;
      this.message = message;
    }

    public static List<FieldErrorDetail> from(final BindingResult bindingResult) {
      final List<FieldError> fieldErrors = bindingResult.getFieldErrors();

      return fieldErrors.stream()
        .map(fieldError -> new FieldErrorDetail(
          fieldError.getField(),
          fieldError.getRejectedValue() == null ? "" : fieldError.getRejectedValue().toString(),
          fieldError.getDefaultMessage()))
        .toList();
    }
  }
}