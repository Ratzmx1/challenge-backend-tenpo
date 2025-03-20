package cl.ratzmx.porcentaje.domain.entities;

//import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

//@Entity
@Data
public class CallHistory {

  //@Id
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime timestamp;
  private String endpoint;
  private String parameters;
  private String response;

}
