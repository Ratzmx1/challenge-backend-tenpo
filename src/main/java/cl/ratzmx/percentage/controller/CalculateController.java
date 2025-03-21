package cl.ratzmx.percentage.controller;

import cl.ratzmx.percentage.domain.dto.CalculatePercentageDto;
import cl.ratzmx.percentage.domain.dto.CalculatePercentageResponse;
import cl.ratzmx.percentage.service.CalculateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.http.entity.ContentType;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Calculate")
@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
@Validated
public class CalculateController {

  private CalculateService calculateService;

  @Operation(summary = "Suma 2 números y le agrega un porcentaje obtenido desde una api externa")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Calculo correcto"),
          @ApiResponse(responseCode = "400", description = "Request no valido")
    })
  @PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public CalculatePercentageResponse calculatePercentage(@Valid @RequestBody CalculatePercentageDto request) {

    return calculateService.calculatePercentage(request.getNum1(), request.getNum2());
  }

}
