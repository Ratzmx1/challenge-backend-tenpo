package cl.ratzmx.porcentaje.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "callHistory")
@Data
public class CallHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  @Column(name = "timestamp", nullable = false, updatable = false)
  private LocalDateTime timestamp;

  @Column(name = "endpoint")
  private String endpoint;

  @Column(name = "request")
  private String parameters;

  @Column(name = "response")
  private String response;

  @Column(name = "statusCode")
  private Integer statusCode;

}
