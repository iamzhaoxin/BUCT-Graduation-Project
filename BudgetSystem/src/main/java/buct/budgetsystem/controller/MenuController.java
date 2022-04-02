package buct.budgetsystem.controller;

import buct.budgetsystem.pojo.entity.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/4/1 23:34
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public List<Menu> selectMenuAll(){
        return new Menu().selectList(null);
    }

}
