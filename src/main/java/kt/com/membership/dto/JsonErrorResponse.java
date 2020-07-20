package kt.com.membership.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonErrorResponse {
    private int status;
    private String message;

    public JsonErrorResponse(API_STATUS status, String message) {
        this.status = status.getStatus();
        this.message = message;
    }
}
