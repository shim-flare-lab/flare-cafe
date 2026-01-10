package com.flarecafe.feature.promotion.application;

import com.flarecafe.common.auth.model.AuthUser;
import com.flarecafe.common.response.SuccessResponse;
import com.flarecafe.common.response.code.success.SuccessCode;
import com.flarecafe.feature.generic.IdResponse;
import com.flarecafe.feature.promotion.application.factory.PromotionFactory;
import com.flarecafe.feature.promotion.domain.model.Promotion;
import com.flarecafe.feature.promotion.domain.repository.PromotionRepository;
import com.flarecafe.feature.promotion.presentation.dto.CreatePromotion;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionCrudService {

  private final PromotionFactory promotionFactory;
  private final PromotionRepository promotionRepository;

  @Transactional
  public SuccessResponse<IdResponse> create(@Valid CreatePromotion request, AuthUser user) {

    Promotion entity = promotionFactory.createAndValidate(request, user);
    Promotion promotion = promotionRepository.save(entity);

    return SuccessResponse.of(SuccessCode.OK, IdResponse.of(promotion.getId()));
  }
  
}
