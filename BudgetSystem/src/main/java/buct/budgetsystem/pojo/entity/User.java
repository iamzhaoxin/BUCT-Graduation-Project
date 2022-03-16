package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @About: 数据库表：ys_user
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {
    private String userId;
    private String userName;
    private String userPassword;
    private String userNameReal;
    private String userBirthdate;
    private String userSex;
    private String userCellphone;
    private String userEmail;
    private String unitId;
    private String unitName;
    private String roleId;
}
