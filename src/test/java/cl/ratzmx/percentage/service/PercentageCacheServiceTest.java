package cl.ratzmx.percentage.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import cl.ratzmx.percentage.constants.Constants;
import cl.ratzmx.percentage.domain.dto.PercentageResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

@ExtendWith(MockitoExtension.class)
class PercentageCacheServiceTest {

  @Mock
  private CacheManager cacheManager;

  @Mock
  private Cache cache;

  @InjectMocks
  private PercentageCacheService percentageCacheService;


  @Test
  void testSaveCache_CacheNotNull() {
    PercentageResponse data = new PercentageResponse();
    when(cacheManager.getCache(Constants.CACHE_NAME)).thenReturn(cache);

    percentageCacheService.saveCache(data);

    verify(cacheManager, times(1)).getCache(Constants.CACHE_NAME);
    verify(cache, times(1)).put(Constants.PERCENTAGE_CACHE_KEY, data);
  }

  @Test
  void testSaveCache_CacheIsNull() {
    PercentageResponse data = new PercentageResponse();
    when(cacheManager.getCache(Constants.CACHE_NAME)).thenReturn(null);

    percentageCacheService.saveCache(data);

    verify(cacheManager, times(1)).getCache(Constants.CACHE_NAME);
    verifyNoInteractions(cache);
  }

  @Test
  void testGetCache_CacheNotNullAndValuePresent() {
    PercentageResponse expectedData = new PercentageResponse();
    when(cacheManager.getCache(Constants.CACHE_NAME)).thenReturn(cache);
    when(cache.get(Constants.PERCENTAGE_CACHE_KEY)).thenReturn(Object::new);
    when(cache.get(Constants.PERCENTAGE_CACHE_KEY, PercentageResponse.class)).thenReturn(expectedData);


    PercentageResponse result = percentageCacheService.getCache();

    assertNotNull(result);
    assertEquals(expectedData, result);
    verify(cacheManager, times(1)).getCache(Constants.CACHE_NAME);
    verify(cache, times(1)).get(Constants.PERCENTAGE_CACHE_KEY, PercentageResponse.class);
  }

  @Test
  void testGetCache_CacheNotNullButValueAbsent() {
    when(cacheManager.getCache(Constants.CACHE_NAME)).thenReturn(cache);
    when(cache.get(Constants.PERCENTAGE_CACHE_KEY)).thenReturn(Object::new);
    when(cache.get(Constants.PERCENTAGE_CACHE_KEY, PercentageResponse.class)).thenReturn(null);

    PercentageResponse result = percentageCacheService.getCache();

    assertNull(result);
    verify(cacheManager, times(1)).getCache(Constants.CACHE_NAME);
    verify(cache, times(1)).get(Constants.PERCENTAGE_CACHE_KEY, PercentageResponse.class);
  }

  @Test
  void testGetCache_CacheIsNull() {
    when(cacheManager.getCache(Constants.CACHE_NAME)).thenReturn(null);

    PercentageResponse result = percentageCacheService.getCache();

    assertNull(result);
    verify(cacheManager, times(1)).getCache(Constants.CACHE_NAME);
  }
}
