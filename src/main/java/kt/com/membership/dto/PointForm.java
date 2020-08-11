package kt.com.membership.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PointForm {

    @NotEmpty(message = "유저 ID는 필수입니다.")
    @Size(max = 20)
    private String userId;

    @NotNull(message = "포인트는 필수입니다.")
    private int usingPoint;

    @NotNull(message = "아이템 id는 필수입니다.")
    private Long itemId;

}
