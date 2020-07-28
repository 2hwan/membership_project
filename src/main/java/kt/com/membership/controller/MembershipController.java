package kt.com.membership.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kt.com.membership.domain.Membership;
import kt.com.membership.dto.API_STATUS;
import kt.com.membership.dto.JsonResponse;
import kt.com.membership.dto.PointForm;
import kt.com.membership.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"2.Membership"})
@Controller
@RequiredArgsConstructor
@ResponseBody
@CrossOrigin
public class MembershipController {

    private final MembershipService membershipService;

    @ApiOperation(value = "멤버십 가입")
    @GetMapping("/membership/signup/{userId}")
    public JsonResponse signUpMembership(@PathVariable String userId) throws Exception {
        membershipService.signUpMembership(userId);
        return new JsonResponse(API_STATUS.SUCCESS);
    }

    @ApiOperation(value = "멤버십 정보 조회")
    @GetMapping("/membership/info/{userId}")
    public JsonResponse membershipInfo(@PathVariable String userId) throws Exception {
        Membership membership = membershipService.findMembershipByUserId(userId);
        return JsonResponse.MembershipInfo(API_STATUS.SUCCESS, membership);
    }

    @ApiOperation(value = "멤버십 포인트 사용")
    @PostMapping("/membership/point")
    public JsonResponse usePoint(@RequestBody @Valid PointForm pointForm) throws Exception {
        membershipService.usePoint(pointForm);
        return new JsonResponse(API_STATUS.SUCCESS);
    }

//   todo @ApiOperation(value = "멤버십 vip count")

//   todo @ApiOperation(value = "멤버십 vvip count")


}
