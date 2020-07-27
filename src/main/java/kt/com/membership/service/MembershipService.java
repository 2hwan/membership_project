package kt.com.membership.service;

import kt.com.membership.domain.Membership;
import kt.com.membership.domain.User;
import kt.com.membership.exception.AlreadySignupMembership;
import kt.com.membership.exception.InvalidUserIdException;
import kt.com.membership.exception.NotMembershipUser;
import kt.com.membership.repository.MembershipRepository;
import kt.com.membership.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final UserRepository userRepository;

    /**
     * Create
     * */
    @Transactional
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

    /**
     * Read
     * */
    @Transactional
    public Membership findMembershipByUserId(String userId)  throws Exception {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new InvalidUserIdException());
        return membershipRepository.findByUser(user).orElseThrow(() -> new NotMembershipUser());
    }

    /**
     * Update
     * */
}
