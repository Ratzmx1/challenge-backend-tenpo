package cl.ratzmx.percentage.filter;

import cl.ratzmx.percentage.service.CallHistoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
@AllArgsConstructor
public class LogRequestFilter implements Filter {

  private CallHistoryService callHistoryService;

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if (servletRequest instanceof HttpServletRequest request && servletResponse instanceof HttpServletResponse response) {
      HttpRequestWrapper requestWrapper = new HttpRequestWrapper(request);
      HttpResponseWrapper responseWrapper = new HttpResponseWrapper(response);

      var requestContent = getContent(requestWrapper);

      try {
        filterChain.doFilter(requestWrapper, responseWrapper);

      } finally {
        saveHistory(request, responseWrapper, requestContent);

      }

    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }


  private String getContent(HttpRequestWrapper request) {
    String params = request.getQueryString() != null ? request.getQueryString() : "";
    return "GET".equalsIgnoreCase(request.getMethod()) ? params : request.getBody();
  }

  private void saveHistory(HttpServletRequest request, HttpResponseWrapper response, String requestContent) {
    callHistoryService.saveRequest(request.getRequestURI(), requestContent, response.getStatus(), response.getBody());
  }
}
