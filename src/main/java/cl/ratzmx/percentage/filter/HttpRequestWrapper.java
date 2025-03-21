package cl.ratzmx.percentage.filter;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpRequestWrapper extends HttpServletRequestWrapper {

  private final byte[] body;

  public HttpRequestWrapper(HttpServletRequest request) throws IOException {
    super(request);
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      request.getInputStream().transferTo(byteArrayOutputStream);
      this.body = byteArrayOutputStream.toByteArray();
    }
  }

  @Override
  public ServletInputStream getInputStream() {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
    return new ServletInputStream() {
      @Override
      public boolean isFinished() {
        return byteArrayInputStream.available() == 0;
      }
      @Override
      public boolean isReady() {
        return true;
      }
      @Override
      public void setReadListener(ReadListener readListener) {}
      @Override
      public int read() throws IOException {
        return byteArrayInputStream.read();
      }
    };
  }

  public String getBody() {
    return new String(body, StandardCharsets.UTF_8);
  }
}
