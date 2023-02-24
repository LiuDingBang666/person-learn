package icu.liuwisdom.admin.entity;

import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 通知范围表
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SysNoticeRange对象", description = "通知范围表")
public class SysNoticeRange extends BaseModel implements Serializable {


    @ApiModelProperty(value = "通知id")
    private String fkNoticeId;

    @ApiModelProperty(value = "用户id")
    private String fkUserId;

    @ApiModelProperty(value = "部门id")
    private String fkDeptId;

    @ApiModelProperty(value = "范围: 1=全部 2=个人 3=所有部门 4=指定部门")
    private Integer noticeRange;

    @ApiModelProperty(value = "备注信息")
    private String remarks;


}
