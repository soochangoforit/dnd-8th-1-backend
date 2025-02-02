package dnd.danverse.global.util;

import static dnd.danverse.domain.jwt.service.JwtTokenProvider.REFRESH_TOKEN_EXPIRE_LENGTH_MS;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;


/**
 * Cookie 관련 유틸리티 클래스.
 */
public class CookieUtil {

  private CookieUtil() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Header 에 Refresh Token Cookie 를 추가한다.
   * @param refreshToken 서버에서 생성한 Refresh Token
   * @return Cookie 가 담긴 Header
   */
  public static HttpHeaders setRefreshCookie(String refreshToken) {

    HttpHeaders headers = new HttpHeaders();

    ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
        .httpOnly(true)
        .maxAge(REFRESH_TOKEN_EXPIRE_LENGTH_MS)
        .path("/")
        .build();

    headers.add(HttpHeaders.SET_COOKIE, cookie.toString());

    return headers;
  }
}
