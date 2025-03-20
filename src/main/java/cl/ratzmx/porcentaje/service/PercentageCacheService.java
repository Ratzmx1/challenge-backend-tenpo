package cl.ratzmx.porcentaje.service;

import cl.ratzmx.porcentaje.constants.Constants;
import cl.ratzmx.porcentaje.domain.dto.PercentageResponse;
import com.nimbusds.jose.shaded.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PercentageCacheService {

  private CacheManager cacheManager;

  public void saveCache(PercentageResponse data) {
    var cache = cacheManager.getCache(Constants.CACHE_NAME);

    log.info("Save cache");
    if (cache != null) {
      log.info("Cache is not null");
      cache.put(Constants.PERCENTAGE_CACHE_KEY, data);
    }
  }

  public PercentageResponse getCache() {
    var cache = cacheManager.getCache(Constants.CACHE_NAME);
    if (cache != null) {
      log.info("Get cache");
      if(cache.get(Constants.PERCENTAGE_CACHE_KEY) != null) {
        return cache.get(Constants.PERCENTAGE_CACHE_KEY, PercentageResponse.class);

      }
    }
    return null;
  }
}
