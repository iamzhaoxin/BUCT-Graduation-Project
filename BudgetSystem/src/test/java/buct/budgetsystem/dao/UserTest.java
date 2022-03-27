package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 22:08
 */
@SpringBootTest
public class UserTest {

    @Test
    @Transactional
    void addUserTest() throws Exception {
        User user = new User(
                "-1", "新说", "130120", "赵鑫",
                new SimpleDateFormat("yyyy-MM").parse("2000-07"), "1", "13012092662",
                "zhaoxin-study@outlook.com", "1000", "北京化工大学", 0);
        assertTrue(user.insert(),"user.insert()");
    }

    @Test
    void selectAllUserTest(){
        assertNotNull(new User().selectAll(), "user.selectAll()");
    }

}
