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

    private int price;

    private int monthCount;

    private String name;

    private String category;

    public Item(){}

    public Item(ItemForm itemForm){
        this.price = itemForm.getPrice();
        this.monthCount = itemForm.getMonthCount();
        this.name = itemForm.getName();
        this.category = itemForm.getCategory();
    }

    //==생성 메소드==//
    public static Item createItem(ItemForm itemForm){
        return new Item(itemForm);
    }

    //==비지니스 로직==//
    public void updateItem(ItemForm itemForm) {
        this.price = itemForm.getPrice();
        this.category = itemForm.getCategory();
        this.monthCount = itemForm.getMonthCount();
    }
}
