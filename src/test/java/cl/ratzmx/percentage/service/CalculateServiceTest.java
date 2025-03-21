package cl.ratzmx.percentage.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import cl.ratzmx.percentage.domain.dto.CalculatePercentageResponse;
import cl.ratzmx.percentage.domain.dto.PercentageResponse;
import cl.ratzmx.percentage.exception.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

  @Mock
  private PercentageService percentageService;

  @InjectMocks
  private CalculateService calculateService;

  @Test
  void testCalculatePercentage_Success() {
    Double num1 = 100.0;
    Double num2 = 50.0;
    PercentageResponse percentageResponse = new PercentageResponse();
    percentageResponse.setPercentage(20d);
    when(percentageService.getPercentage()).thenReturn(percentageResponse);

    CalculatePercentageResponse result = calculateService.calculatePercentage(num1, num2);

    assertNotNull(result);
    assertEquals(180.0, result.getResult());
    verify(percentageService, times(1)).getPercentage();
  }

  @Test
  void testCalculatePercentage_WithoutPercentage() {
    Double num1 = 100.0;
    Double num2 = 50.0;
    when(percentageService.getPercentage()).thenReturn(null);

    CustomException thrown = assertThrows(CustomException.class, () -> {
      calculateService.calculatePercentage(num1, num2);
    });

    assertEquals("Unable to retrieve percentage response and don't have stored cache", thrown.getMessage());
    assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, thrown.getStatus());
    verify(percentageService, times(1)).getPercentage();
  }
}
