package cl.ratzmx.percentage.filter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpResponseWrapper extends HttpServletResponseWrapper {

  private final ByteArrayOutputStream capture;
  private ServletOutputStream outputStream;

  public HttpResponseWrapper(HttpServletResponse response) throws IOException {
    super(response);
    this.capture = new ByteArrayOutputStream();
  }

  @Override
  public ServletOutputStream getOutputStream() {
    if (outputStream == null) {
      outputStream = new ServletOutputStream() {
        @Override
        public boolean isReady() {
          return true;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {

        }

        @Override
        public void write(int b) throws IOException {
          capture.write(b);
          HttpResponseWrapper.super.getOutputStream().write(b);
        }
      };
    }
    return outputStream;
  }

  public String getBody() {
    return new String(capture.toByteArray(), StandardCharsets.UTF_8);
  }
}
