package kt.com.membership.service;

import kt.com.membership.domain.Membership;
import kt.com.membership.domain.User;
import kt.com.membership.exception.AlreadySignupMembership;
import kt.com.membership.exception.InvalidUserIdException;
import kt.com.membership.repository.MembershipRepository;
import kt.com.membership.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final UserRepository userRepository;

    public void signUpMembership(String userId) throws Exception {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new InvalidUserIdException());
        if (user.alreadyMembershipUser()){
            throw new AlreadySignupMembership();
        }
        user.signUpMembership();
        Membership membership = Membership.createMembership(user);
        userRepository.save(user);
        membershipRepository.save(membership);
    }
}
