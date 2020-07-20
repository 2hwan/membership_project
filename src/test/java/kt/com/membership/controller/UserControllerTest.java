package kt.com.membership.controller;

import kt.com.membership.domain.User;
import kt.com.membership.dto.LoginForm;
import kt.com.membership.dto.UserForm;
import kt.com.membership.exception.DuplicateUserException;
import kt.com.membership.exception.InvalidPasswordException;
import kt.com.membership.exception.InvalidUserIdException;
import kt.com.membership.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Test
    public void signUpUser() throws Exception {
        //given
        UserForm userForm = new UserForm();
        userForm.setUserId("test_id");
        userForm.setPassword("test_password");
        userForm.setName("test_name");
        userForm.setEmail("test@test.com");
        userForm.setPhoneNumber("010-0000-1111");
        userForm.setCallProd("80요금제");
        userController.signUpUser(userForm);

        //when
        User findUser = userService.findUserByUserId("test_id");

        //then
        assertEquals("test_id", findUser.getUserId());
        assertEquals("test_name", findUser.getName());
        assertEquals("test@test.com", findUser.getEmail());
    }

    @Test
    public void signUpDuplicateUserExpectedDuplicateUserException() throws Exception {
        //given
        UserForm userForm = new UserForm();
        userForm.setUserId("test_id");
        userForm.setPassword("test_password");
        userForm.setName("test_name");
        userForm.setEmail("test@test.com");
        userForm.setPhoneNumber("010-0000-1111");
        userForm.setCallProd("80요금제");
        userController.signUpUser(userForm);

        //when
        //then
        assertThrows(DuplicateUserException.class, () -> {
            userController.signUpUser(userForm);
        });
    }

    @Test
    void loginUser() throws Exception {
        //given
        signUpUser();
        LoginForm loginForm = new LoginForm();
        loginForm.setUserId("test_id");
        loginForm.setPassword("test_password");

        //when
        User user = userService.login(loginForm);

        //then
        assertEquals(user.getUserId(), loginForm.getUserId());
        assertEquals(user.getPassword(), loginForm.getPassword());
    }

    @Test
    void loginInvalidUserIdExpectedInvalidUserIdException() throws Exception {
        //given
        signUpUser();
        LoginForm loginForm = new LoginForm();
        loginForm.setUserId("test_invalid_id");
        loginForm.setPassword("test_password");

        //when
        //then
        assertThrows(InvalidUserIdException.class, () -> {
            userService.login(loginForm);
        });
    }

    @Test
    void loginInvalidPasswordExpectedInvalidPasswordException() throws Exception {
        //given
        signUpUser();
        LoginForm loginForm = new LoginForm();
        loginForm.setUserId("test_id");
        loginForm.setPassword("test_invalid_password");

        //when
        //then
        assertThrows(InvalidPasswordException.class, () -> {
            userService.login(loginForm);
        });
    }

    @Test
    void findUserInfoByUserId() throws Exception {
        //given
        signUpUser();

        //when
        User user = userService.findUserByUserId("test_id");

        //then
        assertEquals("test_id", user.getUserId());
        assertEquals("test_name", user.getName());
        assertEquals("test@test.com", user.getEmail());
    }

    @Test
    void findUserInfoByInvalidUserIdExpectedInvalidUserIdException() {
        assertThrows(InvalidUserIdException.class, () -> {
            userService.findUserByUserId("test_id");
        });
    }

    @Test
    void updateUserInfo() throws Exception {
        //given
        signUpUser();
        UserForm userForm = new UserForm();
        userForm.setUserId("test_id");
        userForm.setPassword("change_password");
        userForm.setName("change_name");
        userForm.setEmail("change@change.com");
        userForm.setPhoneNumber("010-9999-9999");
        userForm.setCallProd("90요금제");

        //when
        userService.updateUserInfo(userForm);
        User findUser = userService.findUserByUserId("test_id");
        //then
        assertEquals("test_id",findUser.getUserId());
        assertEquals("change_password",findUser.getPassword());
        assertEquals("change_name",findUser.getName());
        assertEquals("change@change.com",findUser.getEmail());
        assertEquals("010-9999-9999",findUser.getPhoneNumber());
        assertEquals("90요금제",findUser.getCallProd());
    }

    @Test
    void updateInvalidUserExpectedInvalidUserIdException() throws Exception {
        //given
        signUpUser();
        UserForm userForm = new UserForm();
        userForm.setUserId("invalid_test_id");
        userForm.setPassword("change_password");
        userForm.setName("change_name");
        userForm.setEmail("change@change.com");
        userForm.setPhoneNumber("010-9999-9999");
        userForm.setCallProd("90요금제");
        //when
        //then
        assertThrows(InvalidUserIdException.class, ()->{
           userService.updateUserInfo(userForm);
        });
    }

    @Test
    void deleteUser() throws Exception {
        //given
        signUpUser();

        //when
        userService.deleteUser("test_id");

        //then
        assertThrows(InvalidUserIdException.class, () -> {
            userService.findUserByUserId("test_id");
        });
    }

    @Test
    void deleteInvalidUserIdExpectedInvalidUserIdException(){
        //given
        //when
        //then
        assertThrows(InvalidUserIdException.class, ()->{
            userService.deleteUser("test_id");
        });
    }
}