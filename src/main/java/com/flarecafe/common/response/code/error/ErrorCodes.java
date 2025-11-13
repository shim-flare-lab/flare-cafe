package com.flarecafe.common.response.code.error;

import com.flarecafe.common.response.code.FlareCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public final class ErrorCodes {
  
  @AllArgsConstructor
  public enum Default implements FlareCode {
    
    NOT_FOUND(HttpStatus.NOT_FOUND),
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    ;

    private final HttpStatus httpStatus;

    @Override
    public String getCode() {
      return String.valueOf(this.httpStatus.value());
    }

    @Override
    public String getMessage() {
      return this.httpStatus.getReasonPhrase();
    }
    
  }

  public static class Business {
    
    private static String formatting(String domainName, String code) {
      return String.format("FLARE-CAFE-%s-ERROR-%s", domainName, code);
    }

    @AllArgsConstructor
    public enum Menu implements BusinessErrorCode {

      INVALID_INPUT_VALUE("0001", "Invalid Input Value"),
      INVALID_MENU_NAME("0002", "Invalid menu name"),
      ;

      private static final String NAME = "MENU";
      private final String code;
      
      @Getter
      private final String message;

      public String getCode() {
        return formatting(NAME, code);
      }
      
    }
    
    @AllArgsConstructor
    public enum Promotion implements BusinessErrorCode {

      INVALID_PROMOTION("0001", "Invalid promotion name"),
      ;

      private static final String NAME = "PROMOTION";
      private final String code;
      
      @Getter
      private final String message;

      public String getCode() {
        return formatting(NAME, code);
      }
      
    }

    @AllArgsConstructor
    public enum Ingredient implements BusinessErrorCode {

      INVALID_INGREDIENT_NAME("0001", "Invalid ingredient name"),
      ;

      private static final String INGREDIENT = "INGREDIENT";
      private final String code;

      @Getter
      private final String message;

      public String getCode() {
        return formatting(INGREDIENT, code);
      }

    }
  }
  
  
}
