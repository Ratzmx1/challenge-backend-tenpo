package cl.ratzmx.percentage.service;

import cl.ratzmx.percentage.domain.entities.CallHistory;
import cl.ratzmx.percentage.repository.CallHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CallHistoryService {

  private CallHistoryRepository callHistoryRepository;

  @Async
  public void saveRequest(String requestURI, String requestContent, Integer status, String responseBody) {
    var callHistory = new CallHistory();

    callHistory.setEndpoint(requestURI);
    callHistory.setParameters(requestContent);
    callHistory.setResponse(responseBody);
    callHistory.setStatusCode(status);

    callHistoryRepository.save(callHistory);
  }

  public List<CallHistory> getHistory() {
    return callHistoryRepository.findAll();
  }

  public Page<CallHistory> findWithFilters(LocalDate startDate, LocalDate endDate, Pageable pageable) {
    return callHistoryRepository.findWithFilters(startDate, endDate, pageable);

  }
}
