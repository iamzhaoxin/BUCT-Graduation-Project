package buct.budgetsystem;

import org.activiti.engine.RepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BudgetSystemApplicationTests {

    @Autowired
    RepositoryService repositoryService;
    @Test
    void contextLoads() {
        System.out.println(repositoryService);
    }

}
