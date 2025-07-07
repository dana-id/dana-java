package id.dana.invoker.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

public final class RequestUtil {

  private RequestUtil() {

  }

  public static String peekRequestBody(Request request) {
    RequestBody requestBody = request.body();

    try {
      if (requestBody == null || requestBody.contentLength() == 0) {
        return "{}";
      } else {
        return new TempRequestBody(requestBody).peekBody();
      }
    } catch (IOException e) {
      return "{}";
    }
  }

  private static class TempRequestBody extends RequestBody {

    private final RequestBody requestBody;

    private final ByteArrayOutputStream copyStream = new ByteArrayOutputStream();

    TempRequestBody(RequestBody requestBody) {
      this.requestBody = requestBody;
    }

    @Override
    public MediaType contentType() {
      return requestBody.contentType();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
      Buffer buffer = new Buffer();
      requestBody.writeTo(buffer);
      buffer.copyTo(copyStream);
      buffer.writeTo(sink.outputStream());
    }

    public String peekBody() throws IOException {
      Buffer dummySink = new Buffer();
      writeTo(dummySink);
      return new String(copyStream.toByteArray(), StandardCharsets.UTF_8);
    }

  }

}
