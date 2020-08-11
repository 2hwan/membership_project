package kt.com.membership.service;

import kt.com.membership.domain.History;
import kt.com.membership.domain.Item;
import kt.com.membership.domain.Membership;
import kt.com.membership.domain.User;
import kt.com.membership.dto.PointForm;
import kt.com.membership.exception.*;
import kt.com.membership.repository.HistoryRepository;
import kt.com.membership.repository.ItemRepository;
import kt.com.membership.repository.MembershipRepository;
import kt.com.membership.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final UserRepository userRepository;
    private final HistoryRepository historyRepository;
    private final ItemRepository itemRepository;

    /**
     * Create
     */
    @Transactional
    public void signUpMembership(String userId) throws Exception {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new InvalidUserIdException());
        if (user.alreadyMembershipUser()) {
            throw new AlreadySignupMembership();
        }
        user.signUpMembership();
        Membership membership = Membership.createMembership(user);
        userRepository.save(user);
        membershipRepository.save(membership);
    }

    /**
     * Read
     */
    @Transactional
    public Membership findMembershipByUserId(String userId) throws Exception {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new InvalidUserIdException());
        return membershipRepository.findByUser(user).orElseThrow(() -> new NotMembershipUser());
    }

    /**
     * Update
     */
    public void usePoint(PointForm pointForm) throws Exception {
        User user = userRepository.findByUserId(pointForm.getUserId()).orElseThrow(() -> new InvalidUserIdException());
        Membership membership = membershipRepository.findByUser(user).orElseThrow(() -> new NotMembershipUser());
        Item item = itemRepository.findById(pointForm.getItemId()).orElseThrow(() -> new InvalidItemException());

        // todo - history에서 이번달 사용횟수를 가져온다. 사용횟수 >= item month count 라면 예외처리

        membership.usedPoint(pointForm.getUsingPoint());
        membershipRepository.save(membership);

        History history = History.createHistory(user, membership, item, pointForm.getUsingPoint());
        historyRepository.save(history);

    }
}
