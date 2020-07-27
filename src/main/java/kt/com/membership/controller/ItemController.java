package kt.com.membership.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kt.com.membership.domain.Item;
import kt.com.membership.dto.API_STATUS;
import kt.com.membership.dto.ItemForm;
import kt.com.membership.dto.JsonResponse;
import kt.com.membership.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = {"3.item"})
@Controller
@RequiredArgsConstructor
@ResponseBody
public class ItemController {

    private final ItemService itemService;

    @ApiOperation(value = "아이템 추가")
    @PostMapping("/items/new")
    public JsonResponse addItem(@RequestBody @Valid ItemForm itemForm) throws Exception {
        itemService.addItem(itemForm);
        return new JsonResponse(API_STATUS.SUCCESS);
    }

    @ApiOperation(value = "아이템 목록 조회")
    @GetMapping("/items/info")
    public JsonResponse itemList(){
        List<Item> items = itemService.itemList();
        return JsonResponse.ItemList(API_STATUS.SUCCESS,items);
    }

    @ApiOperation(value = "아이템 상세 조회")
    @GetMapping("/items/info/{name}")
    public JsonResponse itemInfo(@PathVariable String name) throws Exception {
        Item item = itemService.itemInfo(name);
        return JsonResponse.ItemInfo(API_STATUS.SUCCESS,item);
    }

    @ApiOperation(value = "아이템 변경")
    @PostMapping("/items/update")
    public JsonResponse updateItem(@RequestBody @Valid ItemForm itemForm) throws Exception {
        itemService.updateItem(itemForm);
        return new JsonResponse(API_STATUS.SUCCESS);
    }

    @ApiOperation(value = "아이템 삭제")
    @GetMapping("/items/delete/{name}")
    public JsonResponse deleteItem(@PathVariable String name) throws Exception {
        itemService.deleteItem(name);
        return new JsonResponse(API_STATUS.SUCCESS);
    }
}
