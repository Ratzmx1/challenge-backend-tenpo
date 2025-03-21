package cl.ratzmx.percentage.service;

import cl.ratzmx.percentage.client.PercentageClient;
import cl.ratzmx.percentage.domain.dto.PercentageResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PercentageServiceTest {

  @Mock
  private PercentageClient percentageClient;

  @Mock
  private PercentageCacheService percentageCacheService;

  @Mock
  private Logger logger;

  @InjectMocks
  private PercentageService percentageService;


  @Test
  void testGetPercentage_FromClient() {
    PercentageResponse expectedResponse = new PercentageResponse();
    when(percentageClient.getPercentage()).thenReturn(expectedResponse);

    PercentageResponse result = percentageService.getPercentage();

    assertNotNull(result);
    assertEquals(expectedResponse, result);
    verify(percentageClient, times(1)).getPercentage();
    verify(percentageCacheService, times(1)).saveCache(expectedResponse);
  }

  @Test
  void testGetPercentage_FromCache_WhenExceptionOccurs() {
    when(percentageClient.getPercentage()).thenThrow(new RuntimeException("Client error"));
    PercentageResponse cachedResponse = new PercentageResponse();
    when(percentageCacheService.getCache()).thenReturn(cachedResponse);

    PercentageResponse result = percentageService.getPercentage();

    assertNotNull(result);
    assertEquals(cachedResponse, result);
    verify(percentageClient, times(1)).getPercentage();
    verify(percentageCacheService, times(1)).getCache();
  }

  @Test
  void testGetPercentage_CacheIsNull_WhenExceptionOccurs() {
    when(percentageClient.getPercentage()).thenThrow(new RuntimeException("Client error"));
    when(percentageCacheService.getCache()).thenReturn(null);

    PercentageResponse result = percentageService.getPercentage();

    assertNull(result);
    verify(percentageClient, times(1)).getPercentage();
    verify(percentageCacheService, times(1)).getCache();
  }
}
