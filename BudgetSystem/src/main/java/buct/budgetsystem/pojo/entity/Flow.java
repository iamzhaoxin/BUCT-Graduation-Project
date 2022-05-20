package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * 审核流程
 * 数据库表：ys_flow
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flow extends Model<Flow> {
    /**
     * 审核任务id
     */
    @TableId
    private Integer flowId;
    /**
     * 经费申请编号
     */
    private Integer declarationId;
    /**
     * 审核人id
     */
    private String userId;
    /**
     * 审核人姓名
     */
    private String userName;
    /**
     * 审核日期
     */
    private String flowDate;
    /**
     * 审核意见
     */
    private String flowOpinion;
    /**
     * 审核状态： 未审  审批中  驳回 通过审批
     */
    private String flowState;

}
