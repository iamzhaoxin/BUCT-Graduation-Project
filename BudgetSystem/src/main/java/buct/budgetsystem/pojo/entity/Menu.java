package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.Set;

/**
 * 导航（权限）
 * 数据库表：ys_menu
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends Model<Menu> {

    /**
     * 导航id
     */
    @TableId
    private Integer menuId;
    /**
     * 是否启用
     */
    private String menuState;
    /**
     * 导航名称
     */
    private String menuText;
    /**
     * 导航图标
     */
    private String menuIcon;
    /**
     * 上一级导航id
     */
    private int menuSuperId;
    /**
     * 导航排序
     */
    private float menuSort;
    /**
     * 导航说明
     */
    private String menuDescription;
}
