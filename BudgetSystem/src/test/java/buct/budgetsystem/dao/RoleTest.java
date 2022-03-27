package buct.budgetsystem.dao;

import buct.budgetsystem.dao.RoleDao;
import buct.budgetsystem.pojo.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 23:51
 */
@SpringBootTest
public class RoleTest {

    @Test
    @Transactional
    void addRoleTest(){
//        Role role=new Role(0,"管理员","系统管理员");
        Role role=new Role(-1,"测试","插入测试");
        assert role.insert():"role.insert()";
    }

    @Test
    void selectTest(){
        assert new Role().selectAll()!=null:"Role().selectAll()";
    }

}
