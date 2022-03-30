package buct.budgetsystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/29 22:26
 */
@SpringBootTest
public class UserServiceTest {

    @Test
    void getUserById(@Autowired UserService userService){
        System.out.println(userService.getById(2018040436));
    }
}
