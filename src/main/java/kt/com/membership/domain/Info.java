package kt.com.membership.domain;

import javax.persistence.*;

@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long infoId;

    @Column
    private int callProd;

    @Column
    private int grade;

    @Column
    private int basicPoint;

    @Column
    private int vipChoiceCount;

    @Column
    private int vvipChoiceCount;


}
