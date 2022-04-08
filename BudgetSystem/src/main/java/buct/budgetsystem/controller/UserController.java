package buct.budgetsystem.controller;

import buct.budgetsystem.dao.RoleMenuDao;
import buct.budgetsystem.pojo.domain.MyUserDetails;
import buct.budgetsystem.pojo.entity.Menu;
import buct.budgetsystem.pojo.entity.User;
import buct.budgetsystem.pojo.vo.Result;
import buct.budgetsystem.service.MenuService;
import buct.budgetsystem.service.UserService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/4/1 23:32
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final RoleMenuDao roleMenuDao;
    private final MenuService menuService;
    private final UserService userService;
    UserController(RoleMenuDao roleMenuDao, MenuService menuService, UserService userService) {
        this.roleMenuDao=roleMenuDao;
        this.menuService=menuService;
        this.userService = userService;
    }

    @GetMapping
    public User getUser(){
        return ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

    /**
     * 根据当前登录用户（的session）查询对应菜单权限
     * @return 菜单（权限）列表
     */
    @GetMapping("/menus")
    public List<Menu> selectMenuCurUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=userDetails.getUser();
        int roleId= user.getRoleId();
        List<Integer> menuIds = roleMenuDao.getMenusByRoleId(roleId);
        return menuService.listByIds(menuIds);
    }

    @GetMapping("/all")
    public Result getAllUser(int pageNumber, int pageSize, HttpServletRequest request){
//        String token = request.getParameter("token");
//        if(token ==null){
//            //未登录
//            return new Result(419, "no token",null,null);
//        }
//        User user= JSON.parseObject(token,User.class);
        return new Result(200,"response success",userService.getPage(pageNumber,pageSize),null);
    }
}
