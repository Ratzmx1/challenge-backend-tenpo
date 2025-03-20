package cl.ratzmx.porcentaje.client;

import cl.ratzmx.porcentaje.domain.dto.PercentageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "percentageClient", url = "${percentage.baseUrl}")
public interface PercentageClient {
  @GetMapping(value = "/percentage")
  PercentageResponse getPercentage();
}
