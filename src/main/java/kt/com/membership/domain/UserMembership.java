package kt.com.membership.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class UserMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long userMembershipId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private int availablePoint;

    @Column
    private int vipChoiceCount;

    @Column
    private int vvipChoiceCount;


    @Column(length = 20)
    private String cardNumber;

    @Column
    LocalDateTime createDate;

}
