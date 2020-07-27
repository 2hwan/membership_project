package kt.com.membership.domain;

import kt.com.membership.exception.NoAvailableChoiceCount;
import kt.com.membership.exception.NoAvailablePoint;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long membershipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private int availablePoint;

    @Column
    private int vipChoiceCount;

    @Column
    private int vvipChoiceCount;

    @Column
    private String grade;

    @Column(length = 20)
    private String cardNumber;

    @Column
    LocalDateTime createDate;

    public Membership() {
    }

    Membership(User user) {
        switch (user.getCallProd()) {
            case "슈퍼플랜 프리미엄":
                this.grade = "vvip";
                this.availablePoint = 100000;
                this.vipChoiceCount = 5;
                this.vvipChoiceCount = 3;
                break;
            case "슈퍼플랜 스페셜":
                this.grade = "vip";
                this.availablePoint = 80000;
                this.vipChoiceCount = 3;
                this.vvipChoiceCount = 0;
                break;
            case "슈퍼플랜 베이직":
                this.grade = "vip";
                this.availablePoint = 50000;
                this.vipChoiceCount = 3;
                this.vvipChoiceCount = 0;
                break;
            case "슈퍼플랜 슬림":
                this.grade = "일반";
                this.availablePoint = 30000;
                this.vipChoiceCount = 0;
                this.vvipChoiceCount = 0;
                break;
        }
        this.user = user;
        this.cardNumber = "0000-0000-0000-0000";
        this.createDate = LocalDateTime.now();
    }

    //==생성 메소드==//
    public static Membership createMembership(User user) {
        return new Membership(user);
    }

    public void useVipChoiceCount() throws NoAvailableChoiceCount {
        if (this.vipChoiceCount == 0) {
            throw new NoAvailableChoiceCount();
        }
        this.vipChoiceCount--;
    }

    public void useVvipChoiceCount() throws NoAvailableChoiceCount {
        if (this.vvipChoiceCount == 0) {
            throw new NoAvailableChoiceCount();
        }
        this.vvipChoiceCount--;
    }

    public void usedPoint(int usingPoint) throws NoAvailablePoint {
        if (this.availablePoint < usingPoint) {
            throw new NoAvailablePoint();
        }
        this.availablePoint -= usingPoint;
    }


}
