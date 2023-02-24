package icu.liuwisdom.admin.entity;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 消息表
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ApiModel(value = "SysMessage对象", description = "消息表")
public class SysMessage extends BaseModel implements Serializable {

    @ApiModelProperty(value = "主表id", required = true)
    @NotEmpty(message = "主表id不能为空")
    private String fkTargetId;

    @ApiModelProperty(value = "用户id", required = true)
    @NotEmpty(message = "用户id不能为空")
    private String fkUserId;

    @ApiModelProperty(value = "状态: 1=待查看 2=已查看 3=已处理", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "消息类型")
    private String type;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    /**
     * 快捷创建消息
     *
     * @param name       消息名称
     * @param fkTargetId 关联主表id
     * @param fkUserId   接收用户
     * @param type       消息类型
     * @author LDB
     * @date 2022-12-18
     **/
    public SysMessage(String name, String fkTargetId, String fkUserId, String type) {
        this.status = 1;
        this.fkTargetId = fkTargetId;
        this.fkUserId = fkUserId;
        this.type = type;
        this.remarks = name;
    }
}
