package kt.com.membership.controller;

import kt.com.membership.domain.Membership;
import kt.com.membership.dto.UserForm;
import kt.com.membership.service.MembershipService;
import kt.com.membership.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MembershipControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    MembershipService membershipService;

    @Test
    public void signUpMembership() throws Exception {
        //given
        UserForm userForm = new UserForm();
        userForm.setUserId("test_id");
        userForm.setPassword("test_password");
        userForm.setName("test_name");
        userForm.setEmail("test@test.com");
        userForm.setPhoneNumber("010-0000-1111");
        userForm.setCallProd("슈퍼플랜 베이직");
        userController.signUpUser(userForm);

        //whe
        membershipService.signUpMembership("test_id");
        Membership membership = membershipService.findMembershipByUserId("test_id");
        //then
        assertEquals(membership.getGrade(),"vip");

    }
}