package icu.liuwisdom.admin.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import icu.liuwisdom.admin.vo.SysDeptVo;
import icu.liuwisdom.core.modal.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 机构管理
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("机构管理")
public class SysDept extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构名称
     */
    @ApiModelProperty("机构名称")
    private String name;

    /**
     * 上级机构ID，一级机构为0
     */
    @ApiModelProperty("上级机构ID")
    private String parentId;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @ApiModelProperty("是否删除")
    @TableLogic
    private Integer delFlag;


    public SysDeptVo toVo() {
        SysDeptVo vo = new SysDeptVo();
        vo.setId(this.getId());
        vo.setName(this.name);
        vo.setParentId(this.parentId);
        vo.setOrderNum(this.orderNum);
        vo.setCreateBy(this.getCreateBy());
        vo.setCreateTime(this.getCreateTime());
        vo.setLastUpdateBy(this.getLastUpdateBy());
        vo.setLastUpdateTime(this.getLastUpdateTime());
        vo.setDelFlag(this.delFlag);
        return vo;
    }
}
