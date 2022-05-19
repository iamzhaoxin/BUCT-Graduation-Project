package buct.budgetsystem.service;


import buct.budgetsystem.dao.UnitDao;
import buct.budgetsystem.pojo.entity.Unit;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UnitService extends ServiceImpl<UnitDao, Unit> {

    public String getIdByName(String unitName){
        // fixme 假返回值
        return "000";
    }
}
