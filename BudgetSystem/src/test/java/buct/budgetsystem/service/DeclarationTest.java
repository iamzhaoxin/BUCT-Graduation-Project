package buct.budgetsystem.service;

import buct.budgetsystem.pojo.entity.Declaration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class DeclarationTest {
    @Autowired
    DeclarationService declarationService;

    @Test
    void getIdsByUserIdTest(){
        Integer[] ids=declarationService.getIdsByUserId(2018040436);
        System.out.println(Arrays.toString(ids));
    }

    @Test
    void getDeclarationsByUserIdTest(){
        Declaration[] declarations=declarationService.getDeclarationsByUserId(2018040436);
        for(Declaration de:declarations){
            System.out.println(de);
        }
    }

    @Test
    void getDeclarationByUserIdTest(){
        Declaration declaration=declarationService.getById(2);
        System.out.println(declaration);
    }
}
