package cl.ratzmx.percentage.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CalculatePercentageResponse {
  @Schema(description = "Resultado del calculo solicitado", example = "1.5")
  private Double result;
}
