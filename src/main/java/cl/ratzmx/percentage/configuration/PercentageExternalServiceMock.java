package cl.ratzmx.percentage.configuration;

import org.mockserver.integration.ClientAndServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;


@Configuration
public class PercentageExternalServiceMock {

  @Bean
  public ClientAndServer mockServer() {
    ClientAndServer mockServer = ClientAndServer.startClientAndServer(8081);
    mockServer.when(
            request()
                    .withMethod("GET")
                    .withPath("/percentage")
    ).respond(
            httpRequest -> {
              if (Math.random() < 0.2) {
                return response()
                        .withStatusCode(503)
                        .withBody("Service Unavailable");
              } else {
                return response()
                        .withStatusCode(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"percentage\": 10.0}");
              }
            }
    );
    return mockServer;
  }
}
