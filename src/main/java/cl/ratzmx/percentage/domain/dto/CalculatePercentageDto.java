package cl.ratzmx.percentage.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalculatePercentageDto {

  @NotNull
  @Schema(description = "Primer numero a calcular", example = "1.0")
  private Double num1;

  @NotNull
  @Schema(description = "Segundo numero a calcular", example = "35.3")
  private Double num2;

}
