package icu.liuwisdom.admin.dto;

import icu.liuwisdom.admin.entity.SysNotice;
import icu.liuwisdom.admin.entity.SysNoticeRange;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统通知DTO")
public class SysNoticeDto extends SysNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("通知范围信息")
    private List<SysNoticeRange> ranges;

}
