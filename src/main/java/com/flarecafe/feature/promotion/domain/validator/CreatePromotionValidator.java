package com.flarecafe.feature.promotion.domain.validator;

import com.flarecafe.common.exception.BusinessException;
import com.flarecafe.common.response.code.error.ErrorCodes.Business;
import com.flarecafe.feature.promotion.domain.PromotionValidator;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.support.DiscountType;
import org.springframework.stereotype.Component;

@Component
public class CreatePromotionValidator implements PromotionValidator {
  
  @Override
  public void validate(Promotion promotion) {

    DiscountType discountType = promotion.getDiscountType();
    
    if (discountType == DiscountType.PERCENTAGE) {
      this.percentageValidation(promotion);
    }
    
    if (discountType == DiscountType.AMOUNT) {
      this.amountValidation(promotion);
    }

  }

  private void percentageValidation(Promotion promotion) {
    
    if (promotion.getDiscountPercentage() == null) {
      throw new BusinessException(Business.Promotion.DISCOUNT_PERCENTAGE_REQUIRED);
    }
    
    if (promotion.getDiscountPercentage() < 0) {
      throw new BusinessException(Business.Promotion.DISCOUNT_PERCENTAGE_NEGATIVE);
    }
    
  }

  private void amountValidation(Promotion promotion) {

    if (promotion.getDiscountAmount().getAmount() == null) {
      throw new BusinessException(Business.Promotion.DISCOUNT_AMOUNT_REQUIRED);
    }
    
    if (promotion.getDiscountAmount().getAmount().signum() < 0) {
      throw new BusinessException(Business.Promotion.DISCOUNT_AMOUNT_NEGATIVE);
    }
    
  }
  
}
