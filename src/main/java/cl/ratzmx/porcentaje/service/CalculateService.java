package cl.ratzmx.porcentaje.service;

import cl.ratzmx.porcentaje.domain.dto.CalculatePercentageDto;
import cl.ratzmx.porcentaje.domain.dto.CalculatePercentageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculateService {

  private PercentageService percentageService;

  public CalculatePercentageResponse calculatePercentage(Double num1, Double num2) {
    var sum = num1 + num2;
    var percentage = percentageService.getPercentage();

    var res = new CalculatePercentageResponse();
    res.setResult(sum + sum * percentage.getPercentage() / 100);
    return res;
  }

}
