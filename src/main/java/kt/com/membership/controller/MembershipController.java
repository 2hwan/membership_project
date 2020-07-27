package kt.com.membership.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kt.com.membership.domain.Membership;
import kt.com.membership.dto.API_STATUS;
import kt.com.membership.dto.JsonResponse;
import kt.com.membership.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = {"2.Membership"})
@Controller
@RequiredArgsConstructor
@ResponseBody
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
        return JsonResponse.MembershipInfo(API_STATUS.SUCCESS,membership);
    }

//   todo @ApiOperation(value = "멤버십 포인트 사용")

//   todo @ApiOperation(value = "멤버십 vip count")

//   todo @ApiOperation(value = "멤버십 vvip count")



}
