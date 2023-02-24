package icu.liuwisdom.core.modal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础模型
 *
 * @author ldb
 * @ClassName BaseModel.java
 * @Data 2022-02-21 11:20
 */
@ApiModel("基础模型")
@Data
public class BaseModel implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty("主键id")
    private String id;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建人")
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建人id")
    private String fkCreateUserId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty("最后修改人")
    private String lastUpdateBy;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty("修改人id")
    private String fkUpdateUserId;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty("最后修改时间")
    private LocalDateTime lastUpdateTime;
}
