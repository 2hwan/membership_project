package kt.com.membership.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginForm {

    @NotEmpty(message = "ID는 필수 입니다.")
    @Size(max = 20, message = "ID는 20자리를 초과할 수 없습니다.")
    private String userId;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Size(max = 100, message = "비밀번호가 너무 깁니다.")
    private String password;
}
