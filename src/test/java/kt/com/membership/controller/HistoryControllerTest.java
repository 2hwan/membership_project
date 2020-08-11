package kt.com.membership.controller;

import kt.com.membership.domain.History;
import kt.com.membership.domain.Item;
import kt.com.membership.domain.Membership;
import kt.com.membership.domain.User;
import kt.com.membership.repository.HistoryRepository;
import kt.com.membership.service.ItemService;
import kt.com.membership.service.MembershipService;
import kt.com.membership.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class HistoryControllerTest {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    UserService userService;

    @Autowired
    MembershipService membershipService;

    @Autowired
    ItemService itemService;

    @Test
    @Rollback(false)
    public void addHistory() throws Exception {
        String userId = "dbstjdwo1000";
        User user = userService.findUserByUserId(userId);
        Membership membership = membershipService.findMembershipByUserId(userId);
        Item item = itemService.itemInfo("요기요");
        History history = History.createHistory(user, membership, item, 1000);

        historyRepository.save(history);

    }

}