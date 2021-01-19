package codemeans.shopify4j.core.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Generic Http Response
 *
 * @author: yuanwq
 * @date: 2021-01-19
 */
@Data
@Accessors(fluent = true)
public class HttpResponse<T> {

  /**
   * raw string body
   */
  private final String body;
  /**
   * deserialized object from body
   */
  private final T object;
  private final Map<String, List<String>> headers = new LinkedHashMap<>();

  public HttpResponse(String body, T object) {
    this.body = body;
    this.object = object;
  }

  public HttpResponse<T> addAllHeaders(Map<String, List<String>> headers) {
    for (Entry<String, List<String>> entry : headers.entrySet()) {
      this.headers.computeIfAbsent(entry.getKey().toLowerCase(), s -> new ArrayList<>())
          .addAll(entry.getValue());
    }
    return this;
  }

  /**
   * last value for specific header
   *
   * @param header case-ignore
   */
  public String getHeader(String header) {
    List<String> values = getHeaders(header);
    return values.isEmpty() ? null : values.get(values.size() - 1);
  }

  /**
   * all values for specific header
   *
   * @param header case-ignore
   * @return empty list if no header exists
   */
  public List<String> getHeaders(String header) {
    return headers.getOrDefault(header.toLowerCase(), Collections.emptyList());
  }
}
