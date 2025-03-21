package cl.ratzmx.percentage.client;

import cl.ratzmx.percentage.domain.dto.PercentageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "percentageClient", url = "${percentage.baseUrl}")
public interface PercentageClient {
  @GetMapping(value = "/percentage")
  PercentageResponse getPercentage();
}
