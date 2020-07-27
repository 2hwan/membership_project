package kt.com.membership.service;

import kt.com.membership.domain.Item;
import kt.com.membership.dto.ItemForm;
import kt.com.membership.exception.DuplicateItemException;
import kt.com.membership.exception.InvalidItemException;
import kt.com.membership.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * Create
     */
    @Transactional
    public void addItem(ItemForm itemForm) throws Exception{
        checkDuplicateItem(itemForm.getName());
        itemRepository.save(Item.createItem(itemForm));
    }

    public void checkDuplicateItem(String name) throws Exception {
        if(itemRepository.existsByName(name)){
            throw new DuplicateItemException();
        }
    }

    /**
     * Read
     * */
    public List<Item> itemList(){
        return itemRepository.findAll();
    }

    public Item itemInfo(String name) throws Exception{
        return itemRepository.findByName(name).orElseThrow(()->new InvalidItemException());
    }

    /**
     * Update
     * */
    @Transactional
    public void updateItem(ItemForm itemForm) throws Exception{
        Item item = itemRepository.findByName(itemForm.getName()).orElseThrow(() -> new InvalidItemException());
        item.updateItem(itemForm);
        itemRepository.save(item);
    }

    /**
     * Delete
     * */
    public void deleteItem(String name) throws Exception{
        Item item = itemRepository.findByName(name).orElseThrow(() -> new InvalidItemException());
        itemRepository.delete(item);
    }
}
