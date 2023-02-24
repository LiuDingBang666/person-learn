package icu.liuwisdom.admin.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SysNotice对象", description = "通知表")
public class SysNotice extends BaseModel implements Serializable {


    @ApiModelProperty(value = "标题", required = true)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "阅读量")
    private Integer readNum;

    @ApiModelProperty(value = "附件,多个已逗号分割")
    private String attachment;

    @ApiModelProperty(value = "状态： 1=暂存 2=发布 3=禁用", required = true)
    @NotNull(message = "状态不能为空")
    private Integer status;

    @ApiModelProperty(value = "通知类型： 1=轮播图 2=公告", required = true)
    @NotNull(message = "通知类型不能为空")
    private Integer type;

    @ApiModelProperty(value = "范围: 1=全部 2=个人 3=所有部门 4=指定部门", required = true)
    @NotNull(message = "范围不能为空")
    private Integer noticeRange;

    @ApiModelProperty(value = "发布时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    @TableLogic
    private Integer delFlag;


}
