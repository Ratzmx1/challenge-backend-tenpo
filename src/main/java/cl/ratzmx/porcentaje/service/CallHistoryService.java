package cl.ratzmx.porcentaje.service;

import cl.ratzmx.porcentaje.domain.entities.CallHistory;
import cl.ratzmx.porcentaje.repository.CallHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CallHistoryService {

  private CallHistoryRepository callHistoryRepository;

  @Async
  public void saveRequest(String requestURI, String requestContent, Integer status, String responseBody){
    var callHistory = new CallHistory();

    callHistory.setEndpoint(requestURI);
    callHistory.setParameters(requestContent);
    callHistory.setResponse(responseBody);
    callHistory.setStatusCode(status);

    callHistoryRepository.save(callHistory);
  }

}
