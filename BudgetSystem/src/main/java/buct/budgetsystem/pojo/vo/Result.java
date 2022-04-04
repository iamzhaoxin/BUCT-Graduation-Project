package buct.budgetsystem.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @About: 封装返回给前端的对象
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;
    private String message;
}
