package kt.com.membership.dto;

import kt.com.membership.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONObject;

@Getter
@Setter
public class JsonResponse {

    private int status;

    private JSONObject data;

    public JsonResponse(API_STATUS status) {
        this.status = status.getStatus();
    }

    public static JsonResponse UserInfo(API_STATUS status, User user){
        JsonResponse jsonResponse = new JsonResponse(status);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        jsonResponse.data = jsonObject;
        return jsonResponse;
    }

    public static JsonResponse UserInfoWithToken(API_STATUS status, User user, String token) {
        JsonResponse jsonResponse = new JsonResponse(status);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        jsonObject.put("token",token);
        jsonResponse.data = jsonObject;
        return jsonResponse;
    }
}
