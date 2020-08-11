package kt.com.membership.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserForm {

    @NotEmpty(message = "ID는 필수 입니다.")
    @Size(max = 20, message = "ID는 20자리를 초과할 수 없습니다.")
    private String userId;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Size(max = 100, message = "비밀번호는 100자리를 초과할 수 없습니다.")
    private String password;

    @NotEmpty(message = "이름은 필수 입니다.")
    @Size(max = 20, message = "이름은 20자리를 초과할 수 없습니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입니다.")
    @Size(max = 100, message = "이메일은 100자리를 초과할 수 없습니다.")
    private String email;

    @NotEmpty(message = "핸드폰 번호는 필수 입니다.")
    @Size(max = 100, message = "핸드폰 번호는 100자리를 초과할 수 없습니다.")
    private String phoneNumber;

    @NotEmpty(message = "요금제는 필수 입니다.")
    private String callProd;

}
