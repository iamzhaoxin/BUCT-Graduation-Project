package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Date;

/**
 * 用户
 * 数据库表：ys_user
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends Model<User> {
    /**
     * 用户工号
     */
    @TableId
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 真实姓名
     */
    private String userNameReal;
    /**
     * 出生年月
     */
    private Date userBirthdate;
    /**
     * 性别 男（1）女（2）
     */
    private String userSex;
    /**
     * 电话
     */
    private String userCellphone;
    /**
     * 邮箱
     */
    private String userEmail;
    /**
     * 单位编号
     */
    private String unitId;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 用户角色
     */
    private Integer roleId;
}
