package icu.liuwisdom.business.entity;

import icu.liuwisdom.business.vo.LogRecordMessageVo;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 日志留言回复表
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "LogRecordMessage对象", description = "日志留言回复表")
public class LogRecordMessage extends BaseModel {


    @ApiModelProperty(value = "日志记录id", required = true)
    @NotEmpty(message = "日志记录id不能为空")
    private String fkLogRecord;

    @ApiModelProperty(value = "上级留言")
    private String parentId;

    @ApiModelProperty(value = "留言内容", required = true)
    @NotEmpty(message = "留言内容不能为空")
    private String content;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    public LogRecordMessageVo toVo() {
        LogRecordMessageVo vo = new LogRecordMessageVo();
        vo.setId(this.getId());
        vo.setFkLogRecord(this.getFkLogRecord());
        vo.setContent(this.getContent());
        vo.setRemarks(this.getRemarks());
        vo.setParentId(this.getParentId());
        vo.setCreateBy(this.getCreateBy());
        vo.setCreateTime(this.getCreateTime());
        vo.setLastUpdateBy(this.getLastUpdateBy());
        vo.setLastUpdateTime(this.getLastUpdateTime());
        return vo;
    }

}
