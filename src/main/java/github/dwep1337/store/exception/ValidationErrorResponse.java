package github.dwep1337.store.exception;

import java.util.Map;

public record ValidationErrorResponse(
    String message,
    Map<String, String> errors) {
}
