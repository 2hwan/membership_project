package kt.com.membership.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class MembershipHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_membership_id")
    private UserMembership userMembership;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private int previousPoint;

    @Column
    private int usingPoint;

    @Column
    private int remainPoint;

    LocalDateTime usingDate;


}
