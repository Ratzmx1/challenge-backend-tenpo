package cl.ratzmx.percentage.controller;

import cl.ratzmx.percentage.domain.dto.HistoryResponse;
import cl.ratzmx.percentage.service.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Tag(name = "History")
@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
@Validated
public class HistoryController {

  private HistoryService historyService;

  @Operation(summary = "Entrega el historial de peticiones realizadas a la api")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Historial encontrado")
  })
  @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<HistoryResponse> getHistory(
          @RequestParam(defaultValue = "0") int page,
          @RequestParam(defaultValue = "10") int size,
          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

    return historyService.getHistory(page, size, startDate, endDate);

  }
}
