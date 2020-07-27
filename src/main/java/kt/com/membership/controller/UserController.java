package kt.com.membership.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kt.com.membership.config.JwtTokenProvider;
import kt.com.membership.domain.User;
import kt.com.membership.dto.API_STATUS;
import kt.com.membership.dto.JsonResponse;
import kt.com.membership.dto.LoginForm;
import kt.com.membership.dto.UserForm;
import kt.com.membership.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"1.User"})
@Controller
@RequiredArgsConstructor
@ResponseBody
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @ApiOperation(value = "회원 가입")
    @PostMapping("/signup")
    public JsonResponse signUpUser(@RequestBody @Valid UserForm userForm) throws Exception {
        userService.signUpUser(userForm);
        return new JsonResponse(API_STATUS.SUCCESS);
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public JsonResponse loginUser(@RequestBody @Valid LoginForm loginForm) throws Exception {
        User user = userService.login(loginForm);
        String token = jwtTokenProvider.createToken(user.getUserId(), user.getRoles());
        return JsonResponse.UserInfoWithToken(API_STATUS.SUCCESS, user, token);
    }

    @ApiOperation(value = "유저 정보 조회")
    @GetMapping("/users/info/{userId}")
    public JsonResponse findUserInfo(@PathVariable String userId) throws Exception {
        User user = userService.findUserByUserId(userId);
        return JsonResponse.UserInfo(API_STATUS.SUCCESS, user);
    }

    @ApiOperation(value = "유저 정보 변경")
    @PostMapping("/users/update")
    public JsonResponse updateUser(@RequestBody @Valid UserForm userForm) throws Exception {
        userService.updateUserInfo(userForm);
        return new JsonResponse(API_STATUS.SUCCESS);
    }

    @ApiOperation(value = "유저 삭제")
    @GetMapping("/users/delete/{userId}")
    public JsonResponse deleteUser(@PathVariable String userId) throws Exception {
        userService.deleteUser(userId);
        return new JsonResponse(API_STATUS.SUCCESS);
    }

}
