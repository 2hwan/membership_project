package kt.com.membership.service;

import kt.com.membership.domain.User;
import kt.com.membership.dto.LoginForm;
import kt.com.membership.dto.UserForm;
import kt.com.membership.exception.DuplicateUserException;
import kt.com.membership.exception.InvalidUserIdException;
import kt.com.membership.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /***
     * Create
     * */
    @Transactional
    public void signUpUser(UserForm userForm) throws Exception {
        validateDuplicateId(userForm.getUserId());
        userRepository.save(User.createUser(userForm));
    }

    private void validateDuplicateId(String userId) throws Exception {
        if(userRepository.existsByUserId(userId)){
            throw new DuplicateUserException();
        }
    }

    /**
     * Read
     * */
    public User login(LoginForm loginForm) throws Exception {
        User user = userRepository.findByUserId(loginForm.getUserId()).orElseThrow(() -> new InvalidUserIdException());
        user.checkPassword(loginForm);
        return user;
    }

    public User findUserByUserId(String userId) throws Exception {
        return userRepository.findByUserId(userId).orElseThrow(() -> new InvalidUserIdException());
    }

    /***
     * Update
     */
    @Transactional
    public void updateUserInfo(UserForm userForm) throws Exception {
        User user = userRepository.findByUserId(userForm.getUserId()).orElseThrow(() -> new InvalidUserIdException());
        user.updateUserInfo(userForm);
        userRepository.save(user);
    }


    /**
     * Delete
     * */
    @Transactional
    public void deleteUser(String userId) throws Exception {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new InvalidUserIdException());
        userRepository.delete(user);
    }

}
