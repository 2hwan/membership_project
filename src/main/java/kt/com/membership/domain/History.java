package kt.com.membership.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_id")
    private Membership membership;

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

//    private String type;

    public History() {
    }

    public History(User user, Membership membership, Item item, int usingPoint) {
        this.user = user;
        this.membership = membership;
        this.item = item;
        this.usingPoint = usingPoint;
        this.remainPoint = membership.getAvailablePoint();
        this.previousPoint = this.remainPoint + usingPoint;
        this.usingDate = LocalDateTime.now().plusHours(9);
    }

    //==생성 메소드==//
    public static History createHistory(User user, Membership membership, Item item, int usingPoint) {
        return new History(user, membership, item, usingPoint);
    }

}
