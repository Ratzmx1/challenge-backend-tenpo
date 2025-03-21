package cl.ratzmx.percentage.controller;

import cl.ratzmx.percentage.domain.dto.CalculatePercentageDto;
import cl.ratzmx.percentage.domain.dto.CalculatePercentageResponse;
import cl.ratzmx.percentage.service.CalculateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class CalculateController {

  private CalculateService calculateService;

  @PostMapping(value = "/calculate")
  public CalculatePercentageResponse calculatePercentage(@Valid @RequestBody CalculatePercentageDto request) {

    return calculateService.calculatePercentage(request.getNum1(), request.getNum2());
  }

}
