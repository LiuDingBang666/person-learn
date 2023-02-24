package icu.liuwisdom.admin.query;

import icu.liuwisdom.core.page.PageRequest;
import icu.liuwisdom.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@ApiModel("通知-查询")
@Data
public class SysNoticeQuery extends PageRequest implements Serializable {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "状态： 1=暂存 2=发布 3=禁用")
    private Integer status;

    @ApiModelProperty(value = "通知类型： 1=轮播图 2=公告")
    private Integer type;

    @ApiModelProperty(value = "范围: 1=全部 2=个人 3=所有部门 4=指定部门")
    private Integer range;

    @ApiModelProperty(value = "发布时间")
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    private LocalDateTime publishTime;

}