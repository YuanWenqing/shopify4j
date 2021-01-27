package codemeans.shopify4j.app.oauth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanwq
 * @date: 2021-01-26
 */
@Data
@Accessors(chain = true)
public class OauthAccessToken {

  private String accessToken;
  @JsonIgnore
  @NonNull
  private Set<String> scopeSet = Collections.emptySet();


  /**
   * seconds
   */
  private Long expiresIn;
  private String session;
  @JsonIgnore
  @NonNull
  private Set<String> associatedUserScopeSet = Collections.emptySet();
  private AssociatedUser associatedUser;

  @JsonIgnore
  public String getScopeAsString() {
    return joinScopes(scopeSet);
  }

  @JsonProperty("scope")
  public void setScope(String scopes) {
    this.scopeSet = splitScopes(scopes);
  }

  @JsonIgnore
  public String getAssociatedUserScopeAsString() {
    return joinScopes(associatedUserScopeSet);
  }

  @JsonProperty("associated_user_scope")
  public void setAssociatedUserScope(String scopes) {
    this.associatedUserScopeSet = splitScopes(scopes);
  }

  private static String joinScopes(Collection<String> scopes) {
    return StringUtils.join(scopes, ",");
  }

  private static LinkedHashSet<String> splitScopes(String scopes) {
    scopes = StringUtils.defaultString(scopes);
    return new LinkedHashSet<>(Arrays.stream(scopes.split(","))
        .filter(StringUtils::isNotBlank)
        .map(String::trim)
        .collect(Collectors.toList()));
  }

  @Data
  @Accessors(chain = true)
  public static class AssociatedUser {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean emailVerified;
    private boolean accountOwner;
    private String locale;
    private boolean collaborator;
  }
}
