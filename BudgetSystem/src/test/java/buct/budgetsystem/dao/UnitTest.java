package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Unit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 14:53
 */
@SpringBootTest
public class UnitTest {

    @Test
    @Transactional
    void addUnitTest(){
        Unit unit = new Unit("-1","testUnit","-1",
                "1","","2018040436","赵鑫");
        assert unit.insert():"unit.insert()";
    }

    @Test
    void selectTest(){
        List<Unit> units = new Unit().selectAll();
        System.out.println(units);
        assertNotNull(units,"Unit().selectAll()");
    }

    @Test
    void deleteUnitTest(){
        Unit unit = new Unit();
        unit.setUnitId("1000");
        unit.deleteById();
    }
}
