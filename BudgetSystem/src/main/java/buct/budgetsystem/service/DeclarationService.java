package buct.budgetsystem.service;

import buct.budgetsystem.dao.DeclarationDao;
import buct.budgetsystem.dao.DeclarationDetailDao;
import buct.budgetsystem.pojo.entity.Declaration;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DeclarationService extends ServiceImpl<DeclarationDao,Declaration> {
//    private final DeclarationDao declarationDao;
//    private final DeclarationDetailDao declarationDetailDao;
//
//    public DeclarationService(DeclarationDao declarationDao, DeclarationDetailDao declarationDetailDao) {
//        this.declarationDao = declarationDao;
//        this.declarationDetailDao = declarationDetailDao;
//    }
//
//    public boolean insertDecalration(Declaration declaration){
//        // 用MP里的saveOrUpdate代替
//        return true;
//    }
}
