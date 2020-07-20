package kt.com.membership.dto;

import lombok.Getter;

@Getter
public enum API_STATUS {
    SUCCESS(200, "success"),
    BAD_REQUEST(400, "bad request"),
    UNAUTHORIZED(401, "unauthorized"),
    NOT_FOUND(404,"not found");

    private final String message;
    private int status;

    API_STATUS(final int status, final String message) {
        this.status = status;
        this.message = message;
    }
}
