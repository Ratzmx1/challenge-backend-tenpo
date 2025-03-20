package cl.ratzmx.porcentaje.service;

import cl.ratzmx.porcentaje.domain.dto.PercentageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "percentageClient", url = "${percentage.baseUrl}")
public interface PercentageService {
  @GetMapping(value = "/percentage")
  PercentageResponse getPercentage();
}
