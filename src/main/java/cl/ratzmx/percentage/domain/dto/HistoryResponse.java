package cl.ratzmx.percentage.domain.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class HistoryResponse {

  private String endpoint;
  private String parameters;
  private String response;
  private Integer statusCode;
  private String timestamp;
}
