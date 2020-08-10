package kt.com.membership.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ItemForm {

    @NotNull(message = "사용횟수는 필수 입니다.")
    private int monthCount;

    @NotEmpty(message = "이름은 필수 입니다.")
    private String name;

    @NotEmpty(message = "분류는 필수 입니다.")
    private String category;

    private String vvip_contents;
    private String vip_contents;
    private String normal_contents;

    @NotEmpty(message = "point는 필수 입니다.")
    private int vvip_point;

    @NotEmpty(message = "point는 필수 입니다.")
    private int vip_point;

    @NotEmpty(message = "point는 필수 입니다.")
    private int normal_point;

    @NotEmpty(message = "img_path는 필수 입니다.")
    private String img_path;




}
