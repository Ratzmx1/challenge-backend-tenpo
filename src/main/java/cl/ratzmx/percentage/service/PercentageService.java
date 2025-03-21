package cl.ratzmx.percentage.service;

import cl.ratzmx.percentage.client.PercentageClient;
import cl.ratzmx.percentage.domain.dto.PercentageResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PercentageService {

  private PercentageClient percentageClient;

  private PercentageCacheService percentageCacheService;

  public PercentageResponse getPercentage(){
    try {
      var percentageResponse = percentageClient.getPercentage();
      percentageCacheService.saveCache(percentageResponse);

      return percentageResponse;
    } catch (Exception e) {
      log.info("Using cache value");
      return percentageCacheService.getCache();
    }
  }
}
