package cl.ratzmx.percentage.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculatePercentageDto {

  @NotNull
  private Double num1;

  @NotNull
  private Double num2;

}
