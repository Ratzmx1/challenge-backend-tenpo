package cl.ratzmx.porcentaje.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculatePercentageDto {

  @NotNull
  private Double num1;

  @NotNull
  private Double num2;

}
