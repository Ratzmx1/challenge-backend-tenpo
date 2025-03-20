package cl.ratzmx.porcentaje.controller;

import cl.ratzmx.porcentaje.domain.dto.CalculatePercentageDto;
import cl.ratzmx.porcentaje.domain.dto.CalculatePercentageResponse;
import cl.ratzmx.porcentaje.service.CalculateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculateController {

  private CalculateService calculateService;

  @PostMapping(value = "/calculate")
  public CalculatePercentageResponse calculatePercentage(@RequestBody CalculatePercentageDto request) {

    return calculateService.calculatePercentage(request.getNum1(), request.getNum2());
  }

}
