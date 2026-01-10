package com.flarecafe.feature.promotion.application.factory;

import com.flarecafe.common.auth.model.AuthUser;
import com.flarecafe.feature.generic.Money;
import com.flarecafe.feature.generic.TimeInterval;
import com.flarecafe.feature.promotion.presentation.dto.CreatePromotion;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.model.PromotionStatus;
import com.flarecafe.feature.promotion.domain.validator.CreatePromotionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PromotionFactory {
  
  private final CreatePromotionValidator createPromotionValidator;

  public Promotion createAndValidate(CreatePromotion request, AuthUser user) {
    
    Promotion promotion = Promotion.builder()
      .name(request.name())
      .discountType(request.discountType())
      .description(request.description())
      .discountAmount(Money.of(request.discountAmount()))
      .discountPercentage(request.discountPercentage())
      .period(TimeInterval.of(request.startAt(), request.endAt()))
      .promotionStatus(PromotionStatus.TEMP_SAVE)
      .createdUserId(user.userLoginId())
      .build();
    
    createPromotionValidator.validate(promotion);
    
    return promotion;
  }
  
}
