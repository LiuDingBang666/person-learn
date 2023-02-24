package icu.liuwisdom.admin.vo;

import icu.liuwisdom.admin.entity.SysNotice;
import icu.liuwisdom.admin.entity.SysNoticeRange;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("通知VO")
@Data
public class SysNoticeVo extends SysNotice implements Serializable {
    @ApiModelProperty("通知范围信息")
    private List<SysNoticeRange> ranges;
}