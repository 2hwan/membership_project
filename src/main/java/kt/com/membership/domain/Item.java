package kt.com.membership.domain;

import kt.com.membership.dto.ItemForm;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    private int monthCount;

    private String name;

    private String category;

    private String vvip_contents;
    private String vip_contents;
    private String normal_contents;

    private int vvip_point;
    private int vip_point;
    private int normal_point;

    private String img_path;

    public Item(){}

    public Item(ItemForm itemForm){
        this.category = itemForm.getCategory();
        this.name = itemForm.getName();
        this.img_path = itemForm.getImg_path();
        this.vvip_contents = itemForm.getVvip_contents();
        this.vip_contents = itemForm.getVip_contents();
        this.normal_contents = itemForm.getNormal_contents();
        this.vvip_point = itemForm.getVvip_point();
        this.vip_point = itemForm.getVip_point();
        this.normal_point = itemForm.getNormal_point();
        this.monthCount = itemForm.getMonthCount();
    }

    //==생성 메소드==//
    public static Item createItem(ItemForm itemForm){
        return new Item(itemForm);
    }

    //==비지니스 로직==//
    public void updateItem(ItemForm itemForm) {
        this.category = itemForm.getCategory();
        this.name = itemForm.getName();
        this.img_path = itemForm.getImg_path();
        this.vvip_contents = itemForm.getVvip_contents();
        this.vip_contents = itemForm.getVip_contents();
        this.normal_contents = itemForm.getNormal_contents();
        this.vvip_point = itemForm.getVvip_point();
        this.vip_point = itemForm.getVip_point();
        this.normal_point = itemForm.getNormal_point();
        this.monthCount = itemForm.getMonthCount();
    }
}
