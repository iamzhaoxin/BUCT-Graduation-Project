package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 8:26
 */
@SpringBootTest
public class MenuTest {

    @Test
    @Transactional
    void addMenuTest(){
        /*Menu menu =new Menu(1,"1","预算申请","🔧",-1,1,"一级菜单，第一位置");*/
        Menu menu =new Menu(-1,"0","测试",
                "null",-1,1,"插入测试");
        assert menu.insert():"menu.insert()";
    }

    @Test
    void selectTest(){
        assert new Menu().selectAll()!=null:"menu.selectAll()";
    }
}
