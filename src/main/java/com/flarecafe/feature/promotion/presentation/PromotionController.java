package com.flarecafe.feature.promotion.presentation;

import com.flarecafe.common.auth.model.AuthUser;
import com.flarecafe.common.auth.model.BindAuthUser;
import com.flarecafe.common.response.SuccessResponse;
import com.flarecafe.feature.generic.IdResponse;
import com.flarecafe.feature.promotion.application.PromotionCrudService;
import com.flarecafe.feature.promotion.presentation.dto.CreatePromotion;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PromotionController {
  
  public final PromotionCrudService promotionCrudService;
  
  @PostMapping("/promotions")
  public SuccessResponse<IdResponse> create(@RequestBody @Valid CreatePromotion request, @BindAuthUser AuthUser user) {
    return promotionCrudService.create(request, user);
  }
  
}
