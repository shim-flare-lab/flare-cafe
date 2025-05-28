package com.flarecafe.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flarecafe.common.response.ErrorResponse;
import com.flarecafe.common.response.code.error.ErrorCodes;
import org.junit.jupiter.api.Test;

class GlobalExceptionAdviceTest {

  @Test
  void print() throws Exception {
    
    ObjectMapper objectMapper = new ObjectMapper();
    BusinessException menuBusinessException = new BusinessException(ErrorCodes.Business.Menu.INVALID_MENU_NAME);
    BusinessException promotionBusinessException = new BusinessException(ErrorCodes.Business.Promotion.DISCOUNT_PERCENTAGE_NEGATIVE);
    
    System.out.println(objectMapper.writeValueAsString(ErrorResponse.of(menuBusinessException.getErrorCode())));
    System.out.println(objectMapper.writeValueAsString(ErrorResponse.of(ErrorCodes.Business.Menu.INVALID_INPUT_VALUE)));
    System.out.println(objectMapper.writeValueAsString(ErrorResponse.of(ErrorCodes.Business.Menu.INVALID_MENU_NAME)));
    
    System.out.println(objectMapper.writeValueAsString(ErrorResponse.of(promotionBusinessException.getErrorCode())));
    System.out.println(objectMapper.writeValueAsString(ErrorResponse.of(ErrorCodes.Default.INTERNAL_SERVER_ERROR)));
    System.out.println(objectMapper.writeValueAsString(ErrorResponse.of(ErrorCodes.Default.NOT_FOUND)));

  }
  
}