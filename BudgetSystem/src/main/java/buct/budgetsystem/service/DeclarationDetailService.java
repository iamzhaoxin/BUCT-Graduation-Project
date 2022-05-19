package buct.budgetsystem.service;


import buct.budgetsystem.dao.DeclarationDetailDao;
import buct.budgetsystem.pojo.entity.DeclarationDetail;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationDetailService extends ServiceImpl<DeclarationDetailDao, DeclarationDetail> {

    private final DeclarationDetailDao declarationDetailDao;

    public DeclarationDetailService(DeclarationDetailDao declarationDetailDao) {
        this.declarationDetailDao = declarationDetailDao;
    }

    public Integer getAssetIdByDeclarationId(Integer declarationId){
        return declarationDetailDao.getAssetIdByDeclarationId(declarationId);
    }

    public DeclarationDetail getDetailByDeclarationId(Integer declarationId) {
        return declarationDetailDao.getDetailByDeclarationId(declarationId);
    }
}
