package cl.ratzmx.percentage.service;

import cl.ratzmx.percentage.domain.dto.HistoryResponse;
import cl.ratzmx.percentage.domain.entities.CallHistory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HistoryService {
  private CallHistoryService callHistoryService;

  public Page<HistoryResponse> getHistory(int page, int size, LocalDate startDate, LocalDate endDate) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
    Page<CallHistory> history = callHistoryService.findWithFilters( startDate, endDate, pageable);

    return history.map(this::convertirADTO);
  }

  private HistoryResponse convertirADTO(CallHistory entidad) {
    HistoryResponse dto = new HistoryResponse();
    dto.setResponse(entidad.getResponse());
    dto.setEndpoint(entidad.getEndpoint());
    dto.setStatusCode(entidad.getStatusCode());
    dto.setParameters(entidad.getParameters());

    var date = Date.from(entidad.getTimestamp().atZone(ZoneId.systemDefault()).toInstant());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    dto.setTimestamp(sdf.format(date));
    return dto;
  }
}
