package kt.com.membership.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ItemForm {

    @NotNull(message = "ID는 필수 입니다.")
    private int price;

    @NotNull(message = "사용횟수는 필수 입니다.")
    private int monthCount;

    @NotEmpty(message = "이름은 입니다.")
    private String name;

    @NotEmpty(message = "분류는 입니다.")
    private String category;

}
