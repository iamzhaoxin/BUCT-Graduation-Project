package buct.budgetsystem.dao;

import buct.budgetsystem.dao.RoleMenuDao;
import buct.budgetsystem.pojo.entity.RoleMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 8:49
 */
@SpringBootTest
public class RoleMenuTest {

    @Test
    @Transactional
    void addRoleMenuTest(){
        RoleMenu roleMenu = new RoleMenu(-1,0,1);
        assert roleMenu.insert();
    }

    @Test
    void selectByRoleIdTest(@Autowired RoleMenuDao roleMenuDao){
        List<Integer> menus = roleMenuDao.getMenusByRoleId(0);
        System.out.println(menus);
        assertNotNull(menus,"getMenusByRoleId()");
    }

}
