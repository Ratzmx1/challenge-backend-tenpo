package cl.ratzmx.percentage.service;

import cl.ratzmx.percentage.domain.dto.CalculatePercentageResponse;
import cl.ratzmx.percentage.exception.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculateService {

  private PercentageService percentageService;

  public CalculatePercentageResponse calculatePercentage(Double num1, Double num2) {
    var sum = num1 + num2;
    var percentage = percentageService.getPercentage();
    if(percentage == null){
      throw new CustomException("Unable to retrieve percentage response and don't have stored cache", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    var res = new CalculatePercentageResponse();
    res.setResult(sum + (sum * percentage.getPercentage() / 100));
    return res;
  }

}
