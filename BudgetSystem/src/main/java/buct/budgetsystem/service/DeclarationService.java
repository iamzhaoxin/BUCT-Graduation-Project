package buct.budgetsystem.service;

import buct.budgetsystem.dao.DeclarationDao;
import buct.budgetsystem.dao.DeclarationDetailDao;
import buct.budgetsystem.pojo.entity.Declaration;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DeclarationService extends ServiceImpl<DeclarationDao,Declaration> {
    private final DeclarationDao declarationDao;
    private final DeclarationDetailDao declarationDetailDao;

    public DeclarationService(DeclarationDao declarationDao, DeclarationDetailDao declarationDetailDao) {
        this.declarationDao = declarationDao;
        this.declarationDetailDao = declarationDetailDao;
    }

    public Integer[] getIdsByUserId(Integer userId){
        return declarationDao.getIdsByUserId(userId);
    }

    public Declaration[] getDeclarationsByUserId(Integer userId){
        return declarationDao.getDeclarationsByUserId(userId);
    }



}
