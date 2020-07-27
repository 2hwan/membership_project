package kt.com.membership.controller;

import io.swagger.annotations.Api;
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

    @GetMapping("/membership/signup/{userId}")
    public JsonResponse signUpMembership(@PathVariable String userId) throws Exception {
        membershipService.signUpMembership(userId);
        return new JsonResponse(API_STATUS.SUCCESS);
    }


    //todo 멤버십 정보 확인

}
