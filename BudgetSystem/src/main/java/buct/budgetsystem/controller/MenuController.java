package buct.budgetsystem.controller;

import buct.budgetsystem.pojo.entity.Menu;
import buct.budgetsystem.service.MenuService;
import buct.budgetsystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/4/1 23:34
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;
    MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> selectMenuAll(){
        return menuService.list();
    }

}
